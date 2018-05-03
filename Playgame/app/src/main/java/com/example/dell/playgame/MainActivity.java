package com.example.dell.playgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button play_game;
    Button about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_game=(Button)findViewById(R.id.play_game);
        play_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inent =new Intent(MainActivity.this,SecondActivity.class);
                startActivity(inent);
            }
        });
        about=(Button)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent inent =new Intent(MainActivity.this,ThirdActivity.class);
                 startActivity(inent);
             }
         }
        );
    }
}
