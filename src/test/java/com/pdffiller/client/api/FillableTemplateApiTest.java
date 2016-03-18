package com.pdffiller.client.api;

import com.pdffiller.client.PdfFillerAPIClient;
import com.pdffiller.client.dto.DocumentInfo;
import com.pdffiller.client.dto.DocumentListResponse;
import com.pdffiller.client.dto.DocumentUploadRequest;
import com.pdffiller.client.dto.FillableTemplateRequestBody;
import com.pdffiller.client.exception.PdfFillerAPIException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FillableTemplateApiTest {
  private PdfFillerAPIClient apiClient;
  private FillableTemplate api;

  @Before
  public void setUp() throws Exception {
    apiClient = new PdfFillerAPIClient
            .Builder("CLIENT_ID","CLIENT_SECRET")
        .build();
    api = new FillableTemplate(apiClient);
  }

  @Test
  public void dictionaryTest() throws PdfFillerAPIException {
    String response = api.getDictionaryFillableTemplate(123);
    assertTrue(response != null);
  }

  @Test
  public void downloadTest() throws PdfFillerAPIException {
    String response = api.downloadFilledForm(123, "url");
    assertNotNull(response);
  }

  @Test
  public void fillTest() throws PdfFillerAPIException {
    FillableTemplateRequestBody body = new FillableTemplateRequestBody(123);
    body.addFields("Text_1", "super text");
    String response = api.postFillableTemplate(body);
    assertNotNull(response);
  }
}
