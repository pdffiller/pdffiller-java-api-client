package com.pdffiller.client.dto;

import java.util.ArrayList;
import java.util.List;

public class CallbackList {
  private List<Item> items = new ArrayList<Item>();
  private Integer total;
  private Integer current_page;
  private Integer per_page;
  private String prev_page_url;
  private String next_page_url;
  
  /**
  * 
  * @return
  * The items
  */
  public List<Item> getItems() {
    return items;
  }
  
  /**
  * 
  * @param items
  * The items
  */
  public void setItems(List<Item> items) {
    this.items = items;
  }
  
  /**
  * 
  * @return
  * The total
  */
  public Integer getTotal() {
    return total;
  }
  
  /**
  * 
  * @param total
  * The total
  */
  public void setTotal(Integer total) {
    this.total = total;
  }
  
  /**
  * 
  * @return
  * The currentPage
  */
  public Integer getCurrentPage() {
    return current_page;
  }
  
  /**
  * 
  * @param currentPage
  * The current_page
  */
  public void setCurrentPage(Integer currentPage) {
    this.current_page = currentPage;
  }
  
  /**
  * 
  * @return
  * The perPage
  */
  public Integer getPerPage() {
    return per_page;
  }
  
  /**
  * 
  * @param perPage
  * The per_page
  */
  public void setPerPage(Integer perPage) {
    this.per_page = perPage;
  }
  
  /**
  * 
  * @return
  * The prevPageUrl
  */
  public String getPrevPageUrl() {
    return prev_page_url;
  }
  
  /**
  * 
  * @param prevPageUrl
  * The prev_page_url
  */
  public void setPrevPageUrl(String prevPageUrl) {
    this.prev_page_url = prevPageUrl;
  }
  
  /**
  * 
  * @return
  * The nextPageUrl
  */
  public String getNextPageUrl() {
    return next_page_url;
  }
  
  /**
  * 
  * @param nextPageUrl
  * The next_page_url
  */
  public void setNextPageUrl(String nextPageUrl) {
    this.next_page_url = nextPageUrl;
  }
  
  public static class Item { 
    private Integer id;
    private Integer documentId;
    private String eventId;
    private String callbackUrl;
    
    /**
    * 
    * @return
    * The id
    */
    public Integer getId() {
      return id;
    }
    
    /**
    * 
    * @param id
    * The id
    */
    public void setId(Integer id) {
      this.id = id;
    }
    
    /**
    * 
    * @return
    * The documentId
    */
    public Integer getDocumentId() {
      return documentId;
    }
    
    /**
    * 
    * @param documentId
    * The document_id
    */
    public void setDocumentId(Integer documentId) {
      this.documentId = documentId;
    }
    
    /**
    * 
    * @return
    * The eventId
    */
    public String getEventId() {
      return eventId;
    }
    
    /**
    * 
    * @param eventId
    * The event_id
    */
    public void setEventId(String eventId) {
      this.eventId = eventId;
    }
    
    /**
    * 
    * @return
    * The callbackUrl
    */
    public String getCallbackUrl() {
      return callbackUrl;
    }
    
    /**
    * 
    * @param callbackUrl
    * The callback_url
    */
    public void setCallbackUrl(String callbackUrl) {
      this.callbackUrl = callbackUrl;
    }
  } 
}



