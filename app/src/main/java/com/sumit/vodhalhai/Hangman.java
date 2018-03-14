package com.sumit.vodhalhai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by MR.Cutevil on 11/5/2017.
 */

public class Hangman extends AppCompatActivity {

    TextView mone,mtwo,mthree,mfour,maintextview;
    Button ma,mb,mc,md,me,mf,mg,mh,mi,mj,mk,ml,mm,mn,mo,mp,mq,mr,ms,mt,mu,mv,mw,mx,my,mz;
    String a,r,c,d,b;
    int flag=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        mone=(TextView)findViewById(R.id.one);
        mtwo=(TextView) findViewById(R.id.two);
        mthree=(TextView) findViewById(R.id.three);
        mfour=(TextView) findViewById(R.id.four);
        //For Buttons
        //for hg text view
        maintextview=(TextView)findViewById(R.id.maintextview);
        ma=(Button)findViewById(R.id.a);
        mb=(Button)findViewById(R.id.b);
        mc=(Button)findViewById(R.id.c);
        md=(Button)findViewById(R.id.d);
        me=(Button)findViewById(R.id.e);
        mf=(Button)findViewById(R.id.f);
        mg=(Button)findViewById(R.id.g);
        mh=(Button)findViewById(R.id.h);
        mi=(Button)findViewById(R.id.i);
        mj=(Button)findViewById(R.id.j);
        mk=(Button)findViewById(R.id.k);
        ml=(Button)findViewById(R.id.l);
        mm=(Button)findViewById(R.id.m);
        mn=(Button)findViewById(R.id.n);
        mo=(Button)findViewById(R.id.o);
        mp=(Button)findViewById(R.id.p);
        mq=(Button)findViewById(R.id.q);
        mr=(Button)findViewById(R.id.r);
        ms=(Button)findViewById(R.id.s);
        mt=(Button)findViewById(R.id.t);
        mu=(Button)findViewById(R.id.u);
        mv=(Button)findViewById(R.id.v);
        mw=(Button)findViewById(R.id.w);
        mx=(Button)findViewById(R.id.x);
        my=(Button)findViewById(R.id.y);
        mz=(Button)findViewById(R.id.z);
      //For real coding

        ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              a=ma.getText().toString();
                check1();
            }
        });


        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r=mr.getText().toString();
                check17();
            }
        });

        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=mb.getText().toString();
                check17();

            }
        });


    }
    public void check1(){
        if(a.equals(mtwo.getText().toString())){
            mtwo.setVisibility(View.VISIBLE);
        }

    }
    public void check17(){
        if(r.equals(mthree.getText().toString())){
            mthree.setVisibility(View.VISIBLE);
        }

    }
}
