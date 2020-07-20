package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    public void generateTables(int number){
        ListView listView=findViewById(R.id.myListView);
        TextView textView=findViewById(R.id.textView);
        textView.setText("Table of "+number);
        ArrayList<Integer> tables=new ArrayList<>();
        for(int i=0;i<10;i++){
            tables.add((i+1)*number);
        }
        ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,tables);
        listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar=findViewById(R.id.mySeekBar);
        int max=20;
        int startingPosition=10;
        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);
        generateTables(startingPosition);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int seekBarNumber;
                if(i<min){
                    seekBarNumber=min;
                    seekBar.setProgress(min);
                }else{
                    seekBarNumber=i;
                }
                generateTables(seekBarNumber);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
