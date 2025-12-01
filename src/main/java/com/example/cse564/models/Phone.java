package com.example.cse564.models;

import com.example.cse564.models.foodprofiles.FoodProfile;

public class Phone {
  private static Phone instance;
  private FoodProfile selectedFoodProfile = null;
  private String readyStatus = "Idle";
  private String flipStatus = "Idle";
  

  private Phone() {}
  
  public static Phone getInstance() {
    if (instance == null) {
      instance = new Phone();
    }
    return instance;
  }
  

  public FoodProfile getSelectedFoodProfile() { return selectedFoodProfile; }
  
  public void setSelectedFoodProfile(FoodProfile profile) { this.selectedFoodProfile = profile; }
  

  public void notifyFoodReadyStatus(boolean alert) {
    String foodIsReadyMessage = "Your " + selectedFoodProfile.getName() + "is ready";
    String foodInProgressMessage = "Cooking in progress";
    
    this.readyStatus = alert ? foodIsReadyMessage : foodInProgressMessage;
  }
  
  public void notifyFoodFlipStatus(boolean alert) {
    String foodIsReadyMessage = "Time to flip your " + selectedFoodProfile.getName();
    String foodInProgressMessage = "Not ready to flip yet";

    this.flipStatus = alert ? foodIsReadyMessage : foodInProgressMessage;
  }

  public void reset() {
    this.selectedFoodProfile = null;
    this.readyStatus = "Idle";
    this.flipStatus = "Idle";
  }
}

