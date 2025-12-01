package com.example.cse564.models;

import com.example.cse564.models.foodprofiles.FoodProfile;

public class Phone {
  private static Phone instance;
  private FoodProfile selectedFoodProfile = null;
  
  private Phone() {
  }
  
  public static Phone getInstance() {
    if (instance == null) {
      instance = new Phone();
    }
    return instance;
  }
  
  public FoodProfile getSelectedFoodProfile() { return selectedFoodProfile; }
  
  public void setSelectedFoodProfile(FoodProfile profile) { this.selectedFoodProfile = profile; }
  
  public void notifyFoodReadyStatus() {
    
  }
  
  public void notifyFoodFlipStatus() {
  }
}

