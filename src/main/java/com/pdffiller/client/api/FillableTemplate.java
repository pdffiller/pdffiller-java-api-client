package com.pdffiller.client.api;

import java.util.*;

import com.pdffiller.client.ApiClient;
import com.pdffiller.client.dto.FillableTemplateRequestBody;
import com.pdffiller.client.dto.Params;
import com.pdffiller.client.exception.PdfFillerAPIException;

public class FillableTemplate {
  private ApiClient apiClient;
  private String API_PATH = "/fillable_request"; 
 
  public FillableTemplate(ApiClient apiClient) {
    this.apiClient = apiClient;
  }  
  
  /**
   * Fills a fillable form template
   * Populates a fillable form template which was pre-created in PDFFiller fillable constructor
   * @param body 
   * @return Json string
   */
  public String postFillableTemplate (FillableTemplateRequestBody body) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String method = "POST";
    if (body == null) {
      throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling postFillableTemplate");
    }
    return apiClient.call(API_PATH, method, queryParams, headerParams, body);
  }
  
  /**
   * Fillable fields for selected document template
   * @param fillableTemplateId Fillable template ID
   * @return List<Object>
   */
  public String getDictionaryFillableTemplate (int fillableTemplateId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
    
     // verify the required parameter 'fillableTemplateId' is set
     if (fillableTemplateId == 0) {
        throw new PdfFillerAPIException(400, "Missing the required parameter 'fillableTemplateId' when calling getDictionaryFillableTemplate");
     }

     String path = API_PATH + "/" + fillableTemplateId;
     return apiClient.call(path, method, queryParams, headerParams, body);
  }
  
  /**
   * Downloads a filled PDF document
   * Downloads a filled PDF document
   * @param fillableTemplateId Fillable template ID
   * @return void
   */
  public String downloadFilledForm (int fillableTemplateId, String downloadType) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String body = null;
    String method = "GET";
    
    if (downloadType == "url") {
      queryParams = new ArrayList<Params>(); 
      queryParams.add(new Params("type","url"));
    }
    
    // verify the required parameter 'fillableTemplateId' is set
    if (fillableTemplateId == 0) {
       throw new PdfFillerAPIException(400, "Missing the required parameter 'fillableTemplateId' when calling getDictionaryFillableTemplate");
    }
    String path = API_PATH + "/" + fillableTemplateId + "/download";
    return apiClient.call(path, method, queryParams, headerParams, body);
  }
}
