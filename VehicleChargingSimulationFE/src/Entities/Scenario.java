package Entities;

import java.util.HashMap;

public class Scenario {

	private HashMap<String, Station> _stations;
	
	public void RunSimulation() {
		//TODO: call the python script to run the simulation and send it the whole scenario
	}
	
	public void AddStation(Station newStation) {
		_stations.put(newStation.GetName(), newStation);
	}
}
