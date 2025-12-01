package com.example.cse564.controllers;

import com.example.cse564.models.Grill;
import com.example.cse564.models.Thermometer;
import com.example.cse564.models.Phone;
import com.example.cse564.models.foodprofiles.FoodProfile;

public class SystemController {
  private Grill grill;
  private Thermometer thermometer;
  private Phone phone;
  private float maxDisturbance = 15.0f;
  
  public SystemController() {
    this.phone = Phone.getInstance();
    this.grill = Grill.getInstance();
    this.thermometer = Thermometer.getInstance();
  }
  

  public void startCooking(FoodProfile profile) {
    this.phone.setSelectedFoodProfile(profile);
    this.grill.turnGrillOn(profile.getTargetGrillTemp());
  }
  
  public void stopCooking() {
    this.phone.reset();
    this.grill.turnGrillOff();
    this.thermometer.reset();
  }
  
  public void simulateStep() {
    FoodProfile profile = this.phone.getSelectedFoodProfile();

    float targetGrillTemp = profile.getTargetGrillTemp();
    float targetInternalTemp = profile.getTargetTemp();
    float targetFlipTemp = profile.getTargetFlipTemp();

    float grillHeatAdjustLevel = this.thermometer.getGrillHeatAdjustLevel();
    float currentGrillTemp = this.grill.getGrillTemp();

    float randomHeatDisturbance = (float) (Math.random() - 0.5) * this.maxDisturbance;

    if (profile == null || !this.grill.getIsGrillOn()) return;

    this.grill.adjustHeat(randomHeatDisturbance);
    this.grill.adjustHeatToTarget(targetGrillTemp, grillHeatAdjustLevel);
    this.thermometer.updateInternalTemp(currentGrillTemp, targetInternalTemp, targetGrillTemp);

    boolean flipAlert = thermometer.checkFlip(targetFlipTemp);
    this.phone.notifyFoodFlipStatus(flipAlert);

    boolean foodReadyAlert = this.thermometer.checkIsFoodReady(targetInternalTemp);
    this.phone.notifyFoodReadyStatus(foodReadyAlert);

    if (foodReadyAlert) this.grill.setGrillToIdle();
  }
}

