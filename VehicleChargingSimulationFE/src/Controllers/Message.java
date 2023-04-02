package Controllers;

import Entities.Scenario;

public class Message {
	
	public enum Operation{
		RUN,
		EXPORT,
		IMPORT
	}
	
	private final int _version = 1;
	private Operation _operation;
	private Scenario _scenario;
	
	Message(){}
	
	public Message(Operation operation, Scenario scenario){
		_operation = operation;
		_scenario = scenario;
	}
	
	@Override
	public String toString() {
		return "version=" + _version + " " + "operation=" + _operation.name() +
				"body="+_scenario.toString();
	}
}
