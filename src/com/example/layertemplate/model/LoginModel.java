package com.example.layertemplate.model;

public class LoginModel extends AbstractModel<LoginModel.Observee> {

	private static LoginModel instance;
	
	private LoginModel() {
	}
	
	public static LoginModel getInstance() {
		if (null == LoginModel.instance) {
			LoginModel.instance = new LoginModel();
		}
		return LoginModel.instance;
	}	
	
	public void login(Form form) {
		for (Observee observee: super.observees) {
			observee.logginSuccessed();
		}
	}
	
	public static class Form {
		public String id;
		public String password;
		
		public Form(String id, String password) {
			this.id = id;
			this.password = password;
		}
	}
	
	public interface Observee {
		public void logginSuccessed();
		public void logginFailed();		
	}
}
