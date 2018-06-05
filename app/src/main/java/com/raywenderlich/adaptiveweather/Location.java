package com.raywenderlich.adaptiveweather;


import java.util.List;

class Location {

  private String name;
  private List<String> forecast;

  public Location(String name, List<String> forecast) {
    this.name = name;
    this.forecast = forecast;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getForecast() {
    return forecast;
  }

  public void setForecast(List<String> forecast) {
    this.forecast = forecast;
  }
}
