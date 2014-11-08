package com.example.layertemplate.model;

import java.util.LinkedList;

import com.example.layertemplate.core.Model;

public abstract class AbstractModel<T> implements Model<T> {
	
	protected LinkedList<T> observees;
	
	public AbstractModel() {
		this.observees = new LinkedList<>();
	}
	
	@Override
	public void regist(T observee) {
		if (!this.observees.contains(observee)) {
			this.observees.add(observee);
		}
	}
	
	@Override
	public void unregist(T observee) {
		if (!this.observees.contains(observee)) {
			this.observees.remove(observee);
		}
	}

}
