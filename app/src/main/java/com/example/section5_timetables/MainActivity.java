package com.example.section5_timetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> numberArrayList = new ArrayList<>();
    ArrayAdapter<Integer> arrayAdapter;
    ListView tableListView;

    public void fillTableListView(int value) {
        numberArrayList.clear();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberArrayList);
        tableListView = findViewById(R.id.tableListView);
        tableListView.setAdapter(arrayAdapter);
        for (int i = 1; i <= 10; i++) {
            numberArrayList.add(i * value);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int maxValue = 20;
        int startingPosition = 10;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar tableSeekBar = findViewById(R.id.tableSeekBar);
        tableSeekBar.setMax(maxValue);
        tableSeekBar.setProgress(startingPosition);
        fillTableListView(tableSeekBar.getProgress());

        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("Seek bar value:", Integer.toString(i));
                if (i==0) {
                    Toast.makeText(MainActivity.this, "NOT FOR ZERO!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Seek bar value: " + i, Toast.LENGTH_SHORT).show();
                    fillTableListView(i);
                }
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
