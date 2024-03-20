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
		return this.type;
	}

	// Set Type
	public void setType(String sensorType) {
		this.type = sensorType;
	}

	// Get Price
	public double getPrice() {
		return this.price;
	}

	// Set Price
	public void setPrice(double sensorPrice) {
		this.price = sensorPrice;
	}

	// Get Weight
	public double getWeight() {
		return this.weight;
	}

	// Set Weight
	public void setWeight(double sensorWeight) {
		this.weight = sensorWeight;
	}

	// Get Quantity
	public int getQuantity() {
		return this.quantity;
	}

	// Set Quantity
	public void setQuantity(int sensorQuantity) {
		this.quantity = sensorQuantity;
	}

	public Sensor insertSensor(String typeName, Double price, Double weight, int quantity) {
		this.setType(typeName);
		this.setPrice(price);
		this.setWeight(weight);
		this.setQuantity(quantity);

		return this;
	}

	public Sensor removeSensor() {
		return null;
	}

	public Sensor adjustSensorQuantity(int updateQuantity) {
		// set new quantitiy
		int oriQuantity = this.getQuantity();
		int newQuantity = oriQuantity + updateQuantity;

		// update quantity
		this.setQuantity(newQuantity);

		return this;
	}

	public String getSensorDetailsString() {
		String message = "";

		message += String.format("%s sensor has price $%.1f, weight %.1f kg, and quantity %d. \n",
				this.getType(), this.getPrice(), this.getWeight(), this.getQuantity());

		return message;
	}

	public double getSensorCost() {
		return this.getQuantity() * this.getPrice();
	}

	
	
}
