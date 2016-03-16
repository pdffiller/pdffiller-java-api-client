package com.pdffiller.client.api;

import com.pdffiller.client.PdfFillerAPIClient;
import com.pdffiller.client.api.Token;
import com.pdffiller.client.dto.TokenBody;
import com.pdffiller.client.exception.PdfFillerAPIException;
import com.pdffiller.client.json.Mapper;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TokenApiTest {
  private PdfFillerAPIClient apiClient;
  private Token api;

  @Before
  public void setUp() throws Exception {
    apiClient = new PdfFillerAPIClient
        .Builder("CLIENT_ID","CLIENT_SECRET")
        .build();
    api = new Token(apiClient);
  }

  @Test
  public void getListTokens() throws PdfFillerAPIException {
    String list = api.listTokens();
    assertTrue(list != null);
  }

  @Test
  public void getTokenTest() throws PdfFillerAPIException {
    TokenBody token = api.getToken("644");
    assertTrue(token.getId() != null);
  }

  @Test
  public void createTokenTest() throws PdfFillerAPIException {
    Map<String, String> data = new HashMap<>();
    data.put("key", "value");
    TokenBody body = new TokenBody(data);
    String response = api.create(body);
    body = (new Mapper()).deserialize(response, TokenBody.class);
    assertTrue(body.getId() != null);
  }

  @Test
  public void updateTokenTest() throws PdfFillerAPIException {
    TokenBody body = api.getToken("644");
    body.addToData("additional", "value");
    String response = api.update(body);
    TokenBody returnedBody = (new Mapper()).deserialize(response, TokenBody.class);
    assertEquals(body.getId(), returnedBody.getId());
  }

  @Test
  public void deleteTokenTest() throws PdfFillerAPIException {
    String response = api.delete("644");
    assertTrue(response != null);
  }
}
