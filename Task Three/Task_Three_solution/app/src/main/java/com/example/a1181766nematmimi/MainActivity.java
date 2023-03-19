package com.example.a1181766nematmimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOne.communicator,FragmentTwo.communicator,FragmentThree.communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    @Override
    public void respondone (String data) {
        FragmentOne frag1 = (FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragment1);
        frag1.changeData(data);
    }




    @Override
    public void respondTwo(String data) {
        FragmentTwo frag2 = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        frag2.changeData(data);
    }




    @Override
    public void respondThree(String data) {
        FragmentThree frag3 = (FragmentThree) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        frag3.changeData(data);
    }



}