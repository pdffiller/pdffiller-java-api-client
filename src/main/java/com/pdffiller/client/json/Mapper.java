package com.pdffiller.client.json;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.pdffiller.client.dto.HttpResponse;
import com.pdffiller.client.exception.PdfFillerAPIException;

public class Mapper {
  private Gson mapper;

  public Mapper() {
    mapper = new Gson();
  }

  /**
   * Serialize the given Java object into JSON string.
  */
  public String serialize(Object obj) throws PdfFillerAPIException {
    try {
      if (obj != null)
        return mapper.toJson(obj);
      else
        return null;
    } catch (Exception e) {
      throw new PdfFillerAPIException(400, e.getMessage());
    }
  }

  /**
   * Deserialize the given JSON string to Java object.
   *
   * @param body The JSON string
   * @param returnType The type to deserialize into
   * @return The deserialized Java object
   */
  public <T> T deserialize(String body, Type returnType) throws PdfFillerAPIException {
	return mapper.fromJson(body, returnType);
  }
  
  /**
   * Serialize the given Java object into string according the given
   * Content-Type (only JSON is supported for now).
   */
  public String serialize(Object obj, String contentType) throws PdfFillerAPIException {
    if (contentType.startsWith("application/json")) {
      return this.serialize(obj);
    } else {
      throw new PdfFillerAPIException(400, "can not serialize object into Content-Type: " + contentType);
    }
  }

  /**
   * Deserialize response body to Java object according to the Content-Type.
   */
  public <T> T deserialize(HttpResponse response, Type returnType) throws PdfFillerAPIException {
    String body;
    if (response.getBody() != null && !response.getBody().isEmpty())
      body = response.getBody();
    else
      body = "";
    
    List<String> contentType = response.getHeaders().get("Content-Type"); 

    if (contentType.contains("application/json")) {
      return this.deserialize(body, returnType);
    } else if (returnType.equals(String.class)) {
      // Expecting string, return the raw response body.
      return (T) body;
    } else {
      throw new PdfFillerAPIException(
        "Content type \"" + contentType + "\" is not supported for type: "
          + returnType
      );
    }
  }  
}
