package com.pdffiller.client.api;

import java.util.HashMap;
import java.util.List;

import com.pdffiller.client.ApiClient;
import com.pdffiller.client.dto.FillRequestBody;
import com.pdffiller.client.dto.Params;
import com.pdffiller.client.exception.PdfFillerAPIException;

public class FillRequest {
  private ApiClient apiClient;
  private String API_PATH = "/fill_request"; 
 
  public FillRequest(ApiClient apiClient) {
    this.apiClient = apiClient;
  }  
  
  /**
   * Returns a list of all document fill requests
   * @return Json String
   */
  public String listFillRequests () throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";

    return apiClient.call(API_PATH, method, queryParams, headerParams, body);
  }
  
  /**
   * Creates a new document and shares it via short url
   * @param body fill request object that needs to be added to the store
   * @return Json string
   */
  public String createFillRequest (FillRequestBody body) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String method = "POST";
    if (body == null) {
      throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling createFillRequest");
    }
    return apiClient.call(API_PATH, method, queryParams, headerParams, body);
  }
  
  /**
   * Information about created fill request item
   * @param fillRequestId Fill request Id
   * @return Json string
   */
  public String findFillRequestId (String fillRequestId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
    
    // verify the required parameter 'fillRequestId' is set
    if (fillRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'fillRequestId' when calling infoLinkToFillId");
    }
    
    // create path and map variables
    String path = API_PATH + "/" + fillRequestId;
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
  /**
   * Updates fill request item
   * @param body Fill request object that needs to be updated
   * @return Json string
   */
  public String updateLinkToFill (FillRequestBody body) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String method = "PUT";
    if (body == null) {
      throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling updateFillRequest");
    }
    return apiClient.call(API_PATH, method, queryParams, headerParams, body);    
  }
  
  /**
   * Deletes fill request item
   * @param fillRequestId Fill request Id
   * @return String
   */
  public String deleteFillRequestId (String fillRequestId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "DELETE";
    
    // verify the required parameter 'fillRequestId' is set
    if (fillRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'fillRequestId' when calling deleteLinkToFillId");
    }
    
    String path = API_PATH + "/" + fillRequestId;
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
  /**
   * List of all filled forms for the given fill request
   * @param fillRequestId Fill request Id
   * @return Json string
   */
  public String listFilledForm (String fillRequestId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
    
    // verify the required parameter 'fillRequestId' is set
    if (fillRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'fillRequestId' when calling infoLinkToFillId");
    }
    
    String path = API_PATH + "/" + fillRequestId + "/filled_form";
    return apiClient.call(path, method, queryParams, headerParams, body);    
  }
  
  /**
   * Information about specific filled form
   * @param fillRequestId Fill request Id
   * @param filledFormId Filled form Id
   * @return Json String
   */
  public String findFilledForm (String fillRequestId, String filledFormId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
        
    // verify the required parameter 'fillRequestId' is set
    if (fillRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'fillRequestId' when calling infoFilledForm");
    }
    
    // verify the required parameter 'filledFormId' is set
    if (filledFormId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'filledFormId' when calling infoFilledForm");
    }
   
    String path = API_PATH + "/" + fillRequestId + "/filled_form/" +  filledFormId;
    return apiClient.call(path, method, queryParams, headerParams, body);  
  }
  
  /**
   * Deletes filled form
   * @param fillRequestId Fill request Id
   * @param filledFormId Filled form Id
   * @return Json String
   */
  public String deleteFilledForm (String fillRequestId, String filledFormId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "DELETE";
        
    // verify the required parameter 'fillRequestId' is set
    if (fillRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'fillRequestId' when calling deleteFilledForm");
    }
    
    // verify the required parameter 'filledFormId' is set
    if (filledFormId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'filledFormId' when calling deleteFilledForm");
    }
   
    String path = API_PATH + "/" + fillRequestId + "/filled_form/" +  filledFormId;
    return apiClient.call(path, method, queryParams, headerParams, body);   
  }
  
  /**
   * Download filled PDF form
   * @param fillRequestId Fill request Id
   * @param filledFormId Filled form document Id
   * @return File content String
   */
  public String downloadSingleFilledForm (String fillRequestId, String filledFormId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
             
    // verify the required parameter 'fillRequestId' is set
    if (fillRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'fillRequestId' when calling downloadSingleFilledForm");
    }
     
    // verify the required parameter 'filledFormId' is set
    if (filledFormId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'filledFormId' when calling downloadSingleFilledForm");
    }
     
    String path = API_PATH + "/" + fillRequestId + "/filled_form/" +  filledFormId + "/download";
    return apiClient.call(path, method, queryParams, headerParams, body);  
  }
  
  /**
   * Exports filled form data in JSON format
   * @param fillRequestId Fill request Id
   * @param filledFormId Filled form document Id
   * @return String
   */
  public String exportFilledForm (String fillRequestId, String filledFormId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
             
    // verify the required parameter 'fillRequestId' is set
    if (fillRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'fillRequestId' when calling downloadSingleFilledForm");
    }
     
    // verify the required parameter 'filledFormId' is set
    if (filledFormId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'filledFormId' when calling downloadSingleFilledForm");
    }
     
    String path = API_PATH + "/" + fillRequestId + "/filled_form/" +  filledFormId + "/export";
    return apiClient.call(path, method, queryParams, headerParams, body);  
  }
  
}
