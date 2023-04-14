package Entities;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

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
	
	public void SetName(String newName) {
		_name = newName;
	}

	public List<Station> GetName() {
		return _stations;
	}
	
	public void SetStations(ArrayList<Station> newStations) {
		_stations = newStations;
	}

	public ArrayList<Station> GetStations() {
		return _stations;
	}
	
	public static Scenario DeserializeScenario(JsonNode scenarioNode) {
		Scenario scenario = new Scenario();
		scenario.SetName(scenarioNode.get("scenario_name").textValue());
		JsonNode stationsNode = scenarioNode.get("stations");
		JsonNodeType stationsNodeType = stationsNode.getNodeType();
		if(stationsNodeType == JsonNodeType.ARRAY) {
			for(JsonNode stationNode : stationsNode) {
				Station station = Station.DeserializeStation(stationNode);
				scenario.AddStation(station);
			}
		}
		return scenario;
	}
	
	
	@Override
	public String toString() {
		String string = "Scen-scenario_name:" + _name +","+ "stations:";
		for(Station station : _stations) {
			string += station.toString();
		}
		string += "";
		return string;
	}
}
