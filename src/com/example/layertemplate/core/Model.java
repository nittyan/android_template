package com.example.layertemplate.core;


public interface Model<T> {
	public void regist(T observee);
	public void unregist(T observee);
}
