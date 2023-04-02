package Controllers;

import Entities.Scenario;

public class Message {
	
	enum Operation{
		RUN,
		EXPORT,
		IMPORT
	}
	
	private final int _version = 1;
	private Operation _operation;
	private Scenario _scenario;
	
	Message(){}
	
	Message(Operation operation, Scenario scenario){
		_operation = operation;
		_scenario = scenario;
	}
	
	@Override
	public String toString() {
		return _version + _operation.name() + _scenario.toString();
	}
}
