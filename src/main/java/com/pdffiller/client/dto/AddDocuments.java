package com.pdffiller.client.dto;

public class AddDocuments   {
  private String documentRequestNotification = null;
  private String filename = null;
  private String ip = null;

  public String getDocumentRequestNotification() {
    return documentRequestNotification;
  }
  public void setDocumentRequestNotification(String documentRequestNotification) {
    this.documentRequestNotification = documentRequestNotification;
  }
  
  /**
   * Visible only after document is signed
   **/
  public String getFilename() {
    return filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }
  
  /**
   * Visible only after document is signed
   **/
  public String getIp() {
    return ip;
  }
  public void setIp(String ip) {
    this.ip = ip;
  }
}
