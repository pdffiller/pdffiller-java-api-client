package com.pdffiller.client.dto;


public class CustomLogoInfo {
  private Long id = null;
  private Integer width = null;
  private Integer height = null;
  private Long filesize = null;
  private String logo_url = "https://www.pdffiller.com/img/logo-pdffiller.png";

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Long getFilesize() {
    return filesize;
  }

  public void setFilesize(Long filesize) {
    this.filesize = filesize;
  }

  public String getLogoUrl() {
    return logo_url;
  }

  public void setLogoUrl(String logoUrl) {
    this.logo_url = logoUrl;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomLogoInfo {\n");
    sb.append("    id: ").append(id.toString()).append("\n");
    sb.append("    filesize: ").append(filesize.toString()).append("\n");
    sb.append("    width: ").append(width.toString()).append("\n");
    sb.append("    height: ").append(height.toString()).append("\n");
    sb.append("    logo_url: ").append(logo_url.toString()).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
