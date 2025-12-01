package com.example.cse564.controllers;

import com.example.cse564.models.Grill;
import com.example.cse564.models.Thermometer;
import com.example.cse564.models.Phone;
import com.example.cse564.models.foodprofiles.FoodProfile;

public class SystemController {
  private Grill grill;
  private Thermometer thermometer;
  private Phone phone;
  
  public SystemController() {
    this.grill = Grill.getInstance();
    this.thermometer = Thermometer.getInstance();
    this.phone = Phone.getInstance();
  }
  
  public void startCooking(FoodProfile profile) {
    phone.setSelectedFoodProfile(profile);
    grill.setGrillOn(true);
  }
  
  public void stopCooking() {
    grill.setGrillOn(false);
  }
  
  public void simulateStep() {
  }
}

