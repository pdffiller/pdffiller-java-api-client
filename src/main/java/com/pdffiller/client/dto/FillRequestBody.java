package com.pdffiller.client.dto;

import java.util.*;

public class FillRequestBody   {
   private Integer document_id = null;
   private StatusEnum status = StatusEnum.PRIVATE;
   private Boolean email_required = true;
   private Boolean name_required = true;
   private String custom_message = null;
   private List<NotificationEmail> notification_emails = new ArrayList<NotificationEmail>();
   private AccessEnum access = AccessEnum.FULL;

   public enum AccessEnum {
	 FULL("full"),
	 SIGNATURE("signature");
	 private String value;
	 AccessEnum(String value) {
	   this.value = value;
	 }
   }

   public enum StatusEnum {
	 PUBLIC("public"),
	 PRIVATE("private");
	 private String value;
	 StatusEnum(String value) {
	   this.value = value;
	 }
   }
   
   public List<NotificationEmail> addNotificationEmail(String email, String name){
     NotificationEmail notificationEmail = new NotificationEmail();
     notificationEmail.setEmail(email);
     notificationEmail.setName(name);
     notification_emails.add(notificationEmail); 
     return notification_emails;     
   }

   /**
    * Id of the document template for linkToFill operations
   **/
   public Integer getDocumentId() {
     return document_id;
   }
   
   public void setDocumentId(Integer documentId) {
    this.document_id = documentId;
   }
  
   /**
    * Access level for the fill request document. Full - read|write|sign. Signature - read|sign.
    **/
   public AccessEnum getAccess() {
    return access;
   }
   
   public void setAccess(AccessEnum access) {
    this.access = access;
   }

   /**
   * Document access permission. Public - open to everyone. Private - open to the document owner only
   **/
   public StatusEnum getStatus() {
     return status;
   }
   
   public void setStatus(StatusEnum status) {
     this.status = status;
   }
 
   /**
    * Email required (true|false)
    **/
   public Boolean getEmailRequired() {
     return email_required;
   }
   
   public void setEmailRequired(Boolean emailRequired) {
     this.email_required = emailRequired;
   }

   /**
    * Name required (true|false)
    **/
   public Boolean getNameRequired() {
     return name_required;
   }
   
   public void setNameRequired(Boolean nameRequired) {
     this.name_required = nameRequired;
   }
  
   /**
   * LinkToFill custom message
   **/
   public String getCustomMessage() {
     return custom_message;
   }
  
   public void setCustomMessage(String customMessage) {
     this.custom_message = customMessage;
   }
 
   /**
   * LinkToFill notification emails
   **/
   public List<NotificationEmail> getNotificationEmails() {
     return notification_emails;
   }
   
   public void setNotificationEmails(List<NotificationEmail> notificationEmails) {
     this.notification_emails = notificationEmails;
   }
   
   /**   
    * Email to receive notifications for fill requests
    */
   public static class NotificationEmail {
     private String email;
     private String name;
     
     public String getEmail() {
       return email;
     }
     public void setEmail(String email) {
       this.email = email;
     }
     public String getName() {
       return name;
     }
     public void setName(String name) {
       this.name = name;
     }
   }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    sb.append("    documentId: ").append(document_id.toString()).append("\n");
    sb.append("    access: ").append(access.toString()).append("\n");
    sb.append("    status: ").append(status.toString()).append("\n");
    sb.append("    emailRequired: ").append(email_required.toString()).append("\n");
    sb.append("    nameRequired: ").append(name_required.toString()).append("\n");
    sb.append("    customMessage: ").append(custom_message.toString()).append("\n");
    sb.append("    notificationEmails: ").append(notification_emails.toString()).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
