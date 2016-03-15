package com.pdffiller.client.dto;

import java.util.List;
import java.util.Map;

public class HttpResponse {
  private int code;
  private String body;
  private Map<String, List<String>> headers;
  
  public int getCode() {
    return code;
  }
  public String getBody() {
    return body;
  }
  public void setCode(int code) {
    this.code = code;
  }
  public void setBody(String body) {
    this.body = body;
  }
  public Map<String, List<String>> getHeaders() {
    return headers;
  }
  public void setHeaders(Map<String, List<String>> responseHeaders) {
    this.headers = responseHeaders;
  }
  
}
