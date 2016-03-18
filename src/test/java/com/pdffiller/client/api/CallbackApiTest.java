package com.pdffiller.client.api;

import com.pdffiller.client.PdfFillerAPIClient;
import com.pdffiller.client.dto.CallbackBody;
import com.pdffiller.client.dto.DocumentInfo;
import com.pdffiller.client.dto.DocumentListResponse;
import com.pdffiller.client.dto.DocumentUploadRequest;
import com.pdffiller.client.exception.PdfFillerAPIException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CallbackApiTest {
  private PdfFillerAPIClient apiClient;
  private Callback api;

  @Before
  public void setUp() throws Exception {
    apiClient = new PdfFillerAPIClient
        .Builder("CLIENT_ID","CLIENT_SECRET")
        .build();
    api = new Callback(apiClient);
  }

  @Test
  public void listTest() throws PdfFillerAPIException {
    String response = api.listCallbacks();
    assertTrue(response != null);
  }
  
  @Test
  public void addTest() throws PdfFillerAPIException {
    CallbackBody body = new CallbackBody("fill_request.done", "http://pdffiller.com/callback_destination", 53690143);
    String response = api.addCallback(body);
    assertTrue(response != null);
  }
  
  @Test 
  public void updateTest() throws PdfFillerAPIException {
    CallbackBody body = new CallbackBody("fill_request.done", "http://pdffiller.com/callback_destination_test", 53690143);
    String response = api.updateCallback(123, body);
    assertTrue(response != null);
  }

  @Test
  public void deleteTest() throws PdfFillerAPIException {
    String response = api.deleteCallback(816);
    assertTrue(response != null);
  }
}
