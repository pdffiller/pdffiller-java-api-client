package com.pdffiller.client.utils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.HashMap;

public class MultipartHelper {
  private static final String CRLF = "\r\n";
  private File file;
  private String boundary;
  private byte[] message;

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public byte[] getMessage() {
    return message;
  }

  public MultipartHelper(String file) {
    this.file = new File(file);
    boundary = generateBoundary();
    message = formRequest();
  }

  private String generateBoundary() {
    SecureRandom random = new SecureRandom();
    return new BigInteger(20, random).toString();
  }

  private String getMime() {
    String mime = null;
    try {
      mime = Files.probeContentType(file.toPath());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return mime;
  }

  public byte[] getFileContent() {
    byte[] content = new byte[0];
    try {
      content = Files.readAllBytes(file.toPath());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
  }

  public byte[] formRequest() {
    String message1 = "--" + boundary + CRLF;

    message1 += "Content-Disposition: form-data; name=\"file\";" +
            " filename=\"" + file.getName() + "\"" + CRLF;
    message1 += "Content-Type: " + getMime() + CRLF;
    message1 += "Content-Transfer-Encoding: binary" + CRLF + CRLF;

    byte[] content = getFileContent();
    String message2 = CRLF + CRLF + "--" + boundary + "--" + CRLF;

    byte[] message = new byte[message1.getBytes().length + content.length + message2.getBytes().length];

    System.arraycopy(message1.getBytes(), 0, message, 0, message1.getBytes().length);
    System.arraycopy(content, 0, message, message1.getBytes().length, content.length);
    System.arraycopy(message2.getBytes(), 0, message, content.length + message1.getBytes().length, message2.getBytes().length);

    return message;
  }

  public HashMap<String, String> getHeaders() {
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "multipart/form-data; boundary=\"" + boundary + "\"");
    headers.put("Content-Length", String.valueOf(message.length));

    return headers;
  }

}
