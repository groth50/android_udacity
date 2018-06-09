package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int POINTS_FOR_FREE_THROW = 1;
    final int POINTS_TWO_POINTERS_THROW = 2;
    final int POINTS_THREE_POINTERS_THROW = 3;
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) this.findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamA(View view) {
        displayForTeamA(scoreTeamA += POINTS_THREE_POINTERS_THROW);
    }

    public void addTwoForTeamA(View view) {
        displayForTeamA(scoreTeamA += POINTS_TWO_POINTERS_THROW);
    }

    public void addOneForTeamA(View view) {
        displayForTeamA(scoreTeamA += POINTS_FOR_FREE_THROW);
    }

    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) this.findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamB(View view) {
        displayForTeamB(scoreTeamB += POINTS_THREE_POINTERS_THROW);
    }

    public void addTwoForTeamB(View view) {
        displayForTeamB(scoreTeamB += POINTS_TWO_POINTERS_THROW);
    }

    public void addOneForTeamB(View view) {
        displayForTeamB(scoreTeamB += POINTS_FOR_FREE_THROW);
    }

    public Object getA() {
        return " ";
    }
}
