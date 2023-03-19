package com.example.a1181766nematmimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class activity_add_sailor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sailor);


        String[] options = { "Palestinian", "Jordanian", "Qatari" };
        final Spinner nationalitySpinner =(Spinner) findViewById(R.id.spinner_Nationality);
        ArrayAdapter<String> objnationalityArr = new
                ArrayAdapter<>(this,android.R.layout.simple_spinner_item, options);
        nationalitySpinner.setAdapter(objnationalityArr);

        final EditText nameEditText = (EditText)findViewById(R.id.edit_sailorName);
        final EditText IdEditText = (EditText)findViewById(R.id.edit_boatId);


        Button addSailorButton = (Button) findViewById(R.id.button_addSailor);
        Button back_button = (Button) findViewById(R.id.button_back);
        addSailorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sailor newSailor  =new sailor ();
                if(IdEditText.getText().toString().isEmpty()) newSailor.setmBoatId(0);
                else newSailor.setmBoatId(Long.parseLong(IdEditText.getText().toString()));
                if(nameEditText.getText().toString().isEmpty()) newSailor.setmName("No Name");
                else newSailor.setmName(nameEditText.getText().toString());
                newSailor.setmNationality(nationalitySpinner.getSelectedItem().toString());

                DataBaseHelper dataBaseHelper =new DataBaseHelper(activity_add_sailor.this,"M1181766",null,1);
                dataBaseHelper.insertSailor(newSailor);


                Intent intent=new Intent(activity_add_sailor.this,MainActivity.class);
                activity_add_sailor.this.startActivity(intent);
                finish();
            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(activity_add_sailor.this,MainActivity.class);
                activity_add_sailor.this.startActivity(intent);
                finish();
            }
        });



    }
}

