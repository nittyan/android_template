package com.example.layertemplate.fragment;

import com.example.layertemplate.R;
import com.example.layertemplate.model.LoginModel;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment implements LoginModel.Observee {
	
	private static final String KEY_ID = "id";
	private static final String KEY_PASSWORD = "password";
	
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		this.registModel();
	}
	
	private void registModel() {
		LoginModel.getInstance().regist(this);		
	}
	
	private EditText getIdText() {
		return (EditText)super.getActivity().findViewById(R.id.id_text);
	}
	
	private EditText getPasswordText() {
		return (EditText)super.getActivity().findViewById(R.id.password_text);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle bundle) {
		super.onCreateView(inflater, group, bundle);
		return inflater.inflate(R.layout.login_form, group, false);
	}
	
	@Override
	public void onActivityCreated(Bundle bundle) {
		super.onActivityCreated(bundle);
		
		if (null != bundle) {
			EditText id = (EditText)super.getActivity().findViewById(R.id.id_text);
			EditText password = (EditText)super.getActivity().findViewById(R.id.password_text);
			id.setText(bundle.getString(KEY_ID));
			password.setText(bundle.getString(KEY_PASSWORD));
		} else {
			Button loginButton = (Button)super.getActivity().findViewById(R.id.login_button);
			loginButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String id = LoginFragment.this.getIdText().getText().toString();
					String password = LoginFragment.this.getPasswordText().getText().toString();
					LoginModel.Form form = new LoginModel.Form(id, password);
					LoginModel.getInstance().login(form);
				}
			});			
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		this.unregistModel();
	}
	
	@Override
	public void onSaveInstanceState(Bundle bundle) {
		EditText id = (EditText)super.getActivity().findViewById(R.id.id_text);
		EditText password = (EditText)super.getActivity().findViewById(R.id.password_text);
		bundle.putString(KEY_ID, id.getText().toString());
		bundle.putString(KEY_PASSWORD, password.getText().toString());
	}
	
	public void unregistModel() {
		LoginModel.getInstance().unregist(this);
	}

	@Override
	public void logginSuccessed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logginFailed() {
		// TODO Auto-generated method stub
		
	}
}
