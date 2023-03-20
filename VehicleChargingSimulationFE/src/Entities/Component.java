package Entities;

public abstract class Component {
	
	protected String _name;
	protected Object _owner;
	
	Component(String name, Object owner){
		_name = name;
		_owner = owner;
	}
}
