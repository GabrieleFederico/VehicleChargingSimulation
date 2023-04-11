package Entities;

import org.codehaus.jackson.annotate.JsonProperty;

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

	public void SetSOC(int _sOC) {
		this._sOC = _sOC;
	}

	public float GetCapacity() {
		return _capacity;
	}

	public void SetCapacity(float _capacity) {
		this._capacity = _capacity;
	}

	public float GetChargePower() {
		return _chargePower;
	}

	public void SetChargePower(float _chargePower) {
		this._chargePower = _chargePower;
	}
	
	
	@Override
	public String toString() {
		
		return "C-component_name:"+_name+","+"capacity:"+
		_capacity+",charge_power:"+_chargePower+",state_of_charge:"+_sOC+"";
	}

}
