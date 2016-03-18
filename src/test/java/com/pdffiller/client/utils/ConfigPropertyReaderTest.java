package com.pdffiller.client.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pdffiller.client.dto.ConfigProperties;
import com.pdffiller.client.exception.PdfFillerAPIException;
import com.pdffiller.client.utils.ConfigPropertyReader;

public class ConfigPropertyReaderTest {

  @Test
  public void testReadPropertyFile() throws PdfFillerAPIException {
    String propertyFile = "pdffiller.config.properties";
    ConfigProperties props = ConfigPropertyReader.getPropValues(propertyFile);
    assertTrue(props.getClientId() == "CLIENT_ID");
    assertTrue(props.getClientSecret() == "CLIENT_SECRET"); 
  }
}