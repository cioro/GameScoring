package com.example.android.gamescoring;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TeamScore SpikersScore = new TeamScore();
    TeamScore FuryScore = new TeamScore();

    public static class TeamScore {

        Integer getTeamPoints() {
            return TeamPoints;
        }

        void setTeamPoints(Integer teamPoints) {
            TeamPoints = teamPoints;
        }

        Integer getTeamGames() {
            return TeamGames;
        }

        void setTeamGames(Integer teamGames) {
            TeamGames = teamGames;
        }

        Integer TeamPoints = 0;
        Integer TeamGames = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void spikersPointUp(View view) {
       increaseScoring(SpikersScore, FuryScore, R.id.team_spikers_points, R.id.team_fury_points, R.id.team_spikers_game_points);
    }

    private void increaseScoring(TeamScore teamA, TeamScore teamB, @IdRes Integer teamAPoints, @IdRes Integer teamBPoints, @IdRes Integer teamAGames) {
        teamA.setTeamPoints(teamA.getTeamPoints() + 1);
        TextView points = (TextView) findViewById(teamAPoints);
        if (teamA.getTeamPoints() >= 25 && (teamA.getTeamPoints() - teamB.getTeamPoints()) >= 2 ) {
            teamA.setTeamPoints(0);
            teamB.setTeamPoints(0);
            teamA.setTeamGames(teamA.getTeamGames()+1);
            TextView games = (TextView) findViewById(teamAGames);
            games.setText(teamA.getTeamGames().toString());
            TextView otherPoints = (TextView) findViewById(teamBPoints);
            otherPoints.setText(teamB.getTeamPoints().toString());
        }
        points.setText(teamA.getTeamPoints().toString());
    }

    public void furyPointUp(View view) {
        increaseScoring(FuryScore, SpikersScore, R.id.team_fury_points, R.id.team_spikers_points, R.id.team_fury_game_points);
    }


//    public void spikersPointDown(View view) {
//
//        SpikersPoints = SpikersPoints - 1;
//        TextView points = (TextView) findViewById(R.id.team_spikers_points);
//        if (SpikersPoints < 0) {
//            SpikersPoints = 0;
//        }
//        points.setText(SpikersPoints.toString());
//    }

//
//    public void furyPointDown(View view) {
//        FuryPoints = FuryPoints - 1;
//        TextView points = (TextView) findViewById(R.id.team_fury_points);
//        if (FuryPoints < 0) {
//            FuryPoints = 0;
//        }
//        points.setText(FuryPoints.toString());
//    }


}
