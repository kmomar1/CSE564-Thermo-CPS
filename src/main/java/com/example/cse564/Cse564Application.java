package com.example.cse564;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cse564.controllers.SystemController;
import com.example.cse564.models.Phone;
import com.example.cse564.models.Thermometer;
import com.example.cse564.models.foodprofiles.SteakProfile;

@SpringBootApplication
public class Cse564Application {

	public static void main(String[] args) {
		// SpringApplication.run(Cse564Application.class, args);
		SystemController controller = new SystemController();
		
		controller.startCooking(new SteakProfile());

		while (!Thermometer.getInstance().getIsFoodReady()) {
			Phone phoneInstance = Phone.getInstance();

			try {
				controller.simulateStep();

				System.out.printf("Current Food Readiness Status Notification: %s\n", phoneInstance.getReadyStatus());
				System.out.printf("Current Food Flip Status Notification: %s%n", phoneInstance.getFlipStatus());

				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Simulation complete!");
	}

}
