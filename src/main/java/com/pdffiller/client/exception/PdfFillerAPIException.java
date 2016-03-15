package com.pdffiller.client.exception;

import java.util.Map;
import java.util.List;

public class PdfFillerAPIException extends Exception {
  private static final long serialVersionUID = 2889869970880056384L;
  private int code = 0;
  private Map<String, List<String>> responseHeaders = null;
  private String responseBody = null;

  public PdfFillerAPIException() {}

  public PdfFillerAPIException(Throwable throwable) {
    super(throwable);
  }

  public PdfFillerAPIException(String message) {
    super(message);
  }

  public PdfFillerAPIException(String message, Throwable throwable, int code, Map<String, List<String>> responseHeaders, String responseBody) {
    super(message + " " + code + ": " + responseBody.toString(), throwable);
    this.code = code;
    this.responseHeaders = responseHeaders;
    this.responseBody = responseBody;
  }

  public PdfFillerAPIException(String message, int code, Map<String, List<String>> responseHeaders, String responseBody) {
    this(message, (Throwable) null, code, responseHeaders, responseBody);
  }

  public PdfFillerAPIException(String message, Throwable throwable, int code, Map<String, List<String>> responseHeaders) {
    this(message, throwable, code, responseHeaders, null);
  }

  public PdfFillerAPIException(int code, Map<String, List<String>> responseHeaders, String responseBody) {
    this((String) null, (Throwable) null, code, responseHeaders, responseBody);
  }

  public PdfFillerAPIException(int code, String message) {
    super("Error code: " + code + ", " + message);
    this.code = code;
  }

  public PdfFillerAPIException(int code, String message, Map<String, List<String>> responseHeaders, String responseBody) {
    this(code, message + ": " + responseBody.toString());
    this.responseHeaders = responseHeaders;
    this.responseBody = responseBody;
  }

  public int getCode() {
    return code;
  }

  /**
   * Get the HTTP response headers.
   */
  public Map<String, List<String>> getResponseHeaders() {
    return responseHeaders;
  }

  /**
   * Get the HTTP response body.
   */
  public String getResponseBody() {
    return responseBody;
  }
}
