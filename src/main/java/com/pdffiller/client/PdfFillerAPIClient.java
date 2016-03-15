package com.pdffiller.client;

import com.pdffiller.client.auth.OAuth;
import com.pdffiller.client.dto.AuthRequest;
import com.pdffiller.client.dto.AuthResponse;
import com.pdffiller.client.dto.HttpResponse;
import com.pdffiller.client.dto.Params;
import com.pdffiller.client.exception.PdfFillerAPIException;
import com.pdffiller.client.json.Mapper;
import com.pdffiller.client.utils.MapUtils;
import com.pdffiller.client.utils.StringUtils;

import javax.net.ssl.HttpsURLConnection;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.net.ProtocolException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
/**
 * @author gene@pdffiller.com (Eugene Gorelik)
 * Main PDFFiller client class
 */
public class PdfFillerAPIClient implements ApiClient {
  private Map<String, String> headerMap = new HashMap<String, String>();
  private boolean debugging = false;
  private String [] ACCEPTS = {"application/json"};
  private String CONTENT_TYPE = "application/json";
  private String USER_AGENT = "PDfFiller-API-Client-Java";
  private String AUTHORIZATION_HEADER = "Authorization";
  private String API_URL;
  private String API_VERSION;
  private String CLIENT_ID;
  private String CLIENT_SECRET;
  private OAuth authentication;
  private final static String AUTHENTICATION_PATH = "/oauth/access_token";   
  private Mapper json = new Mapper();   

  /**
   * @param builder
   * @throws PdfFillerAPIException
   */
  private PdfFillerAPIClient(Builder builder) throws PdfFillerAPIException {   
    API_URL = builder.apiUrl;
    API_VERSION = builder.apiVersion;
    CLIENT_ID = builder.clientId;
    CLIENT_SECRET = builder.clientSecret;
    this.authenticate();
  }
  
  /**
   * Internal builder class to collect input and initiate client
   */
  public static class Builder {
	// Required parameters
	private final String clientId;
	private final String clientSecret;
	
	// Optional parameters
	private String apiUrl = "https://api.pdffiller.com";
	private String apiVersion = "v1";
	
	public Builder (String clientId, String clientSecret) throws PdfFillerAPIException{
  	  if (clientId == null || clientId.isEmpty()){
  	    throw new PdfFillerAPIException(401,"clientId parameter is required for authentication");
  	  }else{
  	     this.clientId = clientId; 	    
  	  }
  	  
  	  if (clientSecret == null || clientSecret.isEmpty()){
        throw new PdfFillerAPIException(401,"clientSecret parameter is required for authentication");
      }else{
	    this.clientSecret = clientSecret;
      }
	}
	
	public Builder apiUrl(String url){
	  apiUrl = url;
	  return this;
	}
	
	public Builder apiVersion(String version){
	  apiVersion = version;
	  return this;
	}	

	public PdfFillerAPIClient build() throws PdfFillerAPIException {
	  return new PdfFillerAPIClient(this);
	}
	
  }
  
  /**
   * Call API by sending HTTP request with the given options.
   *
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "POST", "PUT", and "DELETE"
   * @param queryParams The query parameters
   * @param body The request body object - if it is not binary, otherwise null
   * @param headerParams The header parameters
   * @param accept The request's Accept header
   * @param contentType The request's Content-Type header
   * @param returnType type of the return parameter
   * @return The response body in type of string
   */
  public <T> T call(String path, String method, List<Params> queryParams, HashMap<String, String> headerParams, Object body, Class<?> returnType) throws PdfFillerAPIException {
    if (!isAuthenticated() && path != AUTHENTICATION_PATH){
       throw new PdfFillerAPIException(401,"Client is not authenticated");
    }   

    HttpResponse response = getApiResponse(path, method, queryParams, body, headerParams);
    int statusCode = response.getCode();
    Map<String, List<String>> responseHeaders = response.getHeaders();
    String responseBody = response.getBody();

    if (statusCode == HttpsURLConnection.HTTP_OK) {
      if (returnType == null)
        return null;
      else
        if (returnType.equals(HttpResponse.class)) {
          return (T) response.getBody().toString();
        }else {
          return json.deserialize(response, returnType);
        }
    } 
      
    throw new PdfFillerAPIException(
      statusCode,
      "API HTTP response error",
      responseHeaders,
      responseBody);    
  }
  
  /**
   * Call API by sending HTTP request with the given options.
   *
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "POST", "PUT", and "DELETE"
   * @param queryParams The query parameters
   * @param body The request body object - if it is not binary, otherwise null
   * @param headerParams The header parameters
   * @param accept The request's Accept header
   * @param contentType The request's Content-Type header
   * @return Json string representing the response HTTP body
   */
  public String call(String path, String method, List<Params> queryParams, HashMap<String, String> headerParams, Object body) throws PdfFillerAPIException {
    String jsonBody = this.call(path,method,queryParams,headerParams,body, HttpResponse.class);
    return jsonBody;
  }
   
  private HttpResponse getApiResponse(String path, String method, List<Params> queryParams, Object body, Map<String, String> headerParams) throws PdfFillerAPIException {
	String querystring = "";
	if (queryParams != null){
      StringBuilder b = new StringBuilder();
      b.append("?");
      for (Params queryParam : queryParams){
        if (!queryParam.getName().isEmpty()) {
          b.append(StringUtils.escapeString(queryParam.getName()));
          b.append("=");
          b.append(StringUtils.escapeString(queryParam.getValue()));
          b.append("&");
        }
      }
      querystring = b.substring(0, b.length() - 1);
    }
    
	if (headerParams != null && headerParams.size() > 0){
	  for (String key : headerParams.keySet()) {
	      if (!headerMap.containsKey(key)) {
	        headerMap.put(key, headerParams.get(key));
	      }
	    }
	}  

    HttpResponse response = null;
    String jsonStr = json.serialize(body);

    if ("GET".equals(method)) {
      response = sendGet(API_URL + '/' + API_VERSION + path + querystring);
    } else if ("POST".equals(method)) {
      response = sendPost(jsonStr,API_URL + '/' + API_VERSION + path + querystring);    
    } else if ("PUT".equals(method)) {
      response = sendPut(jsonStr,API_URL + '/' + API_VERSION + path + querystring);    
    } else if ("DELETE".equals(method)) {
      response = sendDelete(API_URL + '/' + API_VERSION + path + querystring);    
    } else {
      throw new PdfFillerAPIException(500, "unknown method type " + method);
    }
    return response;
  }
  
  /** 
   * Obtains authentication token
   * @throws PdfFillerAPIException 
   */
  private void authenticate() throws PdfFillerAPIException {
	AuthRequest ar = new AuthRequest();
	ar.setClientId(CLIENT_ID);
	ar.setClientSecret(CLIENT_SECRET);
    AuthResponse response = this.call(AUTHENTICATION_PATH, "POST", null, null, ar, AuthResponse.class);
    authentication = new OAuth();
	authentication.setAccessToken(response.getAccessToken());
	headerMap = authentication.applyToParams(headerMap);	
  }
  
  /**
   * @param API url
   * @return HttpsURLConnection
   * @throws PdfFillerAPIException
   */
  private HttpsURLConnection getHTTPClient(String url) throws PdfFillerAPIException {
	URL obj;
	HttpsURLConnection con = null;
    try {
	  obj = new URL(url);
	  con = (HttpsURLConnection) obj.openConnection();
	  this.setAccepts(ACCEPTS).setContentType(CONTENT_TYPE).setUserAgent(USER_AGENT);
	  if (headerMap != null && headerMap.size() > 0){		
	    for (Map.Entry<String, String> entry : headerMap.entrySet()) {
		  con.setRequestProperty(entry.getKey(), entry.getValue());
	    }
	  }
    } catch(Exception e){
      e.printStackTrace();
      throw new PdfFillerAPIException("Error establishing HTTP connection to the server");
    } finally {
      if (con != null)
        con.disconnect();
    }
	return con;
  }

 
  /**
   * @param url
   * @return
   * @throws PdfFillerAPIException
   */
  private HttpResponse sendGet(String url) throws PdfFillerAPIException {
    String method = "GET";
	HttpResponse httpResponse = new HttpResponse();
	HttpsURLConnection con = getHTTPClient(url);
	BufferedReader in = null;
	Map<String, List<String>> responseHeaders;
	int responseCode;
	StringBuffer responseBody = null;

	try {
	  con.setRequestMethod(method);
	} catch (ProtocolException e) {
	  e.printStackTrace();
      throw new PdfFillerAPIException("Error setting " + method + " request method for HTTP connection: " + e.getMessage());
    }
	
	try {		
      responseCode = con.getResponseCode();
      responseHeaders = con.getHeaderFields();   	    
      InputStream stream = con.getErrorStream();
      if (stream == null) {
          stream = con.getInputStream();
      }        
      in = new BufferedReader(new InputStreamReader(stream));
   	  String inputLine;
   	  responseBody = new StringBuffer();
	  while ((inputLine = in.readLine()) != null) {
	    responseBody.append(inputLine);
	  }
	  in.close();
	} catch (IOException e) {
	  e.printStackTrace();
        throw new PdfFillerAPIException("Error sending " + method + " request to " + url + ". Message " + e.getMessage() + " Response: " + responseBody);
	} finally {
	   try {
		if (in != null)
		  in.close();
	    } catch (IOException e) {}
	}
		
	httpResponse.setBody(responseBody.toString());
	httpResponse.setCode(responseCode);
	httpResponse.setHeaders(responseHeaders);
	return httpResponse;
  }
	

  /**
   * @param body
   * @param url
   * @return
   * @throws PdfFillerAPIException
   * @throws IOException 
   */
  private HttpResponse sendPost(String body, String url) throws PdfFillerAPIException {
    String method = "POST";
	HttpResponse httpResponse = new HttpResponse();
	HttpsURLConnection con = getHTTPClient(url);
	BufferedReader in = null;
	Map<String, List<String>> responseHeaders;
	int responseCode;
	StringBuffer responseBody = null;
  
	try {
      con.setRequestMethod(method);
	} catch (ProtocolException e) {
	  e.printStackTrace();
      throw new PdfFillerAPIException("Error setting " + method + " request method for HTTP connection: " + e.getMessage());
	}
		
	try {		
      // Send post request
      con.setDoOutput(true);
      OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
      wr.write(body);
      wr.flush();
      wr.close();         
      responseCode = con.getResponseCode();
      responseHeaders = con.getHeaderFields();      
      InputStream stream = con.getErrorStream();
      if (stream == null) {
          stream = con.getInputStream();
      }    	    
      in = new BufferedReader(new InputStreamReader(stream));
      String inputLine;
      responseBody = new StringBuffer();
	  while ((inputLine = in.readLine()) != null) {
		responseBody.append(inputLine);
	  }
	  in.close();
	} catch (IOException e) {	     
	  e.printStackTrace();
      throw new PdfFillerAPIException("Error sending " + method + " request to " + url + ". Message " + e.getMessage());
	} finally {
	  try {
		if (in != null)
		  in.close();
	  } catch (IOException e) {}
    }
	
    httpResponse.setBody(responseBody.toString());
    httpResponse.setCode(responseCode);
    httpResponse.setHeaders(responseHeaders);
    return httpResponse;
  }
  
  /**
   * @param url
   * @return
   * @throws PdfFillerAPIException
   */
  private HttpResponse sendDelete(String url) throws PdfFillerAPIException {
    String method = "DELETE";
    HttpResponse httpResponse = new HttpResponse();
    HttpsURLConnection con = getHTTPClient(url);
    BufferedReader in = null;
    Map<String, List<String>> responseHeaders;
    int responseCode;
    StringBuffer responseBody;

    try {
      con.setRequestMethod(method);
    } catch (ProtocolException e) {
      e.printStackTrace();
      throw new PdfFillerAPIException("Error setting " + method + " request method for HTTP connection: " + e.getMessage());
    }
    
    try {       
      responseCode = con.getResponseCode();
      responseHeaders = con.getHeaderFields();      
      InputStream stream = con.getErrorStream();
      if (stream == null) {
          stream = con.getInputStream();
      }        
      in = new BufferedReader(new InputStreamReader(stream));
      String inputLine;
      responseBody = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        responseBody.append(inputLine);
      }
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
      throw new PdfFillerAPIException("Error sending " + method + " request to " + url + ". Message " + e.getMessage());
    } finally {
       try {
        if (in != null)
          in.close();
        } catch (IOException e) {}
    }
    
    httpResponse.setBody(responseBody.toString());
    httpResponse.setCode(responseCode);
    httpResponse.setHeaders(responseHeaders);
    return httpResponse;
  }

  /**
   * @param url
   * @return
   * @throws PdfFillerAPIException
   */
  private HttpResponse sendPut(String body, String url) throws PdfFillerAPIException {
    String method = "PUT";
    HttpResponse httpResponse = new HttpResponse();
    HttpsURLConnection con = getHTTPClient(url);
    BufferedReader in = null;
    Map<String, List<String>> responseHeaders;
    int responseCode;
    StringBuffer responseBody;
  
    try {
      con.setRequestMethod(method);
    } catch (ProtocolException e) {
      e.printStackTrace();
      throw new PdfFillerAPIException("Error setting " + method + " request method for HTTP connection: " + e.getMessage());
    }
        
    try {       
      // Send post request
      con.setDoOutput(true);
      OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
      wr.write(body);
      wr.flush();
      wr.close();    
      responseCode = con.getResponseCode();
      responseHeaders = con.getHeaderFields();            
      InputStream stream = con.getErrorStream();
      if (stream == null) {
          stream = con.getInputStream();
      }        
      in = new BufferedReader(new InputStreamReader(stream));
      String inputLine;
      responseBody = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        responseBody.append(inputLine);
      }
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
      throw new PdfFillerAPIException("Error sending " + method + " request to " + url + ". Message " + e.getMessage());
    } finally {
      try {
        if (in != null)
          in.close();
      } catch (IOException e) {}
    }
    
    httpResponse.setBody(responseBody.toString());
    httpResponse.setCode(responseCode);
    httpResponse.setHeaders(responseHeaders);
    return httpResponse;
  }
  
  /**
   * Set the User-Agent header's value (by adding to the default header map).
   */
  public PdfFillerAPIClient setUserAgent(String userAgent) {
	this.USER_AGENT = userAgent;
	this.headerMap = MapUtils.updateMap(this.headerMap, "User-Agent", userAgent);
    return this;
  }

  /**
   * @param contentType
   * @return
   */
  public PdfFillerAPIClient setContentType(String contentType) {
	this.CONTENT_TYPE = contentType;
	this.headerMap = MapUtils.updateMap(this.headerMap, "Content-Type", contentType);
	return this;
  }
	  
  /**
   * @param accepts
   * @return
   */
  public PdfFillerAPIClient setAccepts(String[] accepts) {
	this.ACCEPTS = accepts;
	this.headerMap = MapUtils.updateMap(this.headerMap, "Accepts", StringUtils.join(ACCEPTS, ","));
	return this;
  }

  /**
   * Check whether debugging is enabled for this API client.
   */
  public boolean isDebugging() {
	return debugging;
  }

  /**
   * Enable/disable debugging for this API client.
   * @param debugging To enable (true) or disable (false) debugging
   */
  public PdfFillerAPIClient setDebugging(boolean debugging) {
	this.debugging = debugging;
    return this;
  }
  
  /**
   * @return true if AUTHORIZATION_HEADER is set
   */
  private boolean isAuthenticated(){
    if (headerMap.get(AUTHORIZATION_HEADER) == null) 
      return false;
    return true;
  }

}
  

