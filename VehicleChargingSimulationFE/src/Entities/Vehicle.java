package Entities;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;


public class Vehicle {

	@JsonProperty("vehicle_name")
	private String _name;
	@JsonProperty("components")
	private HashMap<String, Component> _components = new HashMap<>();
	@JsonProperty("arrival")
	private int _arrival;
	@JsonProperty("departure")
	private int _departure;
	@JsonProperty("desired_charge")
	private int _desiredCharge = 80;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String name, int arrival, int departure, int desiredCharge) {
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

	public HashMap<String, Component> GetComponents() {
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


	public int GetDesiredCharge() {
		return _desiredCharge;
	}

	public void SetDesiredCharge(int desiredCharge) {
		_desiredCharge = desiredCharge;
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
