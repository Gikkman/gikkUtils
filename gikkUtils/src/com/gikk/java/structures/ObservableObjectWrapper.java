package com.gikk.java.structures;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ObservableObjectWrapper {

	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	protected Object object;
	
	public ObservableObjectWrapper(Object object) {
		this.object = object;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener( listener );
    }

    public void removePropertyChangeListener( PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener( listener );
    }
	
	public void setValue(Object newValue){
		Object oldValue = object;		
		object = newValue;
		this.pcs.firePropertyChange("value", oldValue, newValue);
	}
	
	public Object getValue(){
		return object;
	}
}
