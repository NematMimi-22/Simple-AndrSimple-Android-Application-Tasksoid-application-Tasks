package com.example.a1181766_nematmimi;
// my id is 1181766  (6+1)%6=1 so the color of button 1 that i should change, I change it to (#E6C89581)

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        TextView message = (TextView) findViewById(R.id.message);
        TextView hand = (TextView) findViewById(R.id.hands);
        TextView head = (TextView) findViewById(R.id.head);
        TextView legs = (TextView) findViewById(R.id.legs);
        EditText input = (EditText) findViewById(R.id.input);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ;

                            head.setText("  O)");
                            hand.setText("/|");


                        }
                    });


                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ;

                            head.setText("O");
                            hand.setText("/|>");


                        }
                    });

                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ;

                            head.setText("O");
                            hand.setText("/|\\");


                        }
                    });


                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ;


                            legs.setText("/ >");


                        }
                    });


                    button5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ;


                            legs.setText("/ \\");


                        }
                    });


                    button6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ;
                            String message1 = String.valueOf(input.getText());
                            message.setText(String.valueOf(message1));


                        }
                    });


                } else {
                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {;
                            ; //do nothing
                        }
                    });
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {;
                            ; //do nothing
                        }
                    });
                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {;
                            ; //do nothing
                        }
                    });
                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {;
                            ; //do nothing
                        }
                    });
                    button5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {;
                            ; //do nothing
                        }
                    });


                    button6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {;
                        ; //do nothing
                        }
                    });


                }
            }
        });

        }






}