package com.sumit.vodhalhai;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by MR.Cutevil on 10/5/2017.
 */

public class TicTacToe extends AppCompatActivity {
    Button mone, mtwo, mthree, mfour, mfive, msix, mseven, meight, mnine;
    int a = 0;
    ImageView mreset;
    TextView mpone,mptwo,mscore1,mscore2;
    String c,d,w,z,p,r;
    int f=0,g=0,n=0,y,q;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_tictactoe);

        Intent i = getIntent();
            ObjActivity obj = (ObjActivity) i.getSerializableExtra("sampleObject");


//        mpone.setText(pj.getFid());
//        mptwo.setText(pj.getSidl());
        mscore1=(TextView)findViewById(R.id.Score1);
        mscore2=(TextView)findViewById(R.id.Score2);
        mone = (Button) findViewById(R.id.one);
        mtwo = (Button) findViewById(R.id.two);
        mthree = (Button) findViewById(R.id.three);
        mfour = (Button) findViewById(R.id.four);
        mfive = (Button) findViewById(R.id.five);
        msix = (Button) findViewById(R.id.six);
        mseven = (Button) findViewById(R.id.seven);
        meight = (Button) findViewById(R.id.eight);
        mnine = (Button) findViewById(R.id.nine);
        mreset = (ImageView) findViewById(R.id.reset);
        mpone = (TextView) findViewById(R.id.plyerone);
        mptwo = (TextView) findViewById(R.id.playertwo);
        c=obj.getFid().toString();
        d=obj.getSid().toString();
        mpone.setText(c);
        mptwo.setText(d);

        mscore1.setText("0");
        mscore2.setText("0");



        mreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=0;
                mone.setText("");
                mtwo.setText("");
                mthree.setText("");
                mfour.setText("");
                mfive.setText("");
                msix.setText("");
                mseven.setText("");
                meight.setText("");
                mnine.setText("");

            }
        });


        mone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;

                if (a == 1 || a == 3 || a == 5 || a == 7 || a == 9) {
                    mone.setText("O");
                } else {
                    mone.setText("X");

                }
                checktick();

            }
        });

        mtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if (a == 1 || a == 3 || a == 5 || a == 7 || a == 9) {
                    mtwo.setText("O");
                } else {
                    mtwo.setText("X");
                }
                checktick();

            }
        });

        mthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if (a == 1 || a == 3 || a == 5 || a == 7 || a == 9) {
                    mthree.setText("O");
                } else {
                    mthree.setText("X");
                }
                checktick();

            }
        });

        mfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if (a == 1 || a == 3 || a == 5 || a == 7 || a == 9) {
                    mfour.setText("O");
                } else {
                    mfour.setText("X");
                }
                checktick();

            }
        });

        mfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if (a == 1 || a == 3 || a == 5 || a == 7 || a == 9) {
                    mfive.setText("O");
                } else {
                    mfive.setText("X");
                }
                checktick();

            }
        });

        msix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if (a == 1 || a == 3 || a == 5 || a == 7 || a == 9) {
                    msix.setText("O");
                } else {
                    msix.setText("X");
                }
                checktick();

            }
        });

        mseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if (a == 1 || a == 3 || a == 5 || a == 7 || a == 9) {
                    mseven.setText("O");
                } else {
                    mseven.setText("X");
                }
                checktick();

            }
        });

        meight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if (a == 1 || a == 3 || a == 5 || a == 7 || a == 9) {
                    meight.setText("O");
                } else {
                    meight.setText("X");
                }
                checktick();

            }
        });

        mnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if (a == 1 || a == 3 || a == 5 || a == 7 || a == 9) {
                    mnine.setText("O");
                } else {
                    mnine.setText("X");
                }
                checktick();

            }
        });


    }

    public void checktick() {
        if (mone.getText().toString().equals("O") && mtwo.getText().toString().equals("O") && mthree.getText().toString().equals("O")) {
            final Toast toast = Toast.makeText(TicTacToe.this, c +"wins", Toast.LENGTH_SHORT);
            toast.show();



            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            },1500);
            String z= mscore1.getText().toString();
            int y= Integer.parseInt(z);
            y=y+1;
            String w=String.valueOf(y);
            mscore1.setText(w);

        } else if (mone.getText().toString().equals("X") && mtwo.getText().toString().equals("X") && mthree.getText().toString().equals("X")) {
            g++;
            final Toast toast = Toast.makeText(TicTacToe.this, d+"wins", Toast.LENGTH_SHORT);
            toast.show();

            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            },1500);

            String p= mscore2.getText().toString();
            int q= Integer.parseInt(p);
            q=q+1;
            String r=String.valueOf(q);
            mscore2.setText(r);
        }
            if (mone.getText().toString().equals("O") && mfive.getText().toString().equals("O") && mnine.getText().toString().equals("O")) {
                final Toast toast = Toast.makeText(TicTacToe.this, c +"wins", Toast.LENGTH_SHORT);
                f++;
                toast.show();

                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                },1500);

                String z= mscore1.getText().toString();
                int y= Integer.parseInt(z);
                y=y+1;
                String w=String.valueOf(y);
                mscore1.setText(w);

            } else if (mone.getText().toString().equals("X") && mfive.getText().toString().equals("X") && mnine.getText().toString().equals("X")) {
                final Toast toast = Toast.makeText(TicTacToe.this, d+"wins", Toast.LENGTH_SHORT);
                toast.show();
                g++;
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                },1500);

                String p= mscore2.getText().toString();
                int q= Integer.parseInt(p);
                q=q+1;
                String r=String.valueOf(q);
                mscore2.setText(r);

            }



                if (mone.getText().toString().equals("O") && mfour.getText().toString().equals("O") && mseven.getText().toString().equals("O")) {
                    final Toast toast = Toast.makeText(TicTacToe.this, c +"wins", Toast.LENGTH_SHORT);
                    toast.show();
                    f++;
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    },1500);

                    String z= mscore1.getText().toString();
                    int y= Integer.parseInt(z);
                    y=y+1;
                    String w=String.valueOf(y);
                    mscore1.setText(w);


                } else if (mone.getText().toString().equals("X") && mfour.getText().toString().equals("X") && mseven.getText().toString().equals("X")) {
                    final Toast toast = Toast.makeText(TicTacToe.this, d+"wins", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    },1500);


                    String p= mscore2.getText().toString();
                    int q= Integer.parseInt(p);
                    q=q+0;
                    String r=String.valueOf(q);
                    mscore2.setText(r);
                }

                    if (mthree.getText().toString().equals("O") && mfive.getText().toString().equals("O") && mseven.getText().toString().equals("O")) {
                        final Toast toast = Toast.makeText(TicTacToe.this, c +"wins", Toast.LENGTH_SHORT);
                        toast.show();
                        f++;
                        Handler handler=new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        },1500);

                        String z= mscore1.getText().toString();
                        int y= Integer.parseInt(z);
                        y=y+1;
                        String w=String.valueOf(y);
                        mscore1.setText(w);
                    } else if (mthree.getText().toString().equals("X") && mfive.getText().toString().equals("X") && mseven.getText().toString().equals("X")) {
                        final Toast toast = Toast.makeText(TicTacToe.this, d+"wins", Toast.LENGTH_SHORT);
                        toast.show();
                        g++;
                        Handler handler=new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        },1500);
                        String p= mscore2.getText().toString();
                        int q= Integer.parseInt(p);
                        q=q+1;
                        String r=String.valueOf(q);
                        mscore2.setText(r);}


                        if (mtwo.getText().toString().equals("O") && mfive.getText().toString().equals("O") && meight.getText().toString().equals("O")) {
                            final Toast toast = Toast.makeText(TicTacToe.this, c +"wins", Toast.LENGTH_SHORT);
                            toast.show();
                            f++;
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    toast.cancel();
                                }
                            },1500);

                            String z= mscore1.getText().toString();
                            int y= Integer.parseInt(z);
                            y=y+1;
                            String w=String.valueOf(y);
                            mscore1.setText(w);

                        } else if (mtwo.getText().toString().equals("X") && mfive.getText().toString().equals("X") && meight.getText().toString().equals("X")) {
                            final Toast toast = Toast.makeText(TicTacToe.this, d+"wins", Toast.LENGTH_SHORT);
                            toast.show();
                            g++;
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    toast.cancel();
                                }
                            },1500);
                            String p= mscore2.getText().toString();
                            int q= Integer.parseInt(p);
                            q=q+1;
                            String r=String.valueOf(q);
                            mscore2.setText(r);}


                            if (mfour.getText().toString().equals("O") && mfive.getText().toString().equals("O") && msix.getText().toString().equals("O")) {
                                final Toast toast = Toast.makeText(TicTacToe.this, c +"wins", Toast.LENGTH_SHORT);
                                toast.show();
                                f++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        toast.cancel();
                                    }
                                },1500);

                                String z= mscore1.getText().toString();
                                int y= Integer.parseInt(z);
                                y=y+1;
                                String w=String.valueOf(y);
                                mscore1.setText(w);
                            } else if (mfour.getText().toString().equals("X") && mfive.getText().toString().equals("X") && msix.getText().toString().equals("X")) {
                                final Toast toast = Toast.makeText(TicTacToe.this, d+"wins", Toast.LENGTH_SHORT);
                                toast.show();
                                g++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        toast.cancel();
                                    }
                                },1500);
                                String p= mscore2.getText().toString();
                                int q= Integer.parseInt(p);
                                q=q+1;
                                String r=String.valueOf(q);
                                mscore2.setText(r);
                            }
                            if (mone.getText().toString().equals("O") && mfour.getText().toString().equals("O") && mseven.getText().toString().equals("O")) {
                                final Toast toast = Toast.makeText(TicTacToe.this, c +"wins", Toast.LENGTH_SHORT);
                                toast.show();
                                f++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        toast.cancel();
                                    }
                                },1500);

                            } else if (mone.getText().toString().equals("X") && mfour.getText().toString().equals("X") && mseven.getText().toString().equals("X")) {
                                final Toast toast = Toast.makeText(TicTacToe.this, d+"wins", Toast.LENGTH_SHORT);
                                toast.show();
                                g++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        toast.cancel();
                                    }
                                },1500);
                                String p= mscore2.getText().toString();
                                int q= Integer.parseInt(p);
                                q=q+1;
                                String r=String.valueOf(q);
                                mscore2.setText(r);
                            }



                            if (mseven.getText().toString().equals("O") && meight.getText().toString().equals("O") && mnine.getText().toString().equals("O")) {
                                final Toast toast = Toast.makeText(TicTacToe.this, c +"wins", Toast.LENGTH_SHORT);
                                toast.show();
                                f++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        toast.cancel();
                                    }
                                },1500);
                                String z= mscore1.getText().toString();
                                int y= Integer.parseInt(z);
                                y=y+1;
                                String w=String.valueOf(y);
                                mscore1.setText(w);
                            } else if (mseven.getText().toString().equals("X") && meight.getText().toString().equals("X") && mnine.getText().toString().equals("X")) {
                                final Toast toast = Toast.makeText(TicTacToe.this, d+"wins", Toast.LENGTH_SHORT);
                                toast.show();
                                g++;

                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        toast.cancel();
                                    }
                                },1500);
                                String p= mscore2.getText().toString();
                                int q= Integer.parseInt(p);
                                q=q+1;
                                String r=String.valueOf(q);
                                mscore2.setText(r);
                            }


                            if (mthree.getText().toString().equals("O") && msix.getText().toString().equals("O") && mnine.getText().toString().equals("O")) {
                                final Toast toast = Toast.makeText(TicTacToe.this, c +"wins", Toast.LENGTH_SHORT);
                                toast.show();
                                f++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        toast.cancel();
                                    }
                                },1500);

                                String z= mscore1.getText().toString();
                                int y= Integer.parseInt(z);
                                y=y+1;
                                String w=String.valueOf(y);
                                mscore1.setText(w);

                            } else if (mthree.getText().toString().equals("X") && msix.getText().toString().equals("X") && mnine.getText().toString().equals("X")) {
                                final Toast toast = Toast.makeText(TicTacToe.this, d+"wins", Toast.LENGTH_SHORT);
                                toast.show();
                                g++;
                                Handler handler=new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        toast.cancel();
                                    }
                                },1500);
                                String p= mscore2.getText().toString();
                                int q= Integer.parseInt(p);
                                q=q+1;
                                String r=String.valueOf(q);
                                mscore2.setText(r);
                            }



                        }       }


