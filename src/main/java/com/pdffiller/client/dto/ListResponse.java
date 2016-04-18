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

  public String getNext_page_url() {
    return next_page_url;
  }
  public void setNext_page_url(String next_page_url) {
    this.next_page_url = next_page_url;
  }

  public String getPrev_page_url() {
    return prev_page_url;
  }

  public void setPrev_page_url(String prev_page_url) {
    this.prev_page_url = prev_page_url;
  }

  public Integer getCurrent_page() {
    return current_page;
  }

  public void setCurrent_page(Integer current_page) {
    this.current_page = current_page;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class " + getClass().getSimpleName() + " {\n");
    sb.append("    per_page: ").append(per_page.toString()).append("\n");
    sb.append("    total: ").append(total.toString()).append("\n");
    sb.append("    next_page_url: ").append(next_page_url.toString()).append("\n");
    sb.append("    prev_page_url: ").append(prev_page_url.toString()).append("\n");
    sb.append("    items: ").append(itemsToString()).append("\n");
    sb.append("    current_page: ").append(current_page.toString()).append("\n");
    sb.append("}");
    return sb.toString();
  }

  public abstract String itemsToString();
}
