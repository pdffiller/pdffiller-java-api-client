package com.pdffiller.client.api;

import com.pdffiller.client.PdfFillerAPIClient;
import com.pdffiller.client.dto.*;
import com.pdffiller.client.exception.PdfFillerAPIException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CustomLogoApiTest {
  private PdfFillerAPIClient apiClient;
  private CustomLogo api;
  private CustomLogoInfo infoResponse;
  
  @Before
  public void setUp() throws Exception {
    apiClient = new PdfFillerAPIClient
        .Builder("CLIENT_ID","CLIENT_SECRET")
        .build();
    api = new CustomLogo(apiClient);
  }

  @Test
  public void uploadLogoTest() throws PdfFillerAPIException {
    String sampleFile = "https://static.pdffiller.com/img/header/logo-pdffiller.png";
    CustomLogoUploadRequest body = new CustomLogoUploadRequest();
    body.setFile(sampleFile);
    infoResponse = api.addLogo(body);
    assertTrue(infoResponse.getId() != null);
  }
  
  @Test
  public void getLogoTest() throws PdfFillerAPIException {
    CustomLogoInfo response = api.getCustomLogo(65);
    assertTrue(response.getId() != null);
  }
  
  @Test 
  public void getLogosList() throws PdfFillerAPIException {
    CustomLogoListResponse response = api.getLogosList();
    assertTrue(response.getTotal() != null);
  }

  @Test
  public void deleteLogoTest() throws PdfFillerAPIException {
    String response = api.deleteCustomLogo(148);
    assertTrue(response != null);
  }
}
