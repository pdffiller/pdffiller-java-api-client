package com.pdffiller.client.dto;

import java.util.*;

public class AddRecipientBody   {
  private String email = null;
  private String name = null;
  private Integer order = null;
  private String messageSubject = null;
  private String messageText = null;
  private Integer dateCreated = null;
  private Integer dateSigned = null;
  private List<Object> additionalDocuments = new ArrayList<Object>();
  private Boolean requirePhoto = null;

  
  /**
   * token live time in seconds, default - 3600
   **/
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  
  /**
   **/
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * required when signature request method is sendtogroup
   **/
  public Integer getOrder() {
    return order;
  }
  public void setOrder(Integer order) {
    this.order = order;
  }
  
  public String getMessageSubject() {
    return messageSubject;
  }
  public void setMessageSubject(String messageSubject) {
    this.messageSubject = messageSubject;
  }

  public String getMessageText() {
    return messageText;
  }
  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public Integer getDateCreated() {
    return dateCreated;
  }
  public void setDateCreated(Integer dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Integer getDateSigned() {
    return dateSigned;
  }
  public void setDateSigned(Integer dateSigned) {
    this.dateSigned = dateSigned;
  }
  
  /**
   * use this schema for get request
   **/
  public List<Object> getAdditionalDocuments() {
    return additionalDocuments;
  }
  public void setAdditionalDocuments(List<Object> additionalDocuments) {
    this.additionalDocuments = additionalDocuments;
  }

  public Boolean getRequirePhoto() {
    return requirePhoto;
  }
  public void setRequirePhoto(Boolean requirePhoto) {
    this.requirePhoto = requirePhoto;
  }

}
