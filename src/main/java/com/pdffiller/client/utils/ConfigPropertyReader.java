package com.pdffiller.client.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.pdffiller.client.dto.ConfigProperties;
import com.pdffiller.client.exception.PdfFillerAPIException;

public class ConfigPropertyReader {
    /**
     * Reads properties from the configuration properties file 
    */
	public static ConfigProperties getPropValues(String propertyFile) throws PdfFillerAPIException {
	    FileInputStream inputStream = null;
	    ConfigProperties config = new ConfigProperties();
		try {
			Properties prop = new Properties();
			inputStream = new FileInputStream(propertyFile);
			if (inputStream != null) {
			  prop.load(inputStream);
			}
			
			String clientId = prop.getProperty("client_id");
			if (clientId == null || clientId.isEmpty()){
			  throw new PdfFillerAPIException("required client_id property is missing in property file");
			}else{
			  config.setClientId(clientId);
			}			  
			
			String clientSecret = prop.getProperty("client_secret");
			if (clientSecret == null || clientSecret.isEmpty()){
			  throw new PdfFillerAPIException("required client_secret property is missing in property file");
			}else{
			  config.setClientSecret(clientSecret);
			}
			
			String apiUrl = prop.getProperty("api_url");
			if (apiUrl != null && !apiUrl.isEmpty()){
			  config.setApiUrl(apiUrl);;
			}
			
			String apiVersion = prop.getProperty("api_version");
			if (apiVersion != null && !apiVersion.isEmpty()){
			  config.setApiUrl(apiVersion);;
			}		
			
		} catch (Exception e) {
		   e.printStackTrace(); 
		   throw new PdfFillerAPIException("Error reading properties file: " + e.toString());
		} finally {
			try {
			  if (inputStream != null)
			    inputStream.close();
			} catch (IOException e) {
			  e.printStackTrace();
			}
		}
		return config;
	}  
}
