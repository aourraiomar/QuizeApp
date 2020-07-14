package com.example.quizerev.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizerev.Config;
import com.example.quizerev.Model.Quize;
import com.example.quizerev.R;

import java.util.ArrayList;
import java.util.Locale;

public class QuizeActivity extends AppCompatActivity {

    RadioGroup radiogroup_quiz;
    Button btn_next;
    ArrayList<Quize> quizeArrayList = new ArrayList<>();
    ImageView img_quize;
    TextView txt_question;
    Button locale;
    int cpt = 0;
    int SCORETRUE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);
        radiogroup_quiz = findViewById(R.id.radiogroup_quiz);
        btn_next = findViewById(R.id.btn_next);
        img_quize = findViewById(R.id.img_quize);
        txt_question = findViewById(R.id.txt_question);
        locale = findViewById(R.id.btn_locale);

        if(!Config.IsStatic) {
            remplirList();
            changeElement(quizeArrayList.get(cpt));
        }


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radiogroup_quiz.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuizeActivity.this, "Select Answer", Toast.LENGTH_SHORT).show();
                } else {
                    //For Static App
                    if (Config.IsStatic) {
                        int score = 0;
                        if (radiogroup_quiz.getCheckedRadioButtonId() == R.id.radio_answer1) {
                            score++;
                        }
                        

                    } else {
                        //For dynamique App
                        RadioButton radio_check = findViewById(radiogroup_quiz.getCheckedRadioButtonId());
                        int index = radiogroup_quiz.indexOfChild(radio_check);

                        if (quizeArrayList.get(cpt).getAnswertrue() == index) {
                            SCORETRUE++;
                        }


                        if(btn_next.getText().toString()=="FINISH")
                        {
                            Intent intent=new Intent(QuizeActivity.this,ScoreActivity.class);
                            double score=((double) SCORETRUE/(double) quizeArrayList.size())*100;
                            intent.putExtra("ScoreFinal",(int)score);
                            startActivity(intent);
                        }else {
                            //Change Element
                            radiogroup_quiz.clearCheck();
                            cpt++;
                            changeElement(quizeArrayList.get(cpt));
                        }

                    }
                }
            }
        });


        locale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizeActivity.this, MapsActivityCurrentPlace.class));
            }
        });

    }

    private void remplirList() {
        Quize q1 = new Quize(R.drawable.image1, "Je souhaite continuer tout droit. Je dois m'arrêter au feu", "Oui", "Non", 0);
        Quize q2 = new Quize(R.drawable.image2, "Je souhaite continuer à droite", "Je m'arrête immédiatement", "Je ralentis", "Je serre à droite", "Je serre à gauche", 0);
        Quize q3 = new Quize(R.drawable.image3, "Dans cette situation", "Je m'arrête", "Je serre à droite et je passe",  1);
        Quize q21 = new Quize(R.drawable.image4, "Je continue tout droit. Pour franchir cette intersection, je dois obligatoirement", "Ralentir", "M'arrêter", "Conserver mon allure", 0);
        Quize q5 = new Quize(R.drawable.image5, "La vitesse est limitée à 50 km/h. Face à ce piéton arrêté",  "Je klaxonne", "Je m'arrête", "Je ralentis et serre à droite", 1);
        Quize q6 = new Quize(R.drawable.image6, "Dans cette situation, je peux faire signe aux piétons de passer", "Oui", "Non", 1);
        Quize q7 = new Quize(R.drawable.image7, "Je souhaite aller tout droit. Je passe", "Après le camion", "Après la voiture blanche et le scooter", "En premier", 2);
        Quize q8 = new Quize(R.drawable.image8, "Dans cette situation", "Je m'arrête", "Je klaxonne", "Je dépasse", 2);
        Quize q9 = new Quize(R.drawable.image9, "La signalisation m'interdit de ", "Continuer tout droit", "Dépasser la vitesse de 70 km/h", "M'arrêter sur la droite", 1);
        Quize q10 = new Quize(R.drawable.image10, "Je souhaite dépasser ce cycliste", "Je klaxonne", "Je monte sur le trottoir à gauche", "Je passe en serrant à la chaussée", "Je reste derrière lui", 3);
        Quize q11 = new Quize(R.drawable.image11, "Dans cette situation", "Je m'arrête avant le passage piétons", "Je vais jusq'au véhicule qui me précède", 0);
        Quize q12 = new Quize(R.drawable.image12, "Placé où je suis, je peux encore tourner à gauche" , "Oui", "Non", 1);
        Quize q13 = new Quize(R.drawable.image13, "Je roule à 70 km/h", "Je ralentis", "Je maintiens mon allure", 0);
        Quize q14 = new Quize(R.drawable.image14, "La signalisation annonce un danger permanent", "Oui", "Non", 0);
        Quize q15 = new Quize(R.drawable.image15, "Je souhaite continuer à droite", "Je passe par la droite", "Je patiente dans la file",  1);
        Quize q16 = new Quize(R.drawable.image16, "La rue d'en face est en sens interdit pour", "Les automobilistes", "Les cyclistes",0);
        Quize q17 = new Quize(R.drawable.image17, "Après la voiture noire, je vais pouvoir dépasser ce bus", "Oui", "Non", 0);
        Quize q18 = new Quize(R.drawable.image18, "Dans cette situation", "Je ralentis", "Je m'arrête", "Je passe", "Je laisse passer la voiture grise", 0);
        Quize q19 = new Quize(R.drawable.image19, "A cette intersection", "Je passe", "Je m'arrête", 0);
        Quize q20 = new Quize(R.drawable.image20, "Le feu ne fonctionnant pas","Je passe sans ralentir", "Je cède la priorité à droite", "Je cède la priorité à gauche", 0);


        quizeArrayList.add(q1);
        quizeArrayList.add(q2);
        quizeArrayList.add(q3);
        quizeArrayList.add(q21);
        quizeArrayList.add(q5);
        quizeArrayList.add(q6);
        quizeArrayList.add(q7);
        quizeArrayList.add(q8);
        quizeArrayList.add(q9);
        quizeArrayList.add(q10);
        quizeArrayList.add(q11);
        quizeArrayList.add(q12);
        quizeArrayList.add(q13);
        quizeArrayList.add(q14);
        quizeArrayList.add(q15);
        quizeArrayList.add(q16);
        quizeArrayList.add(q17);
        quizeArrayList.add(q18);
        quizeArrayList.add(q19);
        quizeArrayList.add(q20);
    }

    private void changeElement(Quize quiz) {
        img_quize.setImageResource(quiz.getImage());

        txt_question.setText(quiz.getQuestion());

        RadioButton radio = null;

        radio = findViewById(R.id.radio_answer1);
        if(quiz.getQuize1()==null){
            radio.setVisibility(View.GONE);
        }else{
            radio.setVisibility(View.VISIBLE);
            radio.setText(quiz.getQuize1());}

        radio = findViewById(R.id.radio_answer2);
        if(quiz.getQuize2()==null){
            radio.setVisibility(View.GONE);
        }else{
            radio.setVisibility(View.VISIBLE);
            radio.setText(quiz.getQuize2());}

        radio = findViewById(R.id.radio_answer3);
        if(quiz.getQuize3()==null){
            radio.setVisibility(View.GONE);
        }else{
            radio.setVisibility(View.VISIBLE);
            radio.setText(quiz.getQuize3());}

        radio = findViewById(R.id.radio_answer4);
        if(quiz.getQuize4()==null){
            radio.setVisibility(View.GONE);
        }else{
            radio.setVisibility(View.VISIBLE);
            radio.setText(quiz.getQuize4());}

        if(cpt== quizeArrayList.size()-1)
        {
            btn_next.setText("FINISH");
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
