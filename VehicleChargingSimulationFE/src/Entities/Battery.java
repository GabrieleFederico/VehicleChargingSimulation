package Entities;

import java.util.Map;

public class Battery extends Component {

	private int _sOC = 20;
	private int _capacity = 70;
	private int _chargePower = 200;
	
	public Battery() {
		super("Battery");
	}
	
	public Battery(Object owner) {
		super("Battery", owner);
	}
	
	public Battery(int SOC, int capacity, int chargePower) {
		super("Battery");
		_sOC = SOC;
		_capacity = capacity;
		_chargePower = chargePower;
	}

	public int GetSOC() {
		return _sOC;
	}

	public void SetSOC(int _sOC) {
		this._sOC = _sOC;
	}

	public int GetCapacity() {
		return _capacity;
	}

	public void SetCapacity(int _capacity) {
		this._capacity = _capacity;
	}

	public int GetChargePower() {
		return _chargePower;
	}

	public void SetChargePower(int _chargePower) {
		this._chargePower = _chargePower;
	}
	
	
	@Override
	public String toString() {
		
		return "C-component_name:"+_name+","+"capacity:"+
		_capacity+",charge_power:"+_chargePower+",state_of_charge:"+_sOC+"";
	}

}
