package com.example.cse564.models;

public class Grill {
  private boolean grillOn = false;
  private float idleTemp = 175.0f;
  private float grillTemp = 0.0f;
  
  public void turnGrillOn() {
  }
  
  public void turnGrillOff() {
  }
  
  public boolean getIsGrillOn() {
    return grillOn;
  }
  
  public float getIdleTemp() {
    return idleTemp;
  }
  
  public float getGrillTemp() {
    return grillTemp;
  }
  
  public void increaseGrillTemp(float adjustLevel) {
    this.grillTemp += adjustLevel;
  }
  
  public void decreaseGrillTemp(float adjustLevel) {
    this.grillTemp -= adjustLevel;
  }
}

