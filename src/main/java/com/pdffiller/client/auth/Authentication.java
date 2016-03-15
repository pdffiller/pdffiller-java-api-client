package com.pdffiller.client.auth;

import java.util.Map;

public interface Authentication {
  /** Apply authentication settings to header and query params. 
   * @return */
  Map<String, String> applyToParams(Map<String, String> headerParams);
}
