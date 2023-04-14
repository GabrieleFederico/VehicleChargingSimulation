package Entities;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;


public class Vehicle {

	@JsonProperty("vehicle_name")
	private String _name;
	@JsonProperty("arrival")
	private int _arrival;
	@JsonProperty("departure")
	private int _departure;
	@JsonProperty("desired_charge")
	private float _desiredCharge = 80;
	@JsonProperty("vehicle_components")
	private HashMap<String, Component> _components = new HashMap<>();
	
	
	public Vehicle() {
		
	}
	
	public Vehicle(String name, int arrival, int departure, float desiredCharge) {
		_name = name;
		_arrival = arrival;
		_departure = departure;
		_desiredCharge = desiredCharge;
	}

	public String GetName() {
		return _name;
	}

	public void SetName(String name) {
		_name = name;
	}

	public Map<String, Component> GetComponents() {
		return _components;
	}

	public void SetComponents(HashMap<String, Component> components) {
		_components = components;
	}

	public void AddComponent(String key, Component value) {
		_components.put(key, value);
		value.SetOwner(this);
	}
	
	public int GetArrival() {
		return _arrival;
	}

	public void SetArrival(int arrival) {
		_arrival = arrival;
	}

	public int GetDeparture() {
		return _departure;
	}

	public void SetDeparture(int departure) {
		_departure = departure;
	}


	public float GetDesiredCharge() {
		return _desiredCharge;
	}

	public void SetDesiredCharge(float desiredCharge) {
		_desiredCharge = desiredCharge;
	}
	
	public static Vehicle DeserializeVehicle(JsonNode vehicleNode) {
		Vehicle vehicle = new Vehicle();
		vehicle.SetName(vehicleNode.get("vehicle_name").textValue());
		vehicle.SetArrival(vehicleNode.get("arrival").asInt());
		vehicle.SetDeparture(vehicleNode.get("departure").asInt());
		vehicle.SetDesiredCharge(vehicleNode.get("desired_charge").asInt());
		JsonNode vehicleComponentsNode = vehicleNode.get("vehicle_components");
		JsonNodeType vehicleComponentsNodeType = vehicleComponentsNode.getNodeType();
		if(vehicleComponentsNodeType == JsonNodeType.ARRAY) {
			for(JsonNode vehicleComponentNode : vehicleComponentsNode) {
				Component component = Component.DeserializeComponent(vehicleComponentNode);
				vehicle.AddComponent(component.GetName(), component);
			}
		}
		return vehicle;
	}
	
	@Override
	public String toString() {
		String string = "V-vehicle_name:"+_name+","+"arrival:"+
				_arrival+",departure:"+_departure+",desired_charge:"+_desiredCharge+",vehicle_components:";
		for(Map.Entry<String, Component> component: _components.entrySet()) {
			string += component.getValue().toString();
			string += ",";
		}
		StringBuffer sb = new StringBuffer(string);
		sb.deleteCharAt(sb.length()-1);
		string = sb.toString();
		return string;
	}
	
}
