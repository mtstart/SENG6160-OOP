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
		return this.name;
	}

	// Feature 1: Add Farm
	public String addFarm(String farmname, String lastName) {
		String farmName = "";

		// set the farm name
		farmName = this.setFarmName(farmname, lastName);

		return farmName;
	}

	private String setFarmName(String farmname, String lastName) {

		this.name = farmname + lastName;

		return this.name;
	}

	// check if sensor type exists in any farm
	public Sensor getFarmSensor(String typeName) {
		Sensor getSensor = null;

		// clean input
		typeName = typeName.toLowerCase().trim();

		// check 3 sensors one by one to see if the sensors exists
		if (this.sensor1 != null) {
			if (this.sensor1.getType().equals(typeName)) {
				getSensor = this.sensor1;
			}
		} 
		if (this.sensor2 != null) {
			if (this.sensor2.getType().equals(typeName)) {
				getSensor = this.sensor2;
			}
		}
		if (this.sensor3 != null) {
			if (this.sensor2.getType().equals(typeName)) {
				getSensor = this.sensor3;
			}
		}

		return getSensor;
	}

	public int countFarmSensorType() {
		int counter = 0;

		if (this.sensor1 != null) {
			counter += 1;
		}
		if (this.sensor2 != null) {
			counter += 1;
		}
		if (this.sensor3 != null) {
			counter += 1;
		}

		return counter;
	}

	// Function 3: Add new farm sensor
	public Farm addSensor(Farm farm, String typeName, Double price, Double weight, int quantity) {

		if (this.sensor1 == null) {
			this.sensor1 = new Sensor();
			this.sensor1.insertSensor(typeName, price, weight, quantity);
		} else if (this.sensor2 == null) {
			this.sensor2 = new Sensor();
			this.sensor2.insertSensor(typeName, price, weight, quantity);
		} else if (this.sensor3 == null) {
			this.sensor3 = new Sensor();
			this.sensor3.insertSensor(typeName, price, weight, quantity);
		}
		
		return this;
	}

	// Function 3: Add existing farm sensor
	public Farm updateSensorQuantity(Sensor sensor, int updateQuantity) {

		// locate the corresponding sensor
		if (this.sensor1 != null) {
			if (this.sensor1.getType().equals(sensor.getType())) {
				this.sensor1 = this.sensor1.adjustSensorQuantity(updateQuantity);
			}
		} else if (this.sensor2 != null) {
			if (this.sensor2.getType().equals(sensor.getType())) {
				this.sensor2 = this.sensor2.adjustSensorQuantity(updateQuantity);
			}
		} else if (this.sensor3 != null) {
			if (this.sensor2.getType().equals(sensor.getType())) {
				this.sensor3 = this.sensor3.adjustSensorQuantity(updateQuantity);
			}
		}


		return this;
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
					updateQuantity, typeName, this.name);
		} else {
			message = String.format("%d %s sensor(s) is removed in %s. \n",
				Math.abs(updateQuantity), typeName, this.name);

			// for reducing sensor quantity
			if (this.getSensorQuantitySum(typeName) == 0) {
				this.removeSensor(typeName);

				message += "As the sensor quantity is zero, " + typeName + " sensor is removed.";
			}

		}
		return message;
	}

	// Function 4: Remove farm sensor if quantity is 0
	private void removeSensor(String typeName) {
		
		if (this.sensor1 != null) {
			if (this.sensor1.getType().equals(typeName)) {
				this.sensor1 = this.sensor1.removeSensor();
			}
		} 
		if (this.sensor2 != null) {
			if (this.sensor2.getType().equals(typeName)) {
				this.sensor2 = this.sensor2.removeSensor();
			}
		}
		if (this.sensor3 != null) {
			if (this.sensor2.getType().equals(typeName)) {
				this.sensor3 = this.sensor3.removeSensor();
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

		if (this.sensor1 != null) {
			if (typeName.equals("ALL") || this.sensor1.getType().equals(typeName)) {
				counter += this.sensor1.getQuantity();
			}
		} 
		if (this.sensor2 != null) {
			if (typeName.equals("ALL") || this.sensor2.getType().equals(typeName)) {
				counter += this.sensor2.getQuantity();
			}
		} 
		if (this.sensor3 != null) {
			if (typeName.equals("ALL") || this.sensor3.getType().equals(typeName)) {
				counter += this.sensor3.getQuantity();
			}
		}

		return counter;
	}

	// Function 6: List farm sensor type, price, weight, quantity
	public String listSensorDetails() {
		String message = "";

		// check if there any sensors
		if (this.countFarmSensorType() > 0) {
			message += this.getName() + " has the following sensor(s). \n";
		} else {
			message = "No sensors at farm.";
			return message;
		}

		// get sensor details from sensor
		if (this.sensor1 != null) {
			message += this.sensor1.getSensorDetailsString();
		}
		if (this.sensor2 != null) {
			message += this.sensor2.getSensorDetailsString();
		}
		if (this.sensor3 != null) {
			message += this.sensor3.getSensorDetailsString();
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

		if (this.sensor1 != null) {
			totalQuantity += this.sensor1.getQuantity();
			totalCost += this.sensor1.getSensorCost();
		}
		if (this.sensor2 != null) {
			totalQuantity += this.sensor2.getQuantity();
			totalCost += this.sensor2.getSensorCost();
		}
		if (this.sensor3 != null) {
			totalQuantity += this.sensor3.getQuantity();
			totalCost += this.sensor3.getSensorCost();
		}

		// display summary
		message = String.format("%s has %d sensors of value $%.1f \n",
				this.getName(), totalQuantity, totalCost);

		return message;
	}

}
