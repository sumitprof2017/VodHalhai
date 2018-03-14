package com.sumit.vodhalhai;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MR.Cutevil on 10/5/2017.
 */

public class PlayersProfile extends AppCompatActivity {

   Button mokbutton;
 EditText mone,mtwo;
    String a,b;


  ObjActivity  obj;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pp);
        mone=(EditText)findViewById(R.id.activity_pp_firstplayer);
        mtwo=(EditText)findViewById(R.id.activity_pp_secondplayer);
        mokbutton=(Button)findViewById(R.id.ok);

        mokbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=mone.getText().toString();
                b=mtwo.getText().toString();
                obj=new ObjActivity(a,b);

                Intent in=new Intent(PlayersProfile.this,TicTacToe.class);
                in.putExtra("sampleObject", obj);
                startActivity(in);



            }
        });



    }
}
