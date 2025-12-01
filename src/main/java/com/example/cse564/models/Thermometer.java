package com.example.cse564.models;

public class Thermometer {
  private static Thermometer instance;
  private boolean isFlipped = false;
  private boolean isFoodReady = false;
  private float internalTemp = 0.0f;
  private float internalHeatAdjustLevel = 0.1f;
  private float grillHeatAdjustLevel = 0.05f;
  

  private Thermometer() {}
  
  public static Thermometer getInstance() {
    if (instance == null) {
      instance = new Thermometer();
    }
    return instance;
  }


  public float getInternalTemp() { return internalTemp; }

  public float getInternalHeatAdjustLevel() { return internalHeatAdjustLevel; }

  public float getGrillHeatAdjustLevel() { return grillHeatAdjustLevel; }

  public boolean getIsFlipped() { return isFlipped; }

  public boolean getIsFoodReady() { return isFoodReady; }


  public void updateInternalTemp(float grillTemp, float targetTemp, float targetGrillTemp) {
    float normalRate = (targetTemp - this.internalTemp) * this.internalHeatAdjustLevel;
    float grillRate = (targetGrillTemp - grillTemp) * this.grillHeatAdjustLevel;

    internalTemp += normalRate + grillRate;
  }

  public boolean checkFlip(float targetFlipTemp) {
    if (!isFlipped && this.internalTemp >= targetFlipTemp) {
      isFlipped = true;
      return true;
    }

    return false;
  }

  public boolean checkIsFoodReady(float targetTemp) {
    if (!isFoodReady && this.internalTemp >= targetTemp) {
      isFoodReady = true;
      return true;
    }

    return false;
  }

  public void reset() {
    this.isFlipped = false;
    this.isFoodReady = false;
    this.internalTemp = 0.0f;
  }
}

