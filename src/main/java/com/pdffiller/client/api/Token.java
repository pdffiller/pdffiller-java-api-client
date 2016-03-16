package com.pdffiller.client.api;

import com.pdffiller.client.ApiClient;
import com.pdffiller.client.dto.Params;
import com.pdffiller.client.dto.TokenBody;
import com.pdffiller.client.exception.PdfFillerAPIException;
import com.pdffiller.client.json.Mapper;

import java.util.HashMap;
import java.util.List;

public class Token {
    private ApiClient apiClient;
    private static String API_PATH = "/token";

    public Token(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns a list of all tokens.
     * @return Json string
     * @throws PdfFillerAPIException
     */
    public String listTokens() throws PdfFillerAPIException {
        return apiClient.call(API_PATH, "GET", null, null, null);
    }

    /**
     * Creates a token with given token data.
     * @param body token data
     * @return JSON string
     * @throws PdfFillerAPIException
     */
    public String create(TokenBody body) throws PdfFillerAPIException {
        List<Params> queryParams = null;
        HashMap<String, String> headerParams = null;
        String method = "POST";
        if (body == null) {
            throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling token create");
        }
        return apiClient.call(API_PATH, method, queryParams, headerParams, body);
    }

    /**
     * Updates a token with given data.
     * @param body token data
     * @return JSON string
     * @throws PdfFillerAPIException
     */
    public String update(TokenBody body) throws PdfFillerAPIException {
        if (body == null) {
            throw new PdfFillerAPIException(400, "Missing the required parameter 'body' when calling token update");
        }

        if (body.getId() == null) {
            throw new PdfFillerAPIException(400, "Missing the required parameter 'id' in token body calling token update");
        }

        String path = API_PATH + "/" + body.getId();
        return apiClient.call(path, "PUT", null, null, body);
    }

    /**
     * Finds and returns a token data by given id.
     * @param tokenId token id
     * @return JSON string
     * @throws PdfFillerAPIException
     */
    public TokenBody getToken(String tokenId) throws PdfFillerAPIException {
        if (tokenId == null) {
            throw new PdfFillerAPIException(400, "Missing the required parameter 'tokenId' when calling token delete.");
        }

        String path = API_PATH + '/' + tokenId;
        String response = apiClient.call(path, "GET", null, null, null);
        return (new Mapper()).deserialize(response, TokenBody.class);
    }

    /**
     * Deletes token by given id and returns count of tokens left.
     * @param tokenId token id
     * @return JSON string
     * @throws PdfFillerAPIException
     */
    public String delete(String tokenId) throws PdfFillerAPIException {
        if (tokenId == null) {
            throw new PdfFillerAPIException(400, "Missing the required parameter 'tokenId' when calling token delete.");
        }

        String path = API_PATH + '/' + tokenId;

        return apiClient.call(path, "DELETE", null, null, null);
    }
}
