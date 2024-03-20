/*	Chi Lam Tsang */

import java.util.*;

public class Sensor {
	Scanner console = new Scanner(System.in);

	private String type = "";	// e.g.  Temperature, Pressure, Humidity, Soil Temperature, Soil, Soil PH
	private double price = 0;
	private double weight = 0;
	private int quantity = 0;

	// Get Type
	public String getType() {
		return type;
	}

	// Set Type
	public void setType(String sensorType) {
		type = sensorType;
	}

	// Get Price
	public double getPrice() {
		return price;
	}

	// Set Price
	public void setPrice(double sensorPrice) {
		price = sensorPrice;
	}

	// Get Weight
	public double getWeight() {
		return weight;
	}

	// Set Weight
	public void setWeight(double sensorWeight) {
		weight = sensorWeight;
	}

	// Get Quantity
	public int getQuantity() {
		return quantity;
	}

	// Set Quantity
	public void setQuantity(int sensorQuantity) {
		quantity = sensorQuantity;
	}

	public Sensor insertSensor(String typeName, Double price, Double weight, int quantity) {
		setType(typeName);
		setPrice(price);
		setWeight(weight);
		setQuantity(quantity);

		return this;
	}

	public Sensor removeSensor() {
		return null;
	}

	public Sensor adjustSensorQuantity(int updateQuantity) {
		// set new quantitiy
		int oriQuantity = getQuantity();
		int newQuantity = oriQuantity + updateQuantity;

		// update quantity
		setQuantity(newQuantity);

		return this;
	}

	public String getSensorDetailsString() {
		String message = "";

		message += String.format("%s sensor has price $%.1f, weight %.1f kg, and quantity %d. \n",
				getType(), getPrice(), getWeight(), getQuantity());

		return message;
	}

	public double getSensorCost() {
		return getQuantity() * getPrice();
	}

	
	
}
