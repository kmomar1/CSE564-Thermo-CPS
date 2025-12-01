package com.example.cse564.models;

import com.example.cse564.models.foodprofiles.FoodProfile;

public class Phone {
  private FoodProfile selectedFoodProfile = null;
  
  public FoodProfile getSelectedFoodProfile() {
    return selectedFoodProfile;
  }
  
  public void setSelectedFoodProfile(FoodProfile profile) {
    this.selectedFoodProfile = profile;
  }
  
  public void notifyFoodReadyStatus() {
  }
  
  public void notifyFoodFlipStatus() {
  }
}

