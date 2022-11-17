package com.example.nombre_mystre_app;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Jeu_Activity extends AppCompatActivity {

    int nb_chance;
    int nombre_mystere;
    int input_user;
    int compteur;
    EditText editTextNumber_user;
    TextView text_info,textView_consigne;
    Button button_valider;
    ImageView img1;
    Drawable drawable1,drawable2,drawable3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        img1 = findViewById(R.id.imageSmiley);
        drawable1 = getResources().getDrawable(R.drawable.smiley_pense);
        drawable2 = getResources().getDrawable(R.drawable.smiley_pleure);
        drawable3 = getResources().getDrawable(R.drawable.smiley_gagne);
        img1.setImageDrawable(drawable1);

        button_valider = (Button) findViewById(R.id.button_valider);
        editTextNumber_user = (EditText) findViewById(R.id.editTextNumber_user);
        text_info = (TextView) findViewById(R.id.text_info);
        textView_consigne = (TextView) findViewById(R.id.textView_consigne);

        nombre_mystere = 24;
        nb_chance = 5;
        compteur = 0;
        editTextNumber_user.setText("0");
        button_valider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                input_user = Integer.parseInt(editTextNumber_user.getText().toString());
                nb_chance -= 1;
                textView_consigne.setText("Entrez un nombre compris entre 0 et 100.\n"+"Nombre de tentatives restantes : " + nb_chance );
              //  System.out.println("L'user à saisi " + input_user +" Tentative restante = " + nb_chance);
                if (input_user == nombre_mystere){
                    button_valider.setEnabled(false);
                    editTextNumber_user.setEnabled(false);
                    compteur += 1;
                    img1.setImageDrawable(drawable3);
                    textView_consigne.setText("Fin de la partie \nVous avez GAGNÉ ");
                    text_info.setText("Bravo, vous avez trouvé le nombre mystère");
                }else {
                    if (input_user > nombre_mystere) {
                        img1.setImageDrawable(drawable2);
                        text_info.setText("Le nombre mystère est plus petit");
                    }
                    if(input_user < nombre_mystere){
                        img1.setImageDrawable(drawable2);
                        text_info.setText("Le nombre mystère est plus grand");
                    }
                }
                if(nb_chance == 0){
                    button_valider.setEnabled(false);
                    editTextNumber_user.setEnabled(false);
                    textView_consigne.setText("Fin de la partie");
                    if(compteur == 0){
                        textView_consigne.setText("Fin de la partie \nVous avez PERDU");
                    }
                    if(compteur == 1){
                        textView_consigne.setText("Fin de la partie \nVous avez GAGNÉ ");
                    }
                }
            }
        });
    }
}
