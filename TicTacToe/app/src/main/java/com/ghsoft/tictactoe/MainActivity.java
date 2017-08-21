package com.ghsoft.tictactoe;

import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    // 0 = yellow, 1 = red
    int activePlayer = 0;
    boolean gameIsActive = true;
    // 2 means unplayed

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};


    public void dropIn(View view){
        ImageView piece = (ImageView) view;
        int tappedCounter = Integer.parseInt(piece.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameIsActive) {
            gameState[tappedCounter] = activePlayer;

            piece.setTranslationY(-1000f);

            if (activePlayer == 0) {
                piece.setImageResource(R.drawable.lightpiece);
                activePlayer = 1;
            } else {
                piece.setImageResource(R.drawable.darkpiece);
                activePlayer = 0;
            }
        piece.animate().translationYBy(1000f).setDuration(200);

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    // Someone has won!

                    gameIsActive = false;

                    String winner = "dark";

                    if (gameState[winningPosition[0]] == 0) {

                        winner = "light";

                    }
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.animate().rotationXBy(350f).setDuration(700);

                    winnerMessage.setText(winner + " has won!");

                    Typeface face = Typeface.createFromAsset(getAssets(),"Font/Funhouse.ttf");
                    winnerMessage.setTypeface(face);
                    winnerMessage.setTypeface(face);

                    TextView playagain = (TextView) findViewById(R.id.textReset);
                    playagain.setVisibility(View.VISIBLE);

                    winnerMessage.setVisibility(View.VISIBLE);

                } else {

                    boolean gameIsOver = true;

                    for (int counterState : gameState) {

                        if (counterState == 2) gameIsOver = false;

                    }

                    if (gameIsOver) {

                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                        winnerMessage.setText("It's a draw");

                        TextView playagain = (TextView) findViewById(R.id.textReset);

                        playagain.setVisibility(View.VISIBLE);
                        winnerMessage.setVisibility(View.VISIBLE);


                    }
                }
            }
        }
    }

    public void playAgain(View view) {
        gameIsActive = true;

        TextView playagain = (TextView)findViewById(R.id.textReset);
        playagain.setVisibility(View.INVISIBLE);

        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
        Typeface face = Typeface.createFromAsset(getAssets(),"Font/Funhouse.ttf");
        winnerMessage.setTypeface(face);
        winnerMessage.setTypeface(face);
        winnerMessage.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        for (int i = 0; i < gameState.length; i++) {

            gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for (int i = 0; i< gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }


    private TextView textView;
    private TextView resetText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetText = (TextView) findViewById(R.id.textReset);
        textView = (TextView) findViewById(R.id.textView);
        Typeface face = Typeface.createFromAsset(getAssets(),"Font/Funhouse.ttf");
        textView.setTypeface(face);
        resetText.setTypeface(face);
    }




}
