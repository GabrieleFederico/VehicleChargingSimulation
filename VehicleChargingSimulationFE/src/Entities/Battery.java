package Entities;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.databind.JsonNode;

public class Battery extends Component {

	@JsonProperty("capacity")
	private float _capacity = 70;
	@JsonProperty("charge_power")
	private float _chargePower = 200;
	@JsonProperty("state_of_charge")
	private float _sOC = 20;
	
	public Battery() {
		super("Battery");
	}
	
	public Battery(Object owner) {
		super("Battery", owner);
	}
	
	public Battery(float SOC, float capacity, float chargePower) {
		super("Battery");
		_sOC = SOC;
		_capacity = capacity;
		_chargePower = chargePower;
	}

	public float GetSOC() {
		return _sOC;
	}

	public void SetSOC(int sOC) {
		this._sOC = sOC;
	}

	public float GetCapacity() {
		return _capacity;
	}

	public void SetCapacity(float capacity) {
		this._capacity = capacity;
	}

	public float GetChargePower() {
		return _chargePower;
	}

	public void SetChargePower(float chargePower) {
		this._chargePower = chargePower;
	}
	
	public static Component DeserializeComponent(JsonNode batteryNode) {
		Battery battery = new Battery();
		battery.SetCapacity(batteryNode.get("capacity").floatValue());
		battery.SetChargePower(batteryNode.get("charge_power").floatValue());
		battery.SetSOC(batteryNode.get("state_of_charge").asInt());
		return battery;
	}
	
	@Override
	public String toString() {
		
		return "C-component_name:"+_name+","+"capacity:"+
		_capacity+",charge_power:"+_chargePower+",state_of_charge:"+_sOC+"";
	}

}
