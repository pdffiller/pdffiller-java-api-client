package com.pdffiller.client.dto;

public class DocumentUploadRequest   {
  private Object file = null;
  private static final String CRLF = "\r\n";
  
  /**
   * File url or File content for upload
   **/
  public Object getFile() {
    return file;
  }
  public void setFile(Object file) {
    this.file = file;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentUploadRequest {\n");   
    sb.append("    file: ").append(file.toString()).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
