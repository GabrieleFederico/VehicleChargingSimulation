package Entities;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class Scenario {
	
	@JsonProperty("scenario_name")
	private String _name;
	@JsonProperty("stations")
	private ArrayList<Station> _stations = new ArrayList<>();

	public void RunSimulation() {
		//TODO: call the python script to run the simulation and send it the whole scenario
	}
	
	public void AddStation(Station newStation) {
		_stations.add(newStation);
	}
	
	@JsonProperty("name")
	public void SetName(String newName) {
		_name = newName;
	}
	@JsonProperty("name")
	public String GetName() {
		return _name;
	}
	
	@Override
	public String toString() {
		String string = "Scen-scenario_name:" + _name +","+ "stations:[";
		for(Station station : _stations) {
			string += station.toString();
		}
		string += "]";
		return string;
	}
}
