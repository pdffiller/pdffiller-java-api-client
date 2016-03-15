package com.pdffiller.client.api;

import java.util.HashMap;
import java.util.List;

import com.pdffiller.client.ApiClient;
import com.pdffiller.client.dto.CallbackBody;
import com.pdffiller.client.dto.CallbackList;
import com.pdffiller.client.dto.DocumentInfo;
import com.pdffiller.client.dto.DocumentListResponse;
import com.pdffiller.client.dto.DocumentUploadRequest;
import com.pdffiller.client.dto.Params;
import com.pdffiller.client.exception.PdfFillerAPIException;

public class Callback {
  private ApiClient apiClient;
  private String API_PATH = "/callback"; 
 
  public Callback(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Retrieves a list of uploaded documents.
   * @return Json string - list of all callbacks 
   */
  public String listCallbacks() throws PdfFillerAPIException {  
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    Object body = null;
    String method = "GET";
    return apiClient.call(API_PATH, method, queryParams, headerParams, body);
  }
  
  /**
   * Create a new callback
   * @param body - json information about callback 
   * @return CreateDocumenTemplateResponse
   */
  public String addCallback(CallbackBody body) throws PdfFillerAPIException {         
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String method = "POST";
    if (body == null) {
      throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling addCallback");
    }
    return apiClient.call(API_PATH, method, queryParams, headerParams, body);
  }
  
  /**
   * Retrieve callback information
   * @param callbackId
   * @return Json string with callback information
   */
  public String getCallback (int callbackId) throws PdfFillerAPIException {           
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    Object body = null;
    String method = "GET";
    return apiClient.call(API_PATH + "/" + callbackId, method, queryParams, headerParams, body);
  }
  
  /**
   * Update callback information
   * @param callbackId
   * @param body - callback information json body
   * @return Json string with updated callback
   */
  public String updateCallback(int callbackId, CallbackBody body) throws PdfFillerAPIException {         
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String method = "UPDATE";
    if (body == null) {
      throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling addCallback");
    }
    return apiClient.call(API_PATH + "/" + callbackId, method, queryParams, headerParams, body);
  }
  
  /**
   * Delete callback
   * @param callbackId
   * @return Json string with confirmation
   */
  public String deleteCallback (int callbackId) throws PdfFillerAPIException {           
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    Object body = null;
    String method = "DELETE";
    return apiClient.call(API_PATH + "/" + callbackId, method, queryParams, headerParams, body);
  }
  
}
