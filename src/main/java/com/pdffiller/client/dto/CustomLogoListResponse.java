package com.pdffiller.client.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomLogoListResponse extends ListResponse {
  protected List<CustomLogoInfo> items = new ArrayList<>();

  @Override
  public String itemsToString() {
    return items.toString();
  }
}
