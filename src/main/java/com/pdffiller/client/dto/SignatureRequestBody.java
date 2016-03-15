package com.pdffiller.client.dto;

import java.util.ArrayList;
import java.util.List;

public class SignatureRequestBody {
  private Integer document_id;
  private String method;
  private String envelope_name;
  private Boolean sign_in_order = false;
  private String security_pin = "standard";
  private List<Recipient> recipients = new ArrayList<Recipient>();
  
  /**
  * 
  * @param envelope_name
  * @param recipients
  * @param method
  * @param sign_in_order
  * @param document_id
  */
  public SignatureRequestBody(Integer documentId, String method, String envelopeName, Boolean signInOrder, List<Recipient> recipients) {
    this.document_id = documentId;
    this.method = method;
    this.envelope_name = envelopeName;
    this.sign_in_order = signInOrder;
    this.recipients = recipients;
  }
  
  /**
   * @param recipient
   * @return
   */
  public List<Recipient> addRecipient(Recipient recipient){
    recipients.add(recipient);
    return recipients;
  }
  
  /**
  * 
  * @return
  * The documentId
  */
  public Integer getDocumentId() {
    return document_id;
  }
  
  /**
  * 
  * @param documentId
  * The document_id
  */
  public void setDocumentId(Integer documentId) {
    this.document_id = documentId;
  }
  
  /**
  * 
  * @return
  * The method
  */
  public String getMethod() {
    return method;
  }
  
  /**
  * 
  * @param method
  * The method
  */
  public void setMethod(String method) {
    this.method = method;
  }
  
  /**
  * 
  * @return
  * The envelopeName
  */
  public String getEnvelopeName() {
    return envelope_name;
  }
  
  /**
  * 
  * @param envelopeName
  * The envelope_name
  */
  public void setEnvelopeName(String envelopeName) {
    this.envelope_name = envelopeName;
  }
  
  public String getSecurity_pin() {
    return security_pin;
  }

  public void setSecurity_pin(String security_pin) {
    this.security_pin = security_pin;
  }

  /**
  * 
  * @return
  * The signInOrder
  */
  public Boolean getSignInOrder() {
    return sign_in_order;
  }
  
  /**
  * 
  * @param signInOrder
  * The sign_in_order
  */
  public void setSignInOrder(Boolean signInOrder) {
    this.sign_in_order = signInOrder;
  }
  
  /**
  * 
  * @return
  * The recipients
  */
  public List<Recipient> getRecipients() {
    return recipients;
  }
  
  /**
  * 
  * @param recipients
  * The recipients
  */
  public void setRecipients(List<Recipient> recipients) {
    this.recipients = recipients;
  }
  
  public static class Recipient {
    private String email;
    private String name;
    private String message_subject;
    private String message_text;
    private Boolean require_photo;
    private Integer order;
    private List<String> additional_documents = new ArrayList<String>();
    private AccessEnum access = AccessEnum.FULL;
      
    /**
    * 
    * @param email
    * @param name
    * @param message_text
    * @param message_subject
    * @param access
    */
    public Recipient(String email, String name, String messageSubject, String messageText, AccessEnum access) {
      this.email = email;
      this.name = name;
      this.message_subject = messageSubject;
      this.message_text = messageText;
      this.access = access;
    }
    
    public enum AccessEnum {
      FULL("full"),
      SIGNATURE("signature");
      private String value;
     
      AccessEnum(String value) {
        this.value = value;
      }
    }
    
    /**
     * @param document
     * @return
     */
    public List<String> addAdditionalDocuments(String document){
      additional_documents.add(document);
      return additional_documents;
    }
      
    /**
    * 
    * @return
    * The email
    */
    public String getEmail() {
      return email;
    }
    
    /**
    * 
    * @param email
    * The email
    */
    public void setEmail(String email) {
      this.email = email;
    }
    
    /**
    * 
    * @return
    * The name
    */
    public String getName() {
      return name;
    }
    
    /**
    * 
    * @param name
    * The name
    */
    public void setName(String name) {
      this.name = name;
    }
    
    /**
    * 
    * @return
    * The messageSubject
    */
    public String getMessageSubject() {
      return message_subject;
    }
    
    /**
    * 
    * @param messageSubject
    * The message_subject
    */
    public void setMessageSubject(String messageSubject) {
      this.message_subject = messageSubject;
    }
    
    /**
    * 
    * @return
    * The messageText
    */
    public String getMessageText() {
      return message_text;
    }
    
    /**
    * 
    * @param messageText
    * The message_text
    */
    public void setMessageText(String messageText) {
      this.message_text = messageText;
    }
    
    /**
    * 
    * @return
    * The requirePhoto
    */
    public Boolean getRequirePhoto() {
      return require_photo;
    }
    
    /**
    * 
    * @param requirePhoto
    * The require_photo
    */
    public void setRequirePhoto(Boolean requirePhoto) {
      this.require_photo = requirePhoto;
    }
    
    /**
    * 
    * @return
    * The order
    */
    public Integer getOrder() {
      return order;
    }
    
    /**
    * 
    * @param order
    * The order
    */
    public void setOrder(Integer order) {
      this.order = order;
    }
    
    /**
    * 
    * @return
    * The additionalDocuments
    */
    public List<String> getAdditionalDocuments() {
      return additional_documents;
    }
    
    /**
    * 
    * @param additionalDocuments
    * The additional_documents
    */
    public void setAdditionalDocuments(List<String> additionalDocuments) {
      this.additional_documents = additionalDocuments;
    }
    
    /**
    * 
    * @return
    * The access
    */
    public AccessEnum getAccess() {
      return access;
    }
    
    /**
    * 
    * @param access
    * The access
    */
    public void setAccess(AccessEnum access) {
      this.access = access;
    }
   }
}
