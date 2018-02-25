package com.example.android.scorecounterbaseball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int strikesTeamA = 0;
    int strikesTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayStrikesForTeamA(int strikes) {
        TextView strikesView = findViewById(R.id.teamA_strikes);
        strikesView.setText(String.valueOf(strikes));
    }

    public void addOneForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addThreePointsForTeamA(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void addFourForTeamA(View view) {
        scoreTeamA = scoreTeamA + 4;
        displayForTeamA(scoreTeamA);
    }

    public void addStrikeForTeamA(View view) {
        if (strikesTeamA == 3) {
            resetGame(view);
        } else {
            strikesTeamA = strikesTeamA + 1;
            displayStrikesForTeamA(strikesTeamA);
        }
    }


    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayStrikesForTeamB(int strikes) {
        TextView strikesView = findViewById(R.id.teamB_strikes);
        strikesView.setText(String.valueOf(strikes));
    }

    public void addOneForTeamB(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void addThreePointsForTeamB(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void addFourForTeamB(View view) {
        scoreTeamB = scoreTeamB + 4;
        displayForTeamB(scoreTeamB);
    }

    public void addStrikeForTeamB(View view) {
        if (strikesTeamB == 3) {
            resetGame(view);
        } else {
            strikesTeamB = strikesTeamB + 1;
            displayStrikesForTeamB(strikesTeamB);
        }
    }

    public void resetGame(View view) {

        scoreTeamA = 0;
        scoreTeamB = 0;
        strikesTeamA = 0;
        strikesTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayStrikesForTeamA(strikesTeamA);
        displayStrikesForTeamB(strikesTeamB);
    }
}
