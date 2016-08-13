package com.pdffiller.client.auth;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class HttpBasicAuth implements Authentication {
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public Map<String, String> applyToParams(Map<String, String> headerParams) {
    String str = (username == null ? "" : username) + ":" + (password == null ? "" : password);
    try {
      headerParams.put("Authorization", "Basic " + Base64.encodeToString(str.getBytes("UTF-8"), Base64.NO_CLOSE));
      return headerParams;
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
}
