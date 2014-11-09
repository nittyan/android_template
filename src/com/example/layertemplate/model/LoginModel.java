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
		this.notifyObservee(Event.SUCCESS);
	}
	
	private void notifyObservee(Event event) {
		for (Observee observee: super.observees) {
			observee.login(event);
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
	
	public static enum Event {
		SUCCESS, FAIL
	}
	
	public interface Observee {
		public void login(Event event);		
	}
}
