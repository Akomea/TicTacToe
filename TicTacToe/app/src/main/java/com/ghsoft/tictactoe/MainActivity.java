package com.ghsoft.tictactoe;

import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    public void dropIn(View view){
        ImageView piece = (ImageView) view;
        piece.setTranslationY(-1000f);
        piece.setImageResource(R.drawable.darkpiece);
        piece.animate().translationYBy(1000f).setDuration(200);
    }

    public void reset(View view){
        System.out.println("lsks");
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
