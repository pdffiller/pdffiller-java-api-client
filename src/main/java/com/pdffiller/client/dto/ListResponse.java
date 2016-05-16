package com.pdffiller.client.dto;

public abstract class ListResponse {
  protected Integer per_page = null;
  protected Integer total = null;
  protected String next_page_url = null;
  protected String prev_page_url = null;
  protected Integer current_page = null;

  public Integer getPerPage() {
    return per_page;
  }
  public void setPerPage(Integer perPage) {
    this.per_page = perPage;
  }

  public Integer getTotal() {
    return total;
  }
  public void setTotal(Integer total) {
    this.total = total;
  }

  public String getNextPageUrl() {
    return next_page_url;
  }
  public void setNextPageUrl(String nextPageUrl) {
    this.next_page_url = nextPageUrl;
  }

  public String getPrevPageUrl() {
    return prev_page_url;
  }

  public void setPrevPageUrl(String prevPageUrl) {
    this.prev_page_url = prevPageUrl;
  }

  public Integer getCurrentPage() {
    return current_page;
  }

  public void setCurrentPage(Integer currentPage) {
    this.current_page = currentPage;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class " + getClass().getSimpleName() + " {\n");
    sb.append("    per_page: ").append(per_page.toString()).append("\n");
    sb.append("    total: ").append(total.toString()).append("\n");
    sb.append("    next_page_url: ").append(next_page_url).append("\n");
    sb.append("    prev_page_url: ").append(prev_page_url).append("\n");
    sb.append("    items: ").append(itemsToString()).append("\n");
    sb.append("    current_page: ").append(current_page.toString()).append("\n");
    sb.append("}");
    return sb.toString();
  }

  public abstract String itemsToString();
}
