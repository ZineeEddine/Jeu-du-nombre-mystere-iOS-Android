package com.example.nombre_mystre_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_jouer,button_quitter;
    Activity context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_jouer = (Button) findViewById(R.id.button_jouer);
        button_quitter = (Button) findViewById(R.id.button_quitter);

        button_jouer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity_jeu();
            }
        });

        button_quitter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                quitterApp();
            }
        });

    }

    public void openActivity_jeu(){
        Intent intent= new Intent(this, com.example.nombre_mystre_app.Jeu_Activity.class);
        startActivity(intent);
    }

    public void quitterApp(){
        System.exit(0);
    }

}