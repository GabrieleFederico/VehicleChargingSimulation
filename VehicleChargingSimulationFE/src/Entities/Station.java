package Entities;

import java.util.ArrayList;
import java.util.HashMap;

import org.codehaus.jackson.annotate.JsonProperty;

public class Station {
	
	@JsonProperty("station_name")
	private String _name;
	@JsonProperty("components")
	private HashMap<String, Component> _components;
	@JsonProperty("strategy")
	private int _strategy;
	@JsonProperty("vehicles")
	private ArrayList<Vehicle> _vehicles = new ArrayList<>();
	@JsonProperty("max_charge_power")
	private int _maxChargePower = 300;
	@JsonProperty("charging_slots")
	private int _maximumChargingVehicles = 3;
	
	public String GetName() {
		return _name;
	}
	
	public void SetName(String name) {
		_name = name;
	}

	public ArrayList<Vehicle> GetVehicles(){
		return _vehicles;
	}

	public void SetVehicles(ArrayList<Vehicle> vehicles) {
		_vehicles = vehicles;
	}
	
	public void AddVehicle(Vehicle vehicle) {
		_vehicles.add(vehicle);
	}
}
