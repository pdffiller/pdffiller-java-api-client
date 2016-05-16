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

  public String getTimezoneType() {
    return timezone_type;
  }

  public void setTimezoneType(String timezoneType) {
    this.timezone_type = timezoneType;
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
