package com.example.jeunombremysterekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class Jeu_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jeu)

        val img1 = findViewById<ImageView>(R.id.imageSmiley)
        val drawable1 = getDrawable(R.drawable.smiley_pense)
        val drawable2 = getDrawable(R.drawable.smiley_pleure)
        val drawable3 = getDrawable(R.drawable.smiley_gagne)
        img1.setImageResource(R.drawable.smiley_pense)


        val boutton_valider = findViewById<Button>(R.id.button_valider)
        val editTextNumber_user = findViewById<EditText>(R.id.editTextNumber_user)
        val text_info = findViewById<TextView>(R.id.text_info)
        val textView_consigne = findViewById<TextView>(R.id.textView_consigne)

        var nombre_mystere = 24
        var nb_chance = 5
        var compteur = 0
        editTextNumber_user.setText("0")
        boutton_valider.setOnClickListener{
            val input_user = Integer.parseInt(editTextNumber_user.getText().toString())
            println(input_user)
            nb_chance -= 1
            textView_consigne.setText("Entrez un nombre compris entre 0 et 100.\n"+"Nombre de tentatives restantes : " + nb_chance );


            if (input_user == nombre_mystere){
                boutton_valider.setEnabled(false);
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
                boutton_valider.setEnabled(false);
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
    }
}