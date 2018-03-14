package com.sumit.vodhalhai;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by MR.Cutevil on 9/23/2017.
 */

public class TasActivity extends AppCompatActivity {
    private static ImageView mimageview1, mimageview2, mimageview3, mimageview4, mimageview5, mimageview6;
    int a=0;
    int[] images = { R.drawable.check,R.drawable.sumit};/*    private int b;
    int[] images=[R.drawable.restaurant,R.drawable.check];*/
    private int b;
    int[] images1 = { R.drawable.check,R.drawable.pasang};
    private int c;
    int[] images2 = { R.drawable.check,R.drawable.aju};
    private int d;
    int[] images3 = { R.drawable.check,R.drawable.bibek};
    private int e;
    int[] images4 = { R.drawable.check,R.drawable.samrat};
    int flag = 0;
    Button mplayl,mtictactoe,mhangman;
    int flaga=0,flagb=0,flagc=0,flagd=0,flage=0,flagf=0;
    MediaPlayer taskhel,taskhel2,taskhel3,taskhel4,taskhel5,taskhel6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khel);
        onclick();
        mplayl=(Button)findViewById(R.id.play);
        mtictactoe=(Button)findViewById(R.id.tictactoe);
        mhangman=(Button)findViewById(R.id.hangman);

          taskhel=MediaPlayer.create(this,R.raw.sumit);
         taskhel2=MediaPlayer.create(this,R.raw.bhote);
         taskhel3=MediaPlayer.create(this,R.raw.baje);
         taskhel4=MediaPlayer.create(this,R.raw.bibek);
         taskhel5=MediaPlayer.create(this,R.raw.samrat);
        mhangman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TasActivity.this,Hangman.class);
                startActivity(i);
            }
        });
        mplayl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            taskhel.start();
            }
        });
        mtictactoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(TasActivity.this,PlayersProfile.class);
                startActivity(in);
            }
        });

    }
    public void onclick() {


        mimageview1 = (ImageView) findViewById(R.id.one);
        mimageview2 = (ImageView) findViewById(R.id.two);
        mimageview3 = (ImageView) findViewById(R.id.three);
        mimageview4 = (ImageView) findViewById(R.id.four);
        mimageview5 = (ImageView) findViewById(R.id.five);
        mimageview6 = (ImageView) findViewById(R.id.six);


        mimageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        //                mimageview.setVisibility(View.VISIBLE);

                a++;
                a = a % images.length;
                mimageview1.setImageResource(images[a]);

                flaga = 1;
                taskhel.stop();
                taskhel2.start();

            }
        });
        mimageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b++;
                b = b % images.length;
                mimageview2.setImageResource(images1[b]);
                flagb = 2;
                taskhel2.stop();
                taskhel3.start();
            }
        });

        mimageview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagc = 3;
                b++;
                b = b % images.length;
                mimageview3.setImageResource(images2[b]);
                taskhel3.stop();
                taskhel4.start();
            }
        });

        mimageview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagd = 4;
                b++;
                b = b % images.length;
                mimageview4.setImageResource(images3[b]);
                taskhel4.stop();
                taskhel5.start();
            }
        });
        mimageview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flage = 5;
                b++;
                b = b % images.length;
                mimageview5.setImageResource(images4[b]);
                taskhel5.stop();

            }
        });
        mimageview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mimageview1.setImageResource(R.drawable.sumit);
                mimageview2.setImageResource(R.drawable.pasang);
                mimageview3.setImageResource(R.drawable.aju);
                mimageview4.setImageResource(R.drawable.bibek);
                mimageview5.setImageResource(R.drawable.samrat);
                        
            }
        });
    }}
