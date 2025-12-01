package com.example.cse564.models;

public class Thermometer {
  private static Thermometer instance;
  private boolean isFlipped = false;
  private boolean isFoodReady = false;
  private float internalTemp = 0;
  private float internalHeatAdjustLevel = 5.0f;
  private float grillHeatAdjustLevel = 15.0f;
  
  private Thermometer() {
  }
  
  public static Thermometer getInstance() {
    if (instance == null) {
      instance = new Thermometer();
    }
    return instance;
  }
  
  public boolean getIsFlipped() {
    return isFlipped;
  }
  
  public boolean getIsFoodReady() {
    return isFoodReady;
  }
  
  public float getInternalTemp() {
    return internalTemp;
  }

  public void setIsFlipped(boolean isFlipped) {
    this.isFlipped = isFlipped;
  }

  public void setIsFoodReady(boolean isFoodReady) {
    this.isFoodReady = isFoodReady;
  }
  
  public void increaseInternalTemp(float adjustLevel) {
    this.internalTemp += adjustLevel;
  }
  
  public void decreaseInternalTemp(float adjustLevel) {
    this.internalTemp -= adjustLevel;
  }
}

