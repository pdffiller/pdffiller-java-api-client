package com.pdffiller.client.dto;

import java.util.*;

public class DocumentListResponse extends ListResponse {
  private List<DocumentInfo> items = new ArrayList<DocumentInfo>();

  @Override
  public String itemsToString() {
    return items.toString();
  }
}
