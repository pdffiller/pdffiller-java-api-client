package com.pdffiller.client.api;

import com.pdffiller.client.PdfFillerAPIClient;
import com.pdffiller.client.dto.DocumentInfo;
import com.pdffiller.client.dto.DocumentListResponse;
import com.pdffiller.client.dto.DocumentUploadRequest;
import com.pdffiller.client.dto.FillRequestBody;
import com.pdffiller.client.exception.PdfFillerAPIException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class FillRequestApiTest {
  private PdfFillerAPIClient apiClient;
  private FillRequest api;

  @Before
  public void setUp() throws Exception {
    apiClient = new PdfFillerAPIClient
            .Builder("CLIENT_ID","CLIENT_SECRET")
        .build();
    api = new FillRequest(apiClient);

  }

  @Test
  public void listTest() throws PdfFillerAPIException {
    String response = api.listFillRequests();
    assertTrue(response != null);
  }
  
  @Test
  public void getRequestTest() throws PdfFillerAPIException {
    String response = api.findFillRequestId("123");
    assertTrue(response != null);
  }

  @Test
  public void listFormsTest() throws PdfFillerAPIException {
    String response = api.listFilledForm("123");
    assertTrue(response != null);
  }

  @Test
  public void findFormTest() throws PdfFillerAPIException {
    String response = api.findFilledForm("123", "456");
    assertTrue(response != null);
  }

  @Test
  public void createRequestTest() throws PdfFillerAPIException {
    ArrayList<FillRequestBody.NotificationEmail> notificationsEmails = new ArrayList<>();
    notificationsEmails.add(new FillRequestBody.NotificationEmail("example@example.com", "example"));
    FillRequestBody body = new FillRequestBody(123, notificationsEmails);
    body.setCustomMessage("custom message");
    String response = api.createFillRequest(body);
    assertTrue(response != null);
  }

  @Test
  public void updateRequestTest() throws PdfFillerAPIException {
    ArrayList<FillRequestBody.NotificationEmail> notificationsEmails = new ArrayList<>();
    notificationsEmails.add(new FillRequestBody.NotificationEmail("example@example.com", "example"));
    FillRequestBody body = new FillRequestBody(123, notificationsEmails);
    body.setCustomMessage("custom message5");
    String response = api.updateLinkToFill(body);
    assertTrue(response != null);
  }

  @Test
  public void downloadFormTest() throws PdfFillerAPIException {
    String response = api.downloadSingleFilledForm("123", "456");
    assertTrue(response != null);
  }

  @Test
  public void exportFormTest() throws PdfFillerAPIException {
    String response = api.exportFilledForm("123", "456");
    assertTrue(response != null);
  }

  @Test
  public void deleteFormTest() throws PdfFillerAPIException {
    String response = api.deleteFilledForm("123", "456");
    assertTrue(response != null);
  }

  @Test
  public void deleteRequestTest() throws PdfFillerAPIException {
    String response = api.deleteFillRequestId("123");
    assertTrue(response != null);
  }

}
