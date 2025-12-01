package com.example.cse564.models;

public class Grill {
  private static Grill instance;
  private boolean grillOn = false;
  private float idleTemp = 175.0f;
  private float grillTemp = 0.0f;
  
  private Grill() {
  }
  
  public static Grill getInstance() {
    if (instance == null) {
      instance = new Grill();
    }
    return instance;
  }
  
  public boolean getIsGrillOn() { return grillOn; }

  public float getIdleTemp() { return idleTemp; }

  public float getGrillTemp() { return grillTemp; }

  public void setGrillOn(boolean grillOn) { this.grillOn = grillOn;}

  public void increaseGrillTemp(float adjustLevel) { this.grillTemp += adjustLevel; }

  public void decreaseGrillTemp(float adjustLevel) { this.grillTemp -= adjustLevel; }
}

