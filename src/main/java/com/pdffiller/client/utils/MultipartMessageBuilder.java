package com.pdffiller.client.utils;

import com.pdffiller.client.exception.PdfFillerAPIException;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.HashMap;

public class MultipartMessageBuilder {
  private static final String CRLF = "\r\n";
  private File file;
  private String boundary;
  private HashMap<String, String> headers = new HashMap<>();

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public MultipartMessageBuilder(String file) {
    this.file = new File(file);
  }

  private void generateBoundary() {
      SecureRandom random = new SecureRandom();
      boundary = new BigInteger(20, random).toString();
  }

  private String getMime() throws PdfFillerAPIException {
    String mime = null;

    try {
      mime = Files.probeContentType(file.toPath());
    } catch (IOException e) {
      e.printStackTrace();
      throw new PdfFillerAPIException(e.getMessage());
    }

    return mime;
  }

  private byte[] getFileContent() throws PdfFillerAPIException {
    byte[] content = new byte[0];

    try {
      content = Files.readAllBytes(file.toPath());
    } catch (IOException e) {
      e.printStackTrace();
      throw new PdfFillerAPIException(e.getMessage());
    }

    return content;
  }

  public byte[] formRequest() throws PdfFillerAPIException {
    generateBoundary();

    StringBuilder messageHeaderString = new StringBuilder();
    StringBuilder messageBoundaryString = new StringBuilder();
    byte[] messageContent = getFileContent();

    messageHeaderString.append("--").append(boundary).append(CRLF);
    messageHeaderString.append("Content-Disposition: form-data; name=\"file\"; filename=\"");
    messageHeaderString.append(file.getName()).append("\"").append(CRLF);
    messageHeaderString.append("Content-Type: ").append(getMime()).append(CRLF);
    messageHeaderString.append("Content-Transfer-Encoding: binary").append(CRLF).append(CRLF);

    messageBoundaryString.append(CRLF).append(CRLF).append("--").append(boundary).append("--").append(CRLF);

    byte[] messageHeader = messageHeaderString.toString().getBytes();
    byte[] messageBoundary = messageBoundaryString.toString().getBytes();
    byte[] message = new byte[messageHeader.length + messageContent.length + messageBoundary.length];

    setHeaders(message.length);

    System.arraycopy(messageHeader, 0, message, 0, messageHeader.length);
    System.arraycopy(messageContent, 0, message, messageHeader.length, messageContent.length);
    System.arraycopy(messageBoundary, 0, message, messageContent.length + messageHeader.length, messageBoundary.length);

    return message;
  }

  private void setHeaders(int length) {
    headers.put("Content-Type", "multipart/form-data; boundary=\"" + boundary + "\"");
    headers.put("Content-Length", String.valueOf(length));
  }

  public HashMap<String, String> getHeaders() {
    return headers;
  }
}
