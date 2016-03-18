package com.pdffiller.client.api;

import com.pdffiller.client.PdfFillerAPIClient;
import com.pdffiller.client.dto.*;
import com.pdffiller.client.exception.PdfFillerAPIException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SignatureRequestApiTest {
  private PdfFillerAPIClient apiClient;
  private SignatureRequest api;

  @Before
  public void setUp() throws Exception {
    apiClient = new PdfFillerAPIClient
        .Builder("CLIENT_ID","CLIENT_SECRET")
        .build();
    api = new SignatureRequest(apiClient);
  }

  @Test
  public void listTest() throws PdfFillerAPIException {
    String response = api.listSignatureRequests("");
    assertTrue(response != null);
  }
  
  @Test
  public void getRequestTest() throws PdfFillerAPIException {
    String response = api.findSignatureRequestId(132303L);
    assertTrue(response != null);
  }

  @Test
  public void getRecipientTest() throws PdfFillerAPIException {
    String response = api.getRecipientStatus(132303L, 140861L);
    assertTrue(response != null);
  }

  @Test
  public void getCertificateTest() throws PdfFillerAPIException {
    String response = api.getCertificateById(132303L);
    assertTrue(response != null);
  }

  @Test
  public void getSignedDocumentTest() throws PdfFillerAPIException {
    String response = api.getDocumentSignedDocument(132303L);
    assertTrue(response != null);
  }

  @Test
  public void addRecipientTest() throws PdfFillerAPIException {
    AddRecipientBody recipients = new AddRecipientBody();
    SignatureRequestBody.Recipient recipient = new SignatureRequestBody.Recipient(
            "add@email.com", "additional", "additional subject", "additional text", SignatureRequestBody.Recipient.AccessEnum.FULL);
    recipients.add(recipient);
    String response = api.addRecipient(recipients, 132303L);
    assertTrue(response != null);
  }

  @Test
  public void remindRecipientTest() throws PdfFillerAPIException {
    String response = api.remindRecipient(132303L, 140877L);
    assertTrue(response != null);
  }
}
