package com.example.layertemplate.core;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class TemplateApplication extends Application {
	
	private static TemplateApplication instannce;
	private RequestQueue queue;
	
	@Override
	public void onCreate() {
		super.onCreate();
		TemplateApplication.instannce = this;
	}
	
	public static synchronized TemplateApplication getInstance() {
		return TemplateApplication.instannce;
	}
	
	public RequestQueue getRequestQueue() {
		if (null == this.queue) {
			this.queue = Volley.newRequestQueue(TemplateApplication.getInstance());
		}
		return this.queue;
	}

}
