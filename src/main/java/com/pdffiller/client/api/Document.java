package com.pdffiller.client.api;

import java.util.HashMap;
import java.util.List;

import com.pdffiller.client.ApiClient;
import com.pdffiller.client.dto.DocumentInfo;
import com.pdffiller.client.dto.DocumentListResponse;
import com.pdffiller.client.dto.DocumentUploadRequest;
import com.pdffiller.client.dto.Params;
import com.pdffiller.client.exception.PdfFillerAPIException;

public class Document {
  private ApiClient apiClient;
  private String API_PATH = "/document"; 
 
  public Document(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Retrieves a list of uploaded documents.
   * @return DocumentListResponse
   */
  public DocumentListResponse retrieveDocumentList() throws PdfFillerAPIException {  
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    Object body = null;
    String method = "GET";
    return apiClient.call(API_PATH, method, queryParams, headerParams, body, DocumentListResponse.class);
  }
  
  /**
   * Create a new document template
   * Creates a new document template from url or file content.
   * @param body send file url info or file content string
   * @return CreateDocumenTemplateResponse
   */
  public DocumentInfo createDocumentTemplate(DocumentUploadRequest body) throws PdfFillerAPIException {         
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String method = "POST";
    if (body == null) {
      throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling createDocumentTemplate");
    }
    return apiClient.call(API_PATH, method, queryParams, headerParams, body, DocumentInfo.class);
  }
  
  /**
   * Create a new document template
   * Creates a new document template from url.
   * @param body send file url info or file content string
   * @return CreateDocumenTemplateResponse
   */
  public DocumentInfo getDocumentInfo (long documentId) throws PdfFillerAPIException {           
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    Object body = null;
    String method = "GET";
    return apiClient.call(API_PATH + "/" + documentId, method, queryParams, headerParams, body, DocumentInfo.class);
  }
  
}
