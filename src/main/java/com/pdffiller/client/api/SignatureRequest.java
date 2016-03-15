package com.pdffiller.client.api;

import java.util.*;

import com.pdffiller.client.ApiClient;
import com.pdffiller.client.dto.AddRecipientBody;
import com.pdffiller.client.dto.Params;
import com.pdffiller.client.dto.SignatureRequestBody;
import com.pdffiller.client.exception.PdfFillerAPIException;

public class SignatureRequest {
  private ApiClient apiClient;
  private String API_PATH = "/signature_request"; 
 
  public SignatureRequest(ApiClient apiClient) {
    this.apiClient = apiClient;
  }    
  
  /**
   * Retrieve a list of all document signature requests
   * @param authorization Bearer Access Token obtained from client credentials
   * @return Json String representing signature request list
   */
  public String listSignatureRequests (String authorization) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";

    return apiClient.call(API_PATH, method, queryParams, headerParams, body);
  }
  
  /**
   * Creates a new sendtosign request. Two sendtosign methods supported - sendtoeach and sendtogroup. Sendtogroup method requires envelope_name and sign_in_order parameters
   * @param body Signature request details and recipients information
   * @return String
   */
  public String createSignatureRequest (SignatureRequestBody body) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String method = "POST";
    if (body == null) {
      throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling createSignatureRequest");
    }
    return apiClient.call(API_PATH, method, queryParams, headerParams, body);
  }
  
  /**
   * Retrieve a signature request information based on the signature request ID
   * @param signatureRequestId Signature request Id
   * @return SignatureRequest
   */
  public String findSignatureRequestId (Long signatureRequestId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
    
    // verify the required parameter 'fillRequestId' is set
    if (signatureRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'fillRequestId' when calling infoLinkToFillId");
    }
    
    String path = API_PATH + "/" + signatureRequestId;
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
  /**
   * Cancel a signature request for the specified sendtosign ID
   * @param signatureRequestId Signature request Id
   * @return Json string
   */
  public String cancelSignatureRequest (String authorization, Long signatureRequestId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "DELETE";
    
    // verify the required parameter 'fillRequestId' is set
    if (signatureRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'signatureRequestId' when calling deleteLinkToFillId");
    }
    
    String path = API_PATH + "/" + signatureRequestId;
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
  /**
   * Returns a signature request certificate by signatureRequestId
   * @param signatureRequestId Signature request Id
   * @return File body download string
   */
  public String getCertificateById (Long signatureRequestId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
    
    if (signatureRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'signatureRequestId' when calling infoLinkToFillId");
    }
    
    String path = API_PATH + "/" + signatureRequestId + "/certificate";
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
  /**
   * Adds additional recipient to sendtosign request
   * @param body Adds additional recipient top signature request
   * @param signatureRequestId Signature request Id
   * @return Json String
   */
  public String addRecipient (AddRecipientBody body, Long signatureRequestId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String method = "POST";
    
    // verify the required parameter 'signatureRequestId' is set
    if (signatureRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'signatureRequestId' when calling addRecipient");
    }
    
   // verify the required parameter 'body' is set
    if (body == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter recipient body when calling addRecipient");
    }
     
    String path = API_PATH + "/" + signatureRequestId + "/recipient";
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
  /**
   * Returns information about sendtosign recipient and signature status
   * @param signatureRequestId Signature request Id
   * @param fillableTemplateId Fillable template ID
   * @return Json string
   */
  public String getRecipientStatus (Long signatureRequestId, Long recipientId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "POST";
            
    // verify the required parameter 'signatureRequestId' is set
    if (signatureRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'signatureRequestId' when calling getRecipientStatus");
    }
     
    // verify the required parameter 'fillableTemplateId' is set
    if (recipientId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'recipientId' when calling getRecipientStatus");
    }
     
    String path = API_PATH + "/" + signatureRequestId + "/recipient/" + recipientId;
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
  /**
   * Remind a sendtosign recipient about the sendtosign request
   * @param signatureRequestId Signature request Id
   * @param fillableTemplateId Fillable template ID
   * @return Json String
   */
  public String remindRecipient (Long signatureRequestId, Long recipientId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "PUT";
    
     // verify the required parameter 'signatureRequestId' is set
     if (signatureRequestId == null) {
        throw new PdfFillerAPIException(400, "Missing the required parameter 'signatureRequestId' when calling remindRecipient");
     }
     
     // verify the required parameter 'fillableTemplateId' is set
     if (recipientId == null) {
        throw new PdfFillerAPIException(400, "Missing the required parameter 'recipientId' when calling remindRecipient");
     }
     
    String path = API_PATH + "/" + signatureRequestId + "/recipient/" + recipientId + "/remind";
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
  /**
   * Retrieve a signed document by signatureRequestId
   * @param signatureRequestId Signature request Id
   * @return File body String
   */
  public String getDocumentSignedDocument (Long signatureRequestId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
             
    // verify the required parameter 'signatureRequestId' is set
    if (signatureRequestId == null) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'signatureRequestId' when calling getDocumentById");
    }
     
    String path = API_PATH + "/" + signatureRequestId + "/signed_document"; 
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
}
