package com.example.cse564.models.foodprofiles;

public class FoodProfile {
  private float targetTemp;
  private float targetGrillTemp;
  private float targetFlipTemp;
  private String name;
  
  public FoodProfile(float targetTemp, float targetGrillTemp, float targetFlipTemp, String name) {
    this.targetTemp = targetTemp;
    this.targetGrillTemp = targetGrillTemp;
    this.targetFlipTemp = targetFlipTemp;
    this.name = name;
  }
  
  public float getTargetTemp() { return targetTemp; }

  public float getTargetGrillTemp() { return targetGrillTemp; }

  public float getTargetFlipTemp() { return targetFlipTemp; }

  public String getName() { return name; }
}

