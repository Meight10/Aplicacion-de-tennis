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

        score1 = (TextView)findViewById(R.id.score);
        score2 = (TextView)findViewById(R.id.score2);

        scoreActual = 0;
        scoreActual2 = 0;

        buttonTeam1 = (Button)findViewById(R.id.buttonTeam1);
        buttonTeam2 = (Button)findViewById(R.id.buttonTeam2);

        buttonReset = (Button)findViewById(R.id.buttonReset);

        buttonTeam1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                actionPerformedButtonTeam1();

            }
        });

        buttonTeam2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                actionPerformedButtonTeam2();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                actionPerformedButtonReset();
            }
        });
    }

    private void actionPerformedButtonTeam1() {
        boolean win;
       if(scoreActual <= 30){

           if(scoreActual == 30){
               scoreActual += 10;
               score1.setText(String.valueOf(scoreActual));
           }else{
               scoreActual += 15;
               score1.setText(String.valueOf(scoreActual));
           }
       }
       else if(scoreActual > 30){

            if(scoreActual == scoreActual2){
                score1.setText(actualStateGame(ADV));
                score1.setTextSize(23);
                score2.setText(actualStateGame(DIS));
            }else if(scoreActual > scoreActual2){
                score1.setText(actualStateGame(WIN));
                score1.setTextSize(23);
                buttonTeam1.setEnabled(false);
                buttonTeam2.setEnabled(false);
            }else if(scoreActual < scoreActual2){
                score1.setText(actualStateGame(DEUCE));
                score1.setTextSize(23);
                score2.setText(actualStateGame(DEUCE));
            }

           scoreActual += 10;

       }

    }

    private void actionPerformedButtonTeam2() {

        if(scoreActual2 <= 30){
            if(scoreActual2 == 30){
                scoreActual2 += 10;
                score2.setText(String.valueOf(scoreActual2));
            }else{
                scoreActual2 += 15;
                score2.setText(String.valueOf(scoreActual2));
            }

        }
        else if(scoreActual2 > 30){

            if(scoreActual == scoreActual2){
                score2.setText(actualStateGame(ADV));
                score2.setTextSize(23);

                score1.setText(actualStateGame(DIS));
            }else if(scoreActual2 > scoreActual){

                score2.setText(actualStateGame(WIN));
                score2.setTextSize(16);
                score2.setTextSize(23);

                buttonTeam1.setEnabled(false);
                buttonTeam2.setEnabled(false);
            }else if(scoreActual2 < scoreActual){
                score2.setText(actualStateGame(DEUCE));
                score2.setTextSize(23);

                score1.setText(actualStateGame(DEUCE));
            }
            scoreActual2 += 10;

        }
    }

    private void actionPerformedButtonReset() {
        score1.setText("0");
        score1.setTextSize(26);
        score2.setText("0");
        score2.setTextSize(26);

        scoreActual = 0;
        scoreActual2 = 0;

        buttonTeam1.setEnabled(true);
        buttonTeam2.setEnabled(true);
    }

    private String actualStateGame(int state){
        String actualState = "-";
        if(state == WIN){
            actualState = "GAME!! YOU WIN";
        }else if(state == DEUCE){
            actualState = "DEUCE";
        }else if(state == ADV){
            actualState = "ADVANTAGE";
        }

        return actualState;
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
}
