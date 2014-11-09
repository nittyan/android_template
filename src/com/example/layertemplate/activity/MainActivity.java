package com.example.layertemplate.activity;

import com.example.layertemplate.R;
import com.example.layertemplate.model.LoginModel;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements LoginModel.Observee {
	
	private LoginModel loginModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.loginModel = LoginModel.getInstance();
		this.loginModel.regist(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		this.loginModel.unregist(this);
	}
	
	@Override
	public void login(LoginModel.Event event) {
		if (LoginModel.Event.SUCCESS == event) {
			
		}
	}

}
