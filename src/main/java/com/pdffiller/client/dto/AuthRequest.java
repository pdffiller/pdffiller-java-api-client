package com.pdffiller.client.dto;

public class AuthRequest   {
  private String grant_type = "client_credentials";
  private String client_id = null;
  private String client_secret = null;
  
  /**
   * Only client_credentials supported
   **/
  public String getGrantType() {
    return grant_type;
  }
  
  public void setGrantType(String grantType) {
    this.grant_type = grantType;
  }

  /**
   * this id you can get via pdffiller.com on the /en/apiform/token.htm
   **/
  public String getClientId() {
    return client_id;
  }
  public void setClientId(String clientId) {
    this.client_id = clientId;
  }

  /**
   * this secret you can get via pdffiller.com on the /en/apiform/token.htm
   **/
  public String getClientSecret() {
    return client_secret;
  }
  
  public void setClientSecret(String clientSecret) {
    this.client_secret = clientSecret;
  }
}
