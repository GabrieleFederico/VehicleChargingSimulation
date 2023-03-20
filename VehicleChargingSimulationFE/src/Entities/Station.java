package Entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Station {
	
	private HashMap<String, Component> _components;
	private String _name;
	private int _strategy;
	private ArrayList<Vehicle> _vehicles = new ArrayList<>();
	private int _maxChargePower = 300;
	private int _availableChargePower = 300;
	private ArrayList<Vehicle> _chargingVehicles = new ArrayList<>();
	private int _maximumChargingVehicles = 3;
	private ArrayList<Integer> _chargingPowers = new ArrayList<>(_maximumChargingVehicles);
	private int _time = 0;
	
	public String GetName() {
		return _name;
	}
}
