package com.pdffiller.client.dto;

import com.pdffiller.client.api.Callback;

public class CallbackBody {
  private String event_id;
  private String callback_url;
  private int document_id;
  
  public String getEventId() {
    return event_id;
  }
  public void setEventId(String eventId) {
    this.event_id = eventId;
  }
  public String getCallbackUrl() {
    return callback_url;
  }
  public void setCallbackUrl(String callbackUrl) {
    this.callback_url = callbackUrl;
  }
  public int getDocumentId() {
    return document_id;
  }
  public void setDocumentId(int documentId) {
    this.document_id = documentId;
  }

  public CallbackBody() {}

  public CallbackBody(String eventId, String callbackUrl, int documentId) {
    this.event_id = eventId;
    this.callback_url = callbackUrl;
    this.document_id = documentId;
  }
}
