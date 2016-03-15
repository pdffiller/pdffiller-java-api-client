package com.pdffiller.client.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pdffiller.client.PdfFillerAPIClient;
import com.pdffiller.client.api.Document;
import com.pdffiller.client.dto.DocumentInfo;
import com.pdffiller.client.dto.DocumentListResponse;
import com.pdffiller.client.dto.DocumentUploadRequest;
import com.pdffiller.client.exception.PdfFillerAPIException;

public class DocumentApiTest {
  private PdfFillerAPIClient apiClient;
  private Document api;
  private DocumentInfo documentCreateResponse;
  
  @Before
  public void setUp() throws Exception {
    apiClient = new PdfFillerAPIClient
        .Builder("CLIENT_ID","CLIENT_SECRET")
        .build();
    api = new Document(apiClient);
  }

  @Test
  public void uploadDocumentTest() throws PdfFillerAPIException {
    String sampleFile = "http://partners.adobe.com/public/developer/en/xml/AdobeXMLFormsSamples.pdf";
    DocumentUploadRequest body = new DocumentUploadRequest();
    body.setFile(sampleFile);
    documentCreateResponse = api.createDocumentTemplate(body);
    assertTrue(documentCreateResponse.getId() != null);
  }
  
  @Test
  public void getDocumentInfoTest() throws PdfFillerAPIException {   
    DocumentInfo response = api.getDocumentInfo(123456);
    assertTrue(response.getId() != null);
  }
  
  @Test 
  public void getDocumentList() throws PdfFillerAPIException {   
    DocumentListResponse response = api.retrieveDocumentList();
    assertTrue(response.getTotal() != null);
  }
}
