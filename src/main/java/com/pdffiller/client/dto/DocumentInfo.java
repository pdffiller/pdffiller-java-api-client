package com.pdffiller.client.dto;

public class DocumentInfo   {
  private Long id = null;
  private String name = null;
  private String type = null;
  private Long created = null;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public Long getCreated() {
    return created;
  }
  public void setCreated(Long created) {
    this.created = created;
  }


  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInfo {\n");
    sb.append("    id: ").append(id.toString()).append("\n");
    sb.append("    name: ").append(name.toString()).append("\n");
    sb.append("    type: ").append(type.toString()).append("\n");
    sb.append("    created: ").append(created.toString()).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
