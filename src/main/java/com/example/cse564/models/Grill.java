package com.example.cse564.models;

public class Grill {
  private static Grill instance;
  private boolean grillOn = false;
  private float idleTemp = 175.0f;
  private float grillTemp = 0.0f;
  private float grillHeatAdjustLevel = 0.7f;

  

  private Grill() {}
  
  public static Grill getInstance() {
    if (instance == null) {
      instance = new Grill();
    }
    return instance;
  }
  

  public boolean getIsGrillOn() { return grillOn; }

  public float getIdleTemp() { return idleTemp; }

  public float getGrillTemp() { return grillTemp; }

  public void adjustHeat(float adjustLevel) { this.grillTemp += adjustLevel; }


  public void adjustHeatToTarget(float targetGrillTemp) {
    float rate = (targetGrillTemp - this.grillTemp) * this.grillHeatAdjustLevel;
    this.adjustHeat(rate);
  }
  
  public void turnGrillOn(float targetGrillTemp) { 
    this.grillOn = true;
  }

  public void turnGrillOff() { 
    this.grillOn = false;
    this.grillTemp = 0.0f;
  }

  public void setGrillToIdle() {
    this.grillTemp = this.idleTemp;
  }
}

