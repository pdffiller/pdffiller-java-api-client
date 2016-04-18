package com.pdffiller.client.api;

import com.pdffiller.client.ApiClient;
import com.pdffiller.client.dto.*;
import com.pdffiller.client.exception.PdfFillerAPIException;

import java.util.HashMap;
import java.util.List;

public class CustomLogo {
  private ApiClient apiClient;
  private String API_PATH = "/custom_logo";

  public CustomLogo(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Retrieves a list of uploaded logos.
   * @return CustomLogoListResponse
   */
  public CustomLogoListResponse getLogosList() throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    Object body = null;
    String method = "GET";
    return apiClient.call(API_PATH, method, queryParams, headerParams, body, CustomLogoListResponse.class);
  }
  
  /**
   * Uploads new custom logo from url.
   * @param body send file url info or file content string
   * @return CreateDocumenTemplateResponse
   */
  public CustomLogoInfo addLogo(CustomLogoUploadRequest body) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    String method = "POST";
    if (body == null) {
      throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling addLogo");
    }
    return apiClient.call(API_PATH, method, queryParams, headerParams, body, CustomLogoInfo.class);
  }
  
  /**
   * Returns custom logo info.
   * @param logoId document id
   * @return CreateDocumenTemplateResponse
   */
  public CustomLogoInfo getCustomLogo (long logoId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    Object body = null;
    String method = "GET";
    return apiClient.call(API_PATH + "/" + logoId, method, queryParams, headerParams, body, CustomLogoInfo.class);
  }

  /**
   * Deletes custom logo by id.
   * @param logoId document id
   * @return CreateDocumenTemplateResponse
   */
  public String deleteCustomLogo (long logoId) throws PdfFillerAPIException {
    List<Params> queryParams = null;
    HashMap<String, String> headerParams = null;
    Object body = null;
    String method = "DELETE";
    return apiClient.call(API_PATH + "/" + logoId, method, queryParams, headerParams, body, HttpResponse.class);
  }

}
