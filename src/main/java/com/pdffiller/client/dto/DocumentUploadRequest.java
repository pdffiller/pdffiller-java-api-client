package com.pdffiller.client.dto;

public class DocumentUploadRequest   {  
  private String file = null;
  
  /**
   * File url or File content for upload
   **/
  public String getFile() {
    return file;
  }
  public void setFile(String file) {
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
