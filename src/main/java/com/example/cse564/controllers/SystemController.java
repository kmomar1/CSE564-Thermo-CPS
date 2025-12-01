package com.example.cse564.controllers;

import com.example.cse564.models.Grill;
import com.example.cse564.models.Thermometer;
import com.example.cse564.models.Phone;
import com.example.cse564.models.foodprofiles.FoodProfile;

public class SystemController {
  private Grill grill;
  private Thermometer thermometer;
  private Phone phone;
  private float maxDisturbance = 30.0f;
  
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
    if (profile == null || !this.grill.getIsGrillOn()) {
      System.out.println("Not cooking anything – skipping step.");
      return;
    }

    float targetGrillTemp = profile.getTargetGrillTemp();
    float targetInternalTemp = profile.getTargetTemp();
    float targetFlipTemp = profile.getTargetFlipTemp();

    float currentGrillTemp = this.grill.getGrillTemp();

    float randomHeatDisturbance = (float) (Math.random() - 0.5) * this.maxDisturbance;

    System.out.println("\n=== Simulation Step ===\n");
    System.out.printf("Current grill temp -> %.1f°F | Internal temp: %.1f°F%n",
        currentGrillTemp, this.thermometer.getInternalTemp());
    System.out.printf("Targets -> Grill: %.1f°F | Internal: %.1f°F | Flip: %.1f°F%n",
        targetGrillTemp, targetInternalTemp, targetFlipTemp);

    System.out.printf("\nRandom temperature disturbance applied: %+4.1f°F%n\n", randomHeatDisturbance);

    this.grill.adjustHeat(randomHeatDisturbance);
    this.grill.adjustHeatToTarget(targetGrillTemp);

    System.out.printf("Grill temperature after update: %.1f°F%n", this.grill.getGrillTemp());

    this.thermometer.updateInternalTemp(targetInternalTemp, targetGrillTemp);
    System.out.printf("Internal temperature after update: %.1f°F%n", this.thermometer.getInternalTemp());

    boolean flipAlert = thermometer.checkFlip(targetFlipTemp);
    this.phone.notifyFoodFlipStatus(flipAlert);

    boolean foodReadyAlert = this.thermometer.checkIsFoodReady(targetInternalTemp);
    this.phone.notifyFoodReadyStatus(foodReadyAlert);

    System.out.printf("\nFlip alert: %s | Ready alert: %s%n",
        flipAlert ? "YES" : "NO", foodReadyAlert ? "YES" : "NO");

    if (foodReadyAlert) {
      this.grill.setGrillToIdle();

      System.out.println("\nFood ready – grill will maintain idle temperature of " + this.grill.getIdleTemp() + " to keep food hot");
    }

    System.out.println();
  }
}

