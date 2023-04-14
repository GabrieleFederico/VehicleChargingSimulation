package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

public class Station {
	
	@JsonProperty("station_name")
	private String _name;
	@JsonProperty("vehicles")
	private ArrayList<Vehicle> _vehicles = new ArrayList<>();
	@JsonProperty("station_components")
	private HashMap<String, Component> _components = new HashMap<>();
	@JsonProperty("strategy")
	private String _strategy;
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
	
	public void SetComponents(HashMap<String, Component> components) {
		_components = components;
	}
	
	public Map<String, Component> GetComponents() {
		return _components;
	}

	public void AddComponent(String key, Component value) {
		_components.put(key, value);
		value.SetOwner(this);
	}
	
	public void SetStrategy(String strategy) {
		_strategy = strategy;
	}
	
	public String GetStrategy() {
		return _strategy;
	}
	
	public int GetMaximumChargingVehicles() {
		return _maximumChargingVehicles;
	}
	
	public void SetMaximumChargingVehicles(int maximumChargingVehicles) {
		_maximumChargingVehicles = maximumChargingVehicles;
	}
	
	public static Station DeserializeStation(JsonNode stationNode) {
		Station station = new Station();
		station.SetName(stationNode.get("station_name").textValue());
		station.SetStrategy(stationNode.get("strategy").textValue());
		station.SetMaximumChargingVehicles(stationNode.get("max_vehicles").asInt());
		JsonNode vehiclesNode = stationNode.get("vehicles");
		JsonNodeType vehiclesNodeType = vehiclesNode.getNodeType();
		if(vehiclesNodeType == JsonNodeType.ARRAY) {
			for(JsonNode vehicleNode : vehiclesNode) {
				Vehicle vehicle = Vehicle.DeserializeVehicle(vehicleNode);
				station.AddVehicle(vehicle);
			}
		}
		JsonNode stationsComponentsNode = stationNode.get("station_components");
		JsonNodeType stationComponentsNodeType = stationsComponentsNode.getNodeType();
		if(stationComponentsNodeType == JsonNodeType.ARRAY) {
			for(JsonNode stationsComponentNode : stationsComponentsNode) {
				Component component = Component.DeserializeComponent(stationsComponentNode);
				station.AddComponent(component.GetName(), component);
			}
		}
		return station;
	}
	
	@Override
	public String toString() {
		String string = "St-station_name:"+ _name +","+ "vehicles:";
		for(Vehicle vehicle: _vehicles) {
			string += vehicle.toString();
			string += ",";
		}
		StringBuffer sb = new StringBuffer(string);
		sb.deleteCharAt(sb.length()-1);
		string = sb.toString();
		
		string += ",station_components:";
		for(Map.Entry<String, Component> component: _components.entrySet()) {
			string += component.getValue().toString();
			string += ",";
		}
		sb = new StringBuffer(string);
		sb.deleteCharAt(sb.length()-1);
		string = sb.toString() + ",";
		string += "strategy:"+ _strategy + ",";
		string += "maximum_charging_vehicles:" + _maximumChargingVehicles;
		return string;
	}
	

}
