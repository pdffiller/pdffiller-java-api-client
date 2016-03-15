package com.pdffiller.client.auth;

import java.util.Map;

public class OAuth implements Authentication {
  private String accessToken;
  private String expiration;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  @Override
  public Map<String, String> applyToParams(Map<String, String> headerParams) {
    if (accessToken != null) {
      headerParams.put("Authorization", "Bearer " + accessToken);
    }
    return headerParams;
  }
}
