package com.example.a1181766nematmimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;

//1181766
//NematMimi
public class MainActivity extends AppCompatActivity {

    LinearLayout secondLinearLayout;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secondLinearLayout = new LinearLayout(this);
        LinearLayout firstLinearLayout = new LinearLayout(this);
        LinearLayout BUTTONSLayout1 = new LinearLayout(this);
        LinearLayout BUTTONSLayout2 = new LinearLayout(this);
        Button addBoat = new Button(this);
        Button addSailor = new Button(this);
        Button showBoatlist = new Button(this);
        Button showSailorlist = new Button(this);
        Button button1 = new Button(this);
        Button button2 = new Button(this);
        Button button3 = new Button(this);
        ScrollView scrollView = new ScrollView(this);
        TextView mainpage = new TextView(this);


        mainpage.setText("\n          WELCOME TO MY APPLICATION"+'\n');
        mainpage.setTextSize(20);
        BUTTONSLayout1.setOrientation(LinearLayout.HORIZONTAL);
        BUTTONSLayout2.setOrientation(LinearLayout.HORIZONTAL);
        firstLinearLayout.setOrientation(LinearLayout.VERTICAL);
        secondLinearLayout.setOrientation(LinearLayout.VERTICAL);
        addBoat.setText("Add Boat");
       addBoat.getCurrentHintTextColor();
        addSailor.setText("Add Sailor");
        showBoatlist.setText("Show Boats List");
        showSailorlist.setText("Show Sailors List");
        button1.setText("Show the list of sailors number for each nationality");
        button2.setText("Show the list of boats name in red color");
        button3.setText("Show the list of Palestinian sailor names who have a red boat");
        addBoat.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT,
                /*weight*/ 1.0f));
        addSailor.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT,
                /*weight*/ 1.0f));
        showBoatlist.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT,
                /*weight*/ 1.0f));
        showSailorlist.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT,
                /*weight*/ 1.0f));
        firstLinearLayout.addView(mainpage);
//addBoat.setBackgroundColor(Color.RED);
        addBoat.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4d0028")));
        addBoat.setTextColor(Color.WHITE);
        addSailor.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4d0028")));
        addSailor.setTextColor(Color.WHITE);
        showBoatlist.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#800042")));
        showBoatlist.setTextColor(Color.WHITE);
        showSailorlist.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#800042")));
        showSailorlist.setTextColor(Color.WHITE);
        button1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4d0028")));
        button1.setTextColor(Color.WHITE);
        button2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4d0028")));
        button2.setTextColor(Color.WHITE);
        button3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4d0028")));
        button3.setTextColor(Color.WHITE);
        BUTTONSLayout1.addView(addBoat);
        BUTTONSLayout1.addView(showBoatlist);
        BUTTONSLayout2.addView(addSailor);
        BUTTONSLayout2.addView(showSailorlist);
        firstLinearLayout.addView(BUTTONSLayout1);
        firstLinearLayout.addView(BUTTONSLayout2);
        firstLinearLayout.addView(button1);
        firstLinearLayout.addView(button2);
        firstLinearLayout.addView(button3);
        scrollView.addView(secondLinearLayout);
        firstLinearLayout.addView(scrollView);
        setContentView(firstLinearLayout);
        SharedPreferences prefs=getSharedPreferences("prefs",MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);

        if (firstStart) {
            FillDefaultData();
        }



        addBoat.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent intent = new
                        Intent(MainActivity.this, activity_add_boat.class);
                MainActivity.this.startActivity(intent);
                finish();

            }
        });

        addSailor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new
                        Intent(MainActivity.this, activity_add_sailor.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });


        showBoatlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new
                        DataBaseHelper(MainActivity.this, "M1181766", null, 1);
                Cursor allBoatsCursor = dataBaseHelper.getAllBoats();
                secondLinearLayout.removeAllViews();
                while (allBoatsCursor.moveToNext()) {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(
                          "\n"+  "Boat ID= " + allBoatsCursor.getString(0)
                                    + "\nBoat Name= " + allBoatsCursor.getString(1)
                                    + "\nBoat Color= " + allBoatsCursor.getString(2)
                                    + "\n"

                    );
                    secondLinearLayout.addView(textView);
                }
            }


        });
        showSailorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new
                        DataBaseHelper(MainActivity.this, "M1181766", null, 1);
                Cursor allBoatsCursor = dataBaseHelper.getAllSailor();
                secondLinearLayout.removeAllViews();

                while (allBoatsCursor.moveToNext()) {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(
                            "\n"+ "Sailor ID= " + allBoatsCursor.getString(0)
                                    + "\nBoat ID= " + allBoatsCursor.getString(1)
                                    + "\nSailor Name= " + allBoatsCursor.getString(2)
                                    + "\nSailor Nationality= " + allBoatsCursor.getString(3)
                                    + "\n\n"

                    );
                    secondLinearLayout.addView(textView);
                }
            }


        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new
                        DataBaseHelper(MainActivity.this, "M1181766", null, 1);
                int PalestinianSailor = dataBaseHelper.numOfPalestinianSailor();
                int JordanianSailor = dataBaseHelper.numOfJordanianSailor();
                int QatariSailor = dataBaseHelper.numOfQatariSailor();
                secondLinearLayout.removeAllViews();
                //the list of boats name in red color
                TextView title = new TextView(MainActivity.this);
                title.setText("\n"+"The list of sailors number for each nationality"+'\n');
                secondLinearLayout.addView(title);
                TextView textView = new TextView(MainActivity.this);
                textView.setText("Palestinian Nationality: "+PalestinianSailor+'\n');
                secondLinearLayout.addView(textView);
                TextView textView1 = new TextView(MainActivity.this);
                textView1.setText("Jordanian Nationality: "+JordanianSailor+'\n');
                secondLinearLayout.addView(textView1);
                TextView textView2 = new TextView(MainActivity.this);
                textView2.setText("Qatari Nationality: "+QatariSailor+'\n');
                secondLinearLayout.addView(textView2);
            }

        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new
                        DataBaseHelper(MainActivity.this, "M1181766", null, 1);
                Cursor allBoatsCursor = dataBaseHelper.nameOfRedBoats();
                ;
                secondLinearLayout.removeAllViews();
                TextView name = new TextView(MainActivity.this);
                name.setText("\n"+"The Names of the boats in red color: " + "\n");
                secondLinearLayout.addView(name);
                while (allBoatsCursor.moveToNext()) {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(
                            allBoatsCursor.getString(0)
                                    + "\n"

                    );
                    secondLinearLayout.addView(textView);
                }
            }


        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this, "M1181766", null, 1);
                Cursor allBoatsCursor = dataBaseHelper.palestiniansSailorWithRedBoat();
                secondLinearLayout.removeAllViews();
                TextView name = new TextView(MainActivity.this);
                name.setText("\n"+"The Names of Palestinian sailor who have a red boat: " + "\n");
                secondLinearLayout.addView(name);
                while (allBoatsCursor.moveToNext()) {

                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(
                            allBoatsCursor.getString(0)
                                    + "\n"

                    );
                    secondLinearLayout.addView(textView);
                }
            }


        });

    }

    private void  FillDefaultData() {

        dataBaseHelper = new DataBaseHelper(MainActivity.this, "M1181766", null, 1);
        dataBaseHelper.defaultInsertBoat("Gale", "Red");
        dataBaseHelper.defaultInsertBoat("Noah", "Black");
        dataBaseHelper.defaultInsertBoat("Neptune", "Red");
        dataBaseHelper.defaultInsertBoat("Wayfarer", "White");
        dataBaseHelper.defaultInsertBoat("Atlantis", "White");
        dataBaseHelper.defaultInsertBoat("Shark Bait", "Black");
        dataBaseHelper.defaultInsertBoat("The Dark Zone", "Red");
        dataBaseHelper.defaultInsertBoat("Flying Dutchman", "Blue");
        dataBaseHelper.defaultInsertBoat("The Kraken", "Red");
        dataBaseHelper.defaultInsertBoat("Shark Bait", "White");

        dataBaseHelper.defaultInsertSailor(2, "Ahmad", "Qatari");
        dataBaseHelper.defaultInsertSailor(3, "Yousef", "Qatari");
        dataBaseHelper.defaultInsertSailor(4, "Adam", "Jordanian");
        dataBaseHelper.defaultInsertSailor(6, "Sarah", "Qatari");
        dataBaseHelper.defaultInsertSailor(10, "Mia", "Qatari");
        dataBaseHelper.defaultInsertSailor(5, "Lucas", "Jordanian");
        dataBaseHelper.defaultInsertSailor(9, "Mohammad", "Palestinian");
        dataBaseHelper.defaultInsertSailor(1, "Kareem", "Palestinian");
        dataBaseHelper.defaultInsertSailor(7, "Ayman", "Palestinian");
        dataBaseHelper.defaultInsertSailor(8, "Tareq", "Jordanian");

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }
}







