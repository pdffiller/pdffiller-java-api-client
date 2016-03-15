package com.pdffiller.client.dto;

public class FillableTemplateResponse   {
  private Integer id = null;
  private Integer documentId = null;
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }  
  
  public Integer getDocumentId() {
    return documentId;
  }

  public void setDocumentId(Integer documentId) {
    this.documentId = documentId;
  }

}
