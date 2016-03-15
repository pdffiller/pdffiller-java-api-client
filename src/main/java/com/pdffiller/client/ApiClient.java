package com.pdffiller.client;

import java.util.HashMap;
import java.util.List;

import com.pdffiller.client.dto.Params;
import com.pdffiller.client.exception.PdfFillerAPIException;

public interface ApiClient {
  public <T> T call(String path, String method, List<Params> queryParams, HashMap<String, String> headerParams, Object body, Class<?> klazz) throws PdfFillerAPIException; 
  public String call(String path, String method, List<Params> queryParams, HashMap<String, String> headerParams, Object body) throws PdfFillerAPIException; 
}