/*	Chi Lam Tsang */

import javax.swing.*;

public class Interface {

	// TODO: ask need to handle "" string input/ press enter will exit function?

	// Classes.
	private Farm farm1, farm2;

	public static void main(String[] args) {
		Interface intFace = new Interface();
		intFace.run();

	}

	public void run() {
		// Welcome message
		this.printMessage("Welcome to Smart Farm!");

		// input = JOptionPane.showInputDialog(str);
		// OptionPaneUI.showMessageDialog(null,str,"message",JOptionPane.INFORMATION_MESSAGE);

		// show interface
		this.showMenu();
	}

	private void showMenu() {
		int action = 0;
		String message = "";

		message += "Functions: \n";
		message += "1: Add farm \n";
		message += "2: Remove farm \n";
		message += "3: Add farm sensor \n";
		message += "4: Remove one sensor from farm \n";
		message += "5: List all farms, with total number of sensors \n";
		message += "6: List farm sensors, with type, price, weight, and quantity \n";
		message += "7: List sensor quantity in all farms \n";
		message += "8: List total sensor quantity and total cost \n";
		message += "9: Exit \n\n";
		message += "Please enter a function number (1-9)";

		// ask for function input
		action = this.getInputInt(message);

		// there are 8 functions, check if the input is from 1-8
		while (action <= 0 || action > 9) {
			action = this.getInputInt(message);
			
			// check if exit 
			if (action == 9) {
				this.printMessage("Goodbye, thanks");
				return;
			}
		}
		
		// check if exit 
		if (action == 9) {
			this.printMessage("Goodbye, thanks");
			return;
		} else {
			// perform the function
			this.performFarmAction(action);
	
			// display menu again after each action is completed
			this.showMenu();
		}
	}

	private boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++)
			if (Character.isDigit(s.charAt(i)) == false) {
				return false;
			}
		return true;
	}

	private void printMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	// perform action
	private void performFarmAction(int action) {
		switch (action) {
			case 1:
				this.addFarm();
				break;
			case 2:
				this.removeFarm();
				break;
			case 3:
				this.addFarmSensor();
				break;
			case 4:
				this.reduceFarmSensorQuantity();
				break;
			case 5:
				this.listAllFarms();
				break;
			case 6:
				this.listFarmSensors();
				break;
			case 7:
				this.listFarmSensorQuantity();
				break;
			case 8:
				this.listSensorSummary();
				break;
			default:
				this.printMessage("We don't have this function, please enter again.");
				break;
		}
		return;
	}

	// Function 1: Add farm
	private void addFarm() {
		String lastName;

		// check if all farms are occupied
		// if both farms are occupied, show error message
		if (this.farm1 != null && this.farm2 != null) {
			this.printMessage("New farm cannot be created, maximum 2 farms.");
			return;
		}

		lastName = this.getInputString("last name");

		// check if farm name is duplicated
		if (this.farm1 != null) {
			if (this.farm1.getName().equals(lastName)) {
				this.printMessage(lastName + " farm name is duplicated.");
				return;
			}
		}
		if (this.farm2 != null) {
			if (this.farm2.getName().equals(lastName)) {
				this.printMessage(lastName + " farm name is duplicated.");
				return;
			}
		}

		// validate farms
		if (this.farm1 == null) { // validate if farm1 is null, if null, create farm1
			this.farm1 = new Farm();
			this.farm1.addFarm("farm1", lastName);

		} else if (this.farm2 == null) { // validate if farm2 is null, if null, create farm2
			this.farm2 = new Farm();
			this.farm2.addFarm("farm2", lastName);

		}

	}

	// This reusable function checks if the given farm exists.
	// If the farm name belongs to one of the farms, the corresponding farm will be returned,
	// or else, null will be returned.
	private Farm checkFarmExist(String farmName) {
		Farm getFarm = null;

		// check if the name belongs to farm1, farm2, or not found
		if (this.farm1 != null) {
			if (this.farm1.getName().equals(farmName)) {
				getFarm = this.farm1;
			}
		}
		if (this.farm2 != null) {
			if (this.farm2.getName().equals(farmName)) {
				getFarm = this.farm2;
			}
		}

		return getFarm;
	}

	// Function 2: Remove Farm
	private void removeFarm() {
		String farmName = this.getInputString("farm name");

		// check if the farm name belongs to any farm
		if (this.checkFarmExist(farmName) == null) {
			this.printMessage("The farm does not exist.");
			return;
		}

		// check if the name belongs to farm1, farm2, or not found
		if (this.farm1 != null) {
			if (this.farm1.getName().equals(farmName)) {
				this.farm1 = null;
				this.printMessage(farmName + " has been removed.");
			}
		}
		if (this.farm2 != null) {
			if (this.farm2.getName().equals(farmName)) {
				this.farm2 = null;
				this.printMessage(farmName + " has been removed.");
			}
		}

	}

	// Function 3: Add Farm Sensor
	private void addFarmSensor() {
		String farmName, typeName;
		Farm getFarm;
		Sensor farmSensor = null;

		// get name input to locate farm
		farmName = this.getInputString("farm name");
		getFarm = this.checkFarmExist(farmName);

		// check if farm exists
		if (getFarm == null) {
			this.printMessage(farmName + " does not exist.");
			return;
		}

		// get sensor type
		typeName = JOptionPane.showInputDialog("Please enter a sensor type (Temperature, Pressure, Humidity, Soil Temperature, Soil, Soil PH): ");

		// check if the sensor types are valid, e.g. Temperature, Pressure, Humidity, Soil Temperature, Soil, Soil PH
		while (this.checkSensorType(typeName).equals("")) {
			typeName = JOptionPane.showInputDialog("Please enter a valid sensor type (Temperature, Pressure, Humidity, Soil Temperature, Soil, Soil PH): ");
		}

		// Check if the sensor type exists in any farm
		// getFarmSensor function returns the sensor type that exists in the farm.
		// If no such sensor type exists, the function returns null.
		farmSensor = getFarm.getFarmSensor(typeName);
		
		// if the sensor type exists in the farm, adjust the sensor quantity
		// if not, add a sensor to the farm
		if (farmSensor != null) {
			this.addExistingSensor(getFarm, farmSensor);
		} else {
			this.addNewSensor(getFarm, typeName);
		}

	}

	private String checkSensorType(String typeName) {
		String sensorType = "";

		// clean input for searching
		typeName = typeName.toLowerCase().trim();
		// Temperature, Pressure, Humidity, Soil Temperature, Soil, Soil PH

		switch (typeName) {
			case "temperature":
				sensorType = "temperature";
				break;
			case "pressure":
				sensorType = "pressure";
				break;
			case "humidity":
				sensorType = "humidity";
				break;
			case "soil temperature":
				sensorType = "soil temperature";
				break;
			case "soil":
				sensorType = "soil";
				break;
			case "soil ph":
				sensorType = "soil ph";
				break;

			default:
				break;
		}

		return sensorType;
	}

	private void addExistingSensor(Farm farm, Sensor sensor) {
		int addQuantity = 0;
		
		// output message that the sensor exists in the farm
		String message = String.format("%s sensor exists, with price $%.1f and weight %.1f \n",
				sensor.getType(), sensor.getPrice(), sensor.getWeight());
		this.printMessage(message);

		// get sensor quantity
		addQuantity = this.getInputInt("sensor quantity");

		// adjust sensor quantity
		farm = farm.updateSensorQuantity(sensor, addQuantity);

	}

	// get all required inputs from user for adding sensors
	// get farm name, price, weight, quantity
	private void addNewSensor(Farm farm, String typeName) {
		Double price = 0.0;
		Double weight = 0.0;
		int quantity = 0;

		// check if the farm already holds 3 different types of sensors
		if (farm.countFarmSensorType() == 3) {
			this.printMessage(farm.getName() + " already holds 3 different types of sensors.");
			return;
		}

		// get sensor price
		price = this.getInputDouble("sensor price");

		// get sensor weight
		weight = this.getInputDouble("sensor weight");

		// get sensor quantity
		quantity = this.getInputInt("sensor quantity");

		farm.addSensor(farm, typeName, price, weight, quantity);

	}

	// This is a reusable function to help get an input in double type
	// This function validates if the input is a double, and not empty
	private double getInputDouble(String message) {
		String inputMessage = "Please enter ";
		String inputString = "";
		double inputDouble = 0.0;
		
		// get input
		inputString = JOptionPane.showInputDialog(inputMessage + message + ": ");

		// clean input
		inputString = inputString.trim();
		
		// check if the input is a double
		// using the replace function below removes the decimal point charcter from input,
		// in order to check if all characters in the input are numeric
		while (!isNumber(inputString.replace(".", "")) || inputString.equals("")) {
			inputString = JOptionPane.showInputDialog(inputMessage + "a valid " + message + ": ");
		}

		// parse input into double
		inputDouble = Double.parseDouble(inputString);

		return inputDouble;
	}

	// This is a reusable function to help get an input in integer type
	// This function validates if the input is a integer, and not empty
	private int getInputInt(String message) {
		String inputMessage = "Please enter ";
		String inputString = "";
		int inputInt = 0;
		
		// get input
		inputString = JOptionPane.showInputDialog(inputMessage + message + ": ");

		// clean input
		inputString = inputString.trim();
		
		// check if the input is a integer
		while (!isNumber(inputString) || inputString.equals("")) {
			inputString = JOptionPane.showInputDialog(inputMessage + "a valid " + message);
		}

		// parse input into integer
		inputInt = Integer.parseInt(inputString);

		return inputInt;
	}

	// This is a reusable function to help get an input in string type
	// This function validates if the input is not empty
	private String getInputString(String message) {
		String inputMessage = "Please enter ";
		String inputString = "";

		// get input
		inputString = JOptionPane.showInputDialog(inputMessage + message + ": ");

		while (inputString.equals("")) {
			inputString = JOptionPane.showInputDialog(inputMessage + "a valid " + message);
		}

		// clean the input
		inputString = inputString.trim().toLowerCase();

		return inputString;
	}

	// Function 4: Remove Farm Sensor
	// this function removes sensor quantity by 1
	private void reduceFarmSensorQuantity() {
		String farmName, typeName, message = "";
		Farm getFarm;
		// Sensor farmSensor = null;

		// get name input to locate farm
		farmName = this.getInputString("farm name");
		getFarm = this.checkFarmExist(farmName);

		// check if farm exists
		if (getFarm == null) {
			this.printMessage(farmName + " does not exist.");
			return;
		}

		// get sensor type
		message = "sensor type (Temperature, Pressure, Humidity, Soil Temperature, Soil, Soil PH)";
		typeName = this.getInputString(message);

		// start update the quantity
		if (this.farm1 != null) {
			// get the sensor
			Sensor farmSensor = this.farm1.getFarmSensor(typeName);

			// reduce quantity
			if (this.farm1.getName().equals(farmName) && farmSensor != null) {
				this.farm1 = this.farm1.updateSensorQuantity(farmSensor, -1);
			}
		}

		if (this.farm2 != null) {
			// get the sensor
			Sensor farmSensor = this.farm2.getFarmSensor(typeName);

			// reduce quantity
			if (this.farm2.getName().equals(farmName) && farmSensor != null) {
				this.farm2 = this.farm2.updateSensorQuantity(farmSensor, -1);
			}
		}

	}
	
	// Function 5: List all farms, with total number of sensors 
	private void listAllFarms() {
		String message = "";

		// check if any farm exists
		if (this.farm1 == null && this.farm2 == null) {
			message = "No farm exists";
			this.printMessage(message);
			return;
		}

		if (this.farm1 != null) {
			// getSensorQuantitySum function calculates the sum of the sensor quantity
			// parameter "ALL" is put to get the sum for all sensor types
			message += String.format("%s has %d sensor(s). \n", this.farm1.getName(), this.farm1.countFarmSensorType());
		}

		if (this.farm2 != null) {
			// getSensorQuantitySum function calculates the sum of the sensor quantity
			// parameter "ALL" is put to get the sum for all sensor types
			message += String.format("%s has %d sensor(s).", this.farm2.getName(), this.farm2.countFarmSensorType());
		}

		this.printMessage(message);

	}

	// Function 6: List sensors of specific farm, with type, price, weight, and quantity 
	private void listFarmSensors() {
		String farmName = this.getInputString("farm name");
		
		// if no farm exists
		if (this.checkFarmExist(farmName) == null) {
			this.printMessage("No farm exists.");
			return;
		}
		
		if (this.farm1 != null) {
			if (this.farm1.getName().equals(farmName)) {
				this.farm1.listSensorDetails();
			}
		} 
		if (this.farm2 != null) {
			if (this.farm2.getName().equals(farmName)) {
				this.farm2.listSensorDetails();
			}
		}
	}

	// Function 7: Display Sensor Details, List sensor quantity in all farms 
	private void listFarmSensorQuantity() {
		String inputMessage = "Please enter a sensor type (Temperature, Pressure, Humidity, Soil Temperature, Soil, Soil PH): ";
		String typeName = "";
		String message = "";
		int totalQuantity = 0;

		// ask for sensor type input
		typeName = this.getInputString(inputMessage);

		// Check farm 1 and farm 2, sum up the sensor quantity
		// if the quantity is 0, that means the sensor doesn't exist in any farm
		if (this.farm1 != null) {
			int quantity = this.farm1.getSensorQuantitySum(typeName);
			totalQuantity += quantity;

			// only output when the farm has the sensor
			if (quantity > 0) {
				message += String.format("%s sensors is at %s with quantity %d. \n",
						typeName, this.farm1.getName(), this.farm1.getSensorQuantitySum(typeName));
			}
		}
		if (this.farm2 != null) {
			int quantity = this.farm2.getSensorQuantitySum(typeName);
			totalQuantity += quantity;
			
			// only output when the farm has the sensor
			if (quantity > 0) {
				message += String.format("%s sensors is at %s with quantity %d. \n",
						typeName, this.farm2.getName(), this.farm2.getSensorQuantitySum(typeName));
			}
		}
		
		// output message that the sensor doesn't exist in any farm
		if (totalQuantity <= 0) {
			message = "The sensor doesn't exist in any farm.";
		}

		// output message
		this.printMessage(message);

	}
	
	
	// Function 8: Display total number of sensors in a farm and total cost
	private void listSensorSummary() {
		
		// get farm name
		String farmName = this.getInputString("farm name");
		
		// if no farm exists
		if (this.farm1 == null && this.farm2 == null) {
			this.printMessage("No farm exists.");
			return;
		}
		
		// start calculate total sensor cost of the farm
		if (this.farm1 != null) {
			if (this.farm1.getName().equals(farmName)) {
				this.farm1.getFarmSensorCostSummary();
			}
		}
		if (this.farm2 != null) {
			if (this.farm2.getName().equals(farmName)) {
				this.farm2.getFarmSensorCostSummary();			
			}
		}
		
	}


	
}
