package com.pdffiller.client.dto;

import java.util.HashMap;
import java.util.Map;

public class FillableTemplateRequestBody {
  private int document_id;
  private Map<String,String> fillable_fields = new HashMap<String,String>();

  /**
   * @param key
   * @param value
   * @return
   */
  public Map<String,String> addFields(String key, String value){
    fillable_fields.put(key, value);
    return fillable_fields;     
  }
  
  /**
   * @return
   */
  public int getDocumentId() {
    return document_id;
  }

  /**
   * @param document_id
   */
  public void setDocumentId(int document_id) {
    this.document_id = document_id;
  }

  /**
   * @return
   */
  public Map<String,String> getFillableFields() {
    return fillable_fields;
  }

  /**
   * @param fillable_fields
   */
  public void setFillableFields(Map<String,String> fillable_fields) {
    this.fillable_fields = fillable_fields;
  }
}
