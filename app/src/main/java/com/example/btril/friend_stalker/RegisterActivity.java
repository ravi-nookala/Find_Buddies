package com.example.btril.friend_stalker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by deeksha on 7/21/2017.
 */

public class RegisterActivity extends Activity {

    private EditText fullname, email, password;
    private Button register; // created a button object
    private Button signinto;
    private ProgressDialog progressDialog;

    public static final String LOG_TAG = RegisterActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        fullname = (EditText) findViewById(R.id.register_fullname);
        email = (EditText) findViewById(R.id.register_email);
        password = (EditText) findViewById(R.id.register_password);
        register = (Button) findViewById(R.id.register_button);
        signinto = (Button) findViewById(R.id.sign_into);

        signinto.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View view) {
                                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
        );

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = fullname.getText().toString();
                String emailid = email.getText().toString();
                String pswd = password.getText().toString();

                /*Checks if user has entered information in all three mandatory fields
                * else shows an error for each value that has not been assigned yet*/
                if (name.isEmpty()) {
                    fullname.setError("Mandatory Field");
                } else if (emailid.isEmpty()) {
                    email.setError("Mandatory Field");
                } else if (pswd.isEmpty()) {
                    password.setError("Mandatory Field");
                } else {
                    register_validate(name, emailid, pswd);
                }
            }
        });
    }

    private void register_validate(String name, String emailid, String pswd) {

        //TODO Validation for name emailid and password

    }

    public void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    public void hideDialog() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

}