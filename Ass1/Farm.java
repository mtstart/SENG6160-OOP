/*	Chi Lam Tsang */

public class Farm {
	/*
	 * this program keep tracks of up to 2 farms
	 * each farm have up to 3 sensors
	 */

	private String name;
	private Sensor sensor1, sensor2, sensor3;

	// getName function gets the name of the given Farm
	public String getFarmName() {
		return name;
	}

	// For Feature 1: Add Farm
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
	public boolean checkSensorExists(String sensorType) {

		// clean input
		sensorType = sensorType.toLowerCase().trim();

		// check 3 sensors one by one to see if the sensors exists
		if (sensor1 != null) {
			if (sensor1.getType().equals(sensorType)) {
				return true;
			}
		} 
		if (sensor2 != null) {
			if (sensor2.getType().equals(sensorType)) {
				return true;
			}
		}
		if (sensor3 != null) {
			if (sensor2.getType().equals(sensorType)) {
				return true;
			}
		}

		return false;
	}

	// get the specific sensor type
	private Sensor getFarmSensor(String sensorType) {
		Sensor getSensor = null;

		// clean input
		sensorType = sensorType.toLowerCase().trim();

		// check 3 sensors one by one to see if the sensors exists
		if (sensor1 != null) {
			if (sensor1.getType().equals(sensorType)) {
				getSensor = sensor1;
			}
		} 
		if (sensor2 != null) {
			if (sensor2.getType().equals(sensorType)) {
				getSensor = sensor2;
			}
		}
		if (sensor3 != null) {
			if (sensor2.getType().equals(sensorType)) {
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

	// For Function 3: Add new farm sensor
	public void addNewSensor(Farm farm, String sensorType, double price, double weight, int quantity) {

		if (sensor1 == null) {
			sensor1 = new Sensor();
			sensor1.insertSensor(sensorType, price, weight, quantity);
		} else if (sensor2 == null) {
			sensor2 = new Sensor();
			sensor2.insertSensor(sensorType, price, weight, quantity);
		} else if (sensor3 == null) {
			sensor3 = new Sensor();
			sensor3.insertSensor(sensorType, price, weight, quantity);
		}

	}

	// This function outputs an message saying there are existing sensor with corresponding price and weight
	// This message is output for function 3, adding existing sensors.
	public String getExistingSensorInfo(String sensorType) {
		String message = "";
		Sensor getSensor = getFarmSensor(sensorType);

		message = String.format("%s sensor exists, with price $%.1f and weight %.1f \n",
			getSensor.getType(), getSensor.getPrice(), getSensor.getWeight());

		return message;
	}
	
	// For Function 3: Add existing farm sensor
	public void addExistingSensor(Farm farm, String sensorType, int addQuantity) {

		// get the existing sensor
		Sensor getSensor = getFarmSensor(sensorType);
		int updateQuantity = getSensor.getQuantity() + addQuantity;

		// locate the corresponding sensor
		if (sensor1 != null) {
			if (sensor1.getType().equals(sensorType)) {
				sensor1.adjustSensorQuantity(updateQuantity);
			}
		} else if (sensor2 != null) {
			if (sensor2.getType().equals(sensorType)) {
				sensor2.adjustSensorQuantity(updateQuantity);
			}
		} else if (sensor3 != null) {
			if (sensor2.getType().equals(sensorType)) {
				sensor3.adjustSensorQuantity(updateQuantity);
			}
		}
		
	}

	// For Function 3: Add existing farm sensor
	public void updateSensorQuantity(String sensorType, int updateQuantity) {

		// locate the corresponding sensor
		if (sensor1 != null) {
			if (sensor1.getType().equals(sensorType)) {
				sensor1.adjustSensorQuantity(updateQuantity);
			}
		} else if (sensor2 != null) {
			if (sensor2.getType().equals(sensorType)) {
				sensor2.adjustSensorQuantity(updateQuantity);
			}
		} else if (sensor3 != null) {
			if (sensor2.getType().equals(sensorType)) {
				sensor3.adjustSensorQuantity(updateQuantity);
			}
		}

	}

	// Function 3: Add existing farm sensor
	// Function 4: Remove Farm Sensor
	public String checkSensorQuantity(String sensorType, int updateQuantity) {
		String message = "";
		// for adding sensor quantity, 
		// output an message that sensors are added

		// for removing sensor quantity, 
		// output an message that sensors are removed
		// and if the quanatity becomes zero, remove the sensor type

		// for adding sensor quantity
		if (updateQuantity > 0) {
			message = String.format("%d %s sensor(s) is added in %s.",
					updateQuantity, sensorType, name);
		} else {
			message = String.format("%d %s sensor(s) is removed in %s. \n",
				Math.abs(updateQuantity), sensorType, name);

			// for reducing sensor quantity
			if (getSensorQuantitySum(sensorType) == 0) {
				removeSensor(sensorType);

				message += "As the sensor quantity is zero, " + sensorType + " sensor is removed.";
			}

		}
		return message;
	}

	// For Function 4: Remove farm sensor if quantity is 0
	private void removeSensor(String sensorType) {
		
		if (sensor1 != null) {
			if (sensor1.getType().equals(sensorType)) {
				sensor1 = null;
			}
		} 
		if (sensor2 != null) {
			if (sensor2.getType().equals(sensorType)) {
				sensor2 = null;
			}
		}
		if (sensor3 != null) {
			if (sensor2.getType().equals(sensorType)) {
				sensor3 = null;
			}
		}

	}

	// This is a reusable function for function 5 and 7
	// This function calculates the sum of the specific sensor's quantity
	// For Function 5: List total number of sensors of the farm
	// For Function 7: Display Sensor Details, List sensor quantity of the specific farm
	public int getSensorQuantitySum(String sensorType) {
		int counter = 0;

		// if typeName equals to ALL, get the total quantity of all sensor type
		// if typeName equals to the specific type (e.g. Soil), only the quantity of the type will be added.

		if (sensor1 != null) {
			if (sensorType.equals("ALL") || sensor1.getType().equals(sensorType)) {
				counter += sensor1.getQuantity();
			}
		} 
		if (sensor2 != null) {
			if (sensorType.equals("ALL") || sensor2.getType().equals(sensorType)) {
				counter += sensor2.getQuantity();
			}
		} 
		if (sensor3 != null) {
			if (sensorType.equals("ALL") || sensor3.getType().equals(sensorType)) {
				counter += sensor3.getQuantity();
			}
		}

		return counter;
	}

	// For Function 6: List farm sensor type, price, weight, quantity
	public String listSensorDetails() {
		String message = "";

		// check if there any sensors
		if (countFarmSensorType() > 0) {
			message += getFarmName() + " has the following sensor(s). \n";
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

	// For Function 8: Display total number of sensors in a farm and total cost
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
				getFarmName(), totalQuantity, totalCost);

		return message;
	}

}
