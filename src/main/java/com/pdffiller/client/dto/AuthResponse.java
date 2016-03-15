package com.pdffiller.client.dto;

public class AuthResponse {
  
  private String access_token = null;
  private String token_type;
  private Integer expires_in;

  
  /**
   * this token you will use for accessing every private endpoint
   **/
  public String getAccessToken() {
    return access_token;
  }
  public void setAccessToken(String accessToken) {
    this.access_token = accessToken;
  }

  
  /**
   * Only Bearer supported
   **/
  public String getTokenType() {
    return token_type;
  }
  public void setTokenType(String tokenType) {
    this.token_type = tokenType;
  }

  
  /**
   * token live time in seconds, default - 86400
   **/
  public Integer getExpiresIn() {
    return expires_in;
  }
  public void setExpiresIn(Integer expiresIn) {
    this.expires_in = expiresIn;
  }


  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AUTHRESPONSE {\n");
    sb.append("    accessToken: ").append(access_token.toString()).append("\n");
    sb.append("    tokenType: ").append(token_type.toString()).append("\n");
    sb.append("    expiresIn: ").append(expires_in.toString()).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
