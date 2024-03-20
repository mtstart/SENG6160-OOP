/*	Chi Lam Tsang */

public class Farm {
	/*
	 * this program keep tracks of up to 2 farms
	 * each farm have up to 3 sensors
	 */

	private String name;
	private Sensor sensor1, sensor2, sensor3;

	// getName function gets the name of the given Farm
	public String getName() {
		return name;
	}

	// Feature 1: Add Farm
	public String addFarm(String farmName, String lastName) {
		String name = "";

		// set the farm name
		name = setFarmName(farmName, lastName);

		return name;
	}

	private String setFarmName(String farmName, String lastName) {

		name = farmName + lastName;

		return name;
	}

	// check if sensor type exists in any farm
	public Sensor getFarmSensor(String typeName) {
		Sensor getSensor = null;

		// clean input
		typeName = typeName.toLowerCase().trim();

		// check 3 sensors one by one to see if the sensors exists
		if (sensor1 != null) {
			if (sensor1.getType().equals(typeName)) {
				getSensor = sensor1;
			}
		} 
		if (sensor2 != null) {
			if (sensor2.getType().equals(typeName)) {
				getSensor = sensor2;
			}
		}
		if (sensor3 != null) {
			if (sensor2.getType().equals(typeName)) {
				getSensor = sensor3;
			}
		}

		return getSensor;
	}

	public int countFarmSensorType() {
		int counter = 0;

		if (sensor1 != null) {
			counter += 1;
		}
		if (sensor2 != null) {
			counter += 1;
		}
		if (sensor3 != null) {
			counter += 1;
		}

		return counter;
	}

	// Function 3: Add new farm sensor
	public Farm addSensor(Farm farm, String typeName, Double price, Double weight, int quantity) {

		if (sensor1 == null) {
			sensor1 = new Sensor();
			sensor1.insertSensor(typeName, price, weight, quantity);
		} else if (sensor2 == null) {
			sensor2 = new Sensor();
			sensor2.insertSensor(typeName, price, weight, quantity);
		} else if (sensor3 == null) {
			sensor3 = new Sensor();
			sensor3.insertSensor(typeName, price, weight, quantity);
		}
		
		return this;
	}

	// Function 3: Add existing farm sensor
	public void updateSensorQuantity(Sensor sensor, int updateQuantity) {

		// locate the corresponding sensor
		if (sensor1 != null) {
			if (sensor1.getType().equals(sensor.getType())) {
				sensor1.adjustSensorQuantity(updateQuantity);
			}
		} else if (sensor2 != null) {
			if (sensor2.getType().equals(sensor.getType())) {
				sensor2.adjustSensorQuantity(updateQuantity);
			}
		} else if (sensor3 != null) {
			if (sensor2.getType().equals(sensor.getType())) {
				sensor3.adjustSensorQuantity(updateQuantity);
			}
		}

	}

	// Function 3: Add existing farm sensor
	// Function 4: Remove Farm Sensor
	public String checkSensorQuantity(String typeName, int updateQuantity) {
		String message = "";
		// for adding sensor quantity, 
		// output an message that sensors are added

		// for removing sensor quantity, 
		// output an message that sensors are removed
		// and if the quanatity becomes zero, remove the sensor type


		// for adding sensor quantity
		if (updateQuantity > 0) {
			message = String.format("%d %s sensor(s) is added in %s.",
					updateQuantity, typeName, name);
		} else {
			message = String.format("%d %s sensor(s) is removed in %s. \n",
				Math.abs(updateQuantity), typeName, name);

			// for reducing sensor quantity
			if (getSensorQuantitySum(typeName) == 0) {
				removeSensor(typeName);

				message += "As the sensor quantity is zero, " + typeName + " sensor is removed.";
			}

		}
		return message;
	}

	// Function 4: Remove farm sensor if quantity is 0
	private void removeSensor(String typeName) {
		
		if (sensor1 != null) {
			if (sensor1.getType().equals(typeName)) {
				sensor1.removeSensor();
			}
		} 
		if (sensor2 != null) {
			if (sensor2.getType().equals(typeName)) {
				sensor2.removeSensor();
			}
		}
		if (sensor3 != null) {
			if (sensor2.getType().equals(typeName)) {
				sensor3.removeSensor();
			}
		}

	}

	// This is a reusable function for function 5 and 7
	// This function calculates the sum of the specific sensor's quantity

	// Function 5: List total number of sensors of the farm
	// Function 7: Display Sensor Details, List sensor quantity of the specific farm
	public int getSensorQuantitySum(String typeName) {
		int counter = 0;

		// if typeName equals to ALL, get the total quantity of all sensor type
		// if typeName equals to the specific type (e.g. Soil), only the quantity of the type will be added.

		if (sensor1 != null) {
			if (typeName.equals("ALL") || sensor1.getType().equals(typeName)) {
				counter += sensor1.getQuantity();
			}
		} 
		if (sensor2 != null) {
			if (typeName.equals("ALL") || sensor2.getType().equals(typeName)) {
				counter += sensor2.getQuantity();
			}
		} 
		if (sensor3 != null) {
			if (typeName.equals("ALL") || sensor3.getType().equals(typeName)) {
				counter += sensor3.getQuantity();
			}
		}

		return counter;
	}

	// Function 6: List farm sensor type, price, weight, quantity
	public String listSensorDetails() {
		String message = "";

		// check if there any sensors
		if (countFarmSensorType() > 0) {
			message += getName() + " has the following sensor(s). \n";
		} else {
			message = "No sensors at farm.";
			return message;
		}

		// get sensor details from sensor
		if (sensor1 != null) {
			message += sensor1.getSensorDetailsString();
		}
		if (sensor2 != null) {
			message += sensor2.getSensorDetailsString();
		}
		if (sensor3 != null) {
			message += sensor3.getSensorDetailsString();
		}

		// output message
		return message;

	}

	// Function 8: Display total number of sensors in a farm and total cost
	// farm1Smith has 30 sensors of value $4000
	public String getFarmSensorCostSummary() {
		int totalQuantity = 0;
		double totalCost = 0.0;
		String message = "";

		if (sensor1 != null) {
			totalQuantity += sensor1.getQuantity();
			totalCost += sensor1.getSensorCost();
		}
		if (sensor2 != null) {
			totalQuantity += sensor2.getQuantity();
			totalCost += sensor2.getSensorCost();
		}
		if (sensor3 != null) {
			totalQuantity += sensor3.getQuantity();
			totalCost += sensor3.getSensorCost();
		}

		// display summary
		message = String.format("%s has %d sensors of value $%.1f \n",
				getName(), totalQuantity, totalCost);

		return message;
	}

}
