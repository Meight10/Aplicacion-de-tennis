package com.meight.tennisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score1 = (TextView) findViewById(R.id.score);
        score2 = (TextView) findViewById(R.id.score2);

        scoreActual = 0;
        scoreActual2 = 0;

        buttonTeam1 = (Button) findViewById(R.id.buttonTeam1);
        buttonTeam2 = (Button) findViewById(R.id.buttonTeam2);

        buttonReset = (Button) findViewById(R.id.buttonReset);

        buttonTeam1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });

        buttonTeam2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

    private TextView score1;
    private TextView score2;

    private Button buttonTeam1;
    private Button buttonTeam2;
    private Button buttonReset;

    private int scoreActual;
    private int scoreActual2;

    private final int ADV = 1;
    private final int DEUCE = -1;
    private final int WIN = 0;
    private final int DIS = -2;