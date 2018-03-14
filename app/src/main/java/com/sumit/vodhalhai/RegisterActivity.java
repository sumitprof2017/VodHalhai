package com.sumit.vodhalhai;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sumit.vodhalhai.Helper.Constants;
import com.sumit.vodhalhai.Helper.Jsonparser;
import com.sumit.vodhalhai.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by MR.Cutevil on 11/5/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    EditText memail,mpassword,maddress,mphone,mname;
    Button mregisterbutton;
    ProgressDialog mprogressdialog;
    Jsonparser jsonp=new Jsonparser();

    int flag=0;
    String email,password,address,phone,name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        memail=(EditText)findViewById(R.id.activity_register_email);
        mpassword=(EditText)findViewById(R.id.activity_register_password);
        maddress=(EditText)findViewById(R.id.activity_register_address);
        mphone=(EditText)findViewById(R.id.activity_register_phone);
        mname=(EditText)findViewById(R.id.activity_register_name);
        mregisterbutton=(Button) findViewById(R.id.activity_register_button);

        mregisterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=memail.getText().toString();
                password=mpassword.getText().toString();
                address=maddress.getText().toString();
                phone=mphone.getText().toString();
                name=mname.getText().toString();
            new RegisterOnline().execute();
            }
        });

    }
    public class RegisterOnline extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            mprogressdialog = new ProgressDialog(RegisterActivity.this);
            mprogressdialog.setMessage("Please wait");
            mprogressdialog.setCancelable(false);

        }



        @Override
        protected String doInBackground(String... params) {
            HashMap<String,String> hm=new HashMap<>();
            hm.put("email",email);
            hm.put("password",password);
            hm.put("address",address);
            hm.put("phone",phone);
            hm.put("name",name);
            String url= Constants.BASE_URL+"api/register";
            JSONObject jsonObject = jsonp.performPostCI(url,hm);
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
                    Toast.makeText(RegisterActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    //localized message le chai json ko kura lai dekhauxa
                }
            }
            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(flag==1){
              Toast.makeText(RegisterActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
          else if(flag==2){
                Toast.makeText(RegisterActivity.this, "Succes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,TasActivity .class));
           }
         else if(flag==3){
               Toast.makeText(RegisterActivity.this, "Wrong data", Toast.LENGTH_SHORT).show();
           }
        }
    }
}
