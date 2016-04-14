package com.pdffiller.client.dto;

public class DateResponse {
  private String date = null;
  private String timezone_type = null;
  private String timezone = null;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTimezone_type() {
    return timezone_type;
  }

  public void setTimezone_type(String timezone_type) {
    this.timezone_type = timezone_type;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  @Override
  public String toString() {
    return "Date " + date + ", timezone " + timezone + ", timezone type " + timezone_type;
  }
}
