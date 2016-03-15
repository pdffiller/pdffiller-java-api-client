package com.pdffiller.client.dto;

import java.util.*;

import com.pdffiller.client.dto.DocumentInfo;

public class DocumentListResponse   {
  private Integer perPage = null;
  private Integer total = null;
  private String nextPageUrl = null;
  private String prevPageUrl = null;
  private List<DocumentInfo> items = new ArrayList<DocumentInfo>();
  private Integer currentPage = null;

  public Integer getPerPage() {
    return perPage;
  }
  public void setPerPage(Integer perPage) {
    this.perPage = perPage;
  }

  public Integer getTotal() {
    return total;
  }
  public void setTotal(Integer total) {
    this.total = total;
  }

  public String getNextPageUrl() {
    return nextPageUrl;
  }
  public void setNextPageUrl(String nextPageUrl) {
    this.nextPageUrl = nextPageUrl;
  }

  public String getPrevPageUrl() {
    return prevPageUrl;
  }
 
  public void setPrevPageUrl(String prevPageUrl) {
    this.prevPageUrl = prevPageUrl;
  }

  public List<DocumentInfo> getItems() {
    return items;
  }
  public void setItems(List<DocumentInfo> items) {
    this.items = items;
  }

  public Integer getCurrentPage() {
    return currentPage;
  }
  
  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }
  
  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDocumenTemplateResponse {\n");   
    sb.append("    perPage: ").append(perPage.toString()).append("\n");
    sb.append("    total: ").append(total.toString()).append("\n");
    sb.append("    nextPageUrl: ").append(nextPageUrl.toString()).append("\n");
    sb.append("    prevPageUrl: ").append(prevPageUrl.toString()).append("\n");
    sb.append("    items: ").append(items.toString()).append("\n");
    sb.append("    currentPage: ").append(currentPage.toString()).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
