package com.pdffiller.client.dto;

import com.pdffiller.client.api.Callback;

public class CallbackBody {
  private String event_id;
  private String callback_url;
  private int document_id;
  
  public String getEventId() {
    return event_id;
  }
  public void setEventId(String event_id) {
    this.event_id = event_id;
  }
  public String getCallbackUrl() {
    return callback_url;
  }
  public void setCallbackUrl(String callback_url) {
    this.callback_url = callback_url;
  }
  public int getDocumentId() {
    return document_id;
  }
  public void setDocumentId(int document_id) {
    this.document_id = document_id;
  }

  public CallbackBody() {}

  public CallbackBody(String event_id, String callback_url, int document_id) {
    this.event_id = event_id;
    this.callback_url = callback_url;
    this.document_id = document_id;
  }
}
