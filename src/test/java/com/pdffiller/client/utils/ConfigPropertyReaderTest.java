package com.pdffiller.client.utils;

import junit.framework.Assert;

import org.junit.Test;

import com.pdffiller.client.dto.ConfigProperties;
import com.pdffiller.client.exception.PdfFillerAPIException;
import com.pdffiller.client.utils.ConfigPropertyReader;

public class ConfigPropertyReaderTest {

  @Test
  public void testReadPropertyFile() throws PdfFillerAPIException {
	String propertyFile = "pdffiller.config.properties";
	ConfigProperties props = ConfigPropertyReader.getPropValues(propertyFile);
	Assert.assertEquals(props.getClientId(),"CLIENT_ID");
	Assert.assertEquals(props.getClientSecret(),"CLIENT_SECRET");	
  }
}
