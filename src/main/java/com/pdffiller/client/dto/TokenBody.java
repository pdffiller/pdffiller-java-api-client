package com.pdffiller.client.dto;

import java.util.HashMap;
import java.util.Map;

public class TokenBody {
    private Integer id = null;
    private String hash = null;
    private Map<String, String> data = new HashMap<>();

    public TokenBody(Map<String, String> data){
        this.data = data;
    }

    public TokenBody(Integer id, String hash, Map<String, String> data){
        this.id = id;
        this.hash = hash;
        this.data = data;
    }

    /**
     * Returns token id.
     * @return token id
     */
    public Integer getId() {
        return id;
    }
    /**
     * Returns token id.
     * @return token id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns token hash.
     * @return token hash
     */
    public String getHash() {
        return hash;
    }
    /**
     * Returns token hash.
     * @return token hash
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * Returns token data.
     * @return token data
     */
    public Map<String, String> getData() {
        return data;
    }

    /**
     * Returns token data.
     * @return token data
     */
    public String getData(String key) {
        return data.get(key);
    }

    /**
     * Sets new token data.
     * @param data token data to set
     */
    public void setData(HashMap<String, String> data) {
        this.data = data;
    }

    public void addToData(String key, String value) {
        this.data.put(key, value);
    }

    public String removeFromData(String key) {
        return this.data.remove(key);
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("class TokenBody {\n");
        string.append("    id: ").append(id.toString()).append("\n");
        string.append("    hash: ").append(hash.toString()).append("\n");
        string.append("    data: ").append(data.toString()).append("\n");
        string.append("}");

        return string.toString();
    }
}
