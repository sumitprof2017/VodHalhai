package com.sumit.vodhalhai;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sumit.vodhalhai.Helper.Constants;
import com.sumit.vodhalhai.Helper.Jsonparser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by MR.Cutevil on 11/4/2017.
 */

public class LoginActivity extends AppCompatActivity{
    AutoCompleteTextView musername;
    EditText mpassword;
    Button mloginbutton,mregisterbutton;
    ProgressDialog mprogressdialog;
    int flag=0;
    Jsonparser jsonp=new Jsonparser();
    String email,password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        musername=(AutoCompleteTextView)findViewById(R.id.activity_login_username);
        mpassword=(EditText)findViewById(R.id.activity_login_password);
        mloginbutton=(Button) findViewById(R.id.activity_login_button);
        mregisterbutton=(Button) findViewById(R.id.activity_register_button);
        mloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=musername.getText().toString();
                password=mpassword.getText().toString();
                new LoginOnline().execute();
            }
        });

        mregisterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(in);
            }
        });



    }
    public class LoginOnline extends AsyncTask<String,String,String>{



        @Override
        protected void onPreExecute() {
            mprogressdialog = new ProgressDialog(LoginActivity.this);
            mprogressdialog.setMessage("Please wait");
            mprogressdialog.setCancelable(false);
            mprogressdialog.show();
        }



        @Override
        protected String doInBackground(String... params) {
            HashMap<String,String> hm= new HashMap<>();
            hm.put("email",email);
            hm.put("password",password);
            String url= Constants.BASE_URL+"api/login";
            JSONObject jsonObject = jsonp.performPostCI(url, hm);
            mprogressdialog.dismiss();
            if(jsonObject==null){
                flag=1;
            }
            else {
                try {
                    if (jsonObject.getString("status").equals("success")) {
                        flag = 2;

                    } else {
                        flag = 3;
                    }
                } catch (JSONException e) {
                    Toast.makeText(LoginActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    //localized message le chai json ko kura lai dekhauxa
                }




        }return null;}
        @Override
        protected void onPostExecute(String s) {
            if(flag==1){
                Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
            else if(flag==2){
                Toast.makeText(LoginActivity.this, "Succes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,MenuListActivity.class));
            }
            else if(flag==3){
                Toast.makeText(LoginActivity.this, "Wrong data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
