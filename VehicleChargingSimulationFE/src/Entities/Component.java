package Entities;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class Component {
	
	@JsonProperty("component_name")
	protected String _name;
	protected Object _owner;
	
	Component(String name) {_name = name;}
	
	public Component(String name, Object owner){
		_name = name;
		_owner = owner;
	}

	void SetOwner(Object owner) {
		_owner = owner;
	}
	
	Object GetOwner() {
		return _owner;
	}
	
}
