package com.supreme.babynamesgenerator;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    EditText mother, father;
    TextView gen, baby;
    SwitchCompat gender;
    String babe;
    String[] males, females;
    long maleN, femN;
    AdView adView;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, "ca-app-pub-8673867332833147~3870022707");

        adView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        mother = findViewById(R.id.mother);
        father = findViewById(R.id.father);
        baby = findViewById(R.id.baby);
        gen = findViewById(R.id.gen);
        gender = findViewById(R.id.gend);
        males = new String[]{"Liam", "Noah", "Oliver", "William", "Elijah", "James", "Benjamin", "Lucas", "Mason", "Ethan",
                "Alexander", "Henry", "Jacob", "Michael", "Daniel", "Logan", "Jackson", "Sebastian", "Jack", "Aiden", "Owen", "Samuel",
                "Matthew", "Joseph", "Levi", "Mateo", "David", "John", "Wyatt", "Carter", "Julian", "Luke", "Grayson", "Isaac", "Jayden",
                "Theodore", "Gabriel", "Anthony", "Dylan", "Leo", "Lincoln", "Jaxon", "Asher", "Christopher", "Josiah", "Andrew", "Thomas",
                "Joshua", "Ezra", "Hudson", "Charles", "Caleb", "Isiah", "Ryan", "Nathan", "Adrian", "Christian", "Maverick", "Colton",
                "Elias", "Aaron", "Eli", "Landon", "Jonathan", "Nolan", "Hunter", "Cameron", "Connor", "Santiago", "Jeremiah",
                "Ezekiel", "Angel", "Roman", "Easton", "Miles", "Robert", "Jameson", "Nicholas", "Greyson", "Cooper", "Lan", "Carson"
                , "Axel", "Jackson", "Dominic", "Leonardo", "Luca", "Austin", "Jordan", "Adam", "Xavier", "Jose", "Jace", "Everett",
                "Declan", "Evan", "Kayden", "Parker", "Wesley", "Kai"
        };
        females = new String[]{"Bella", "Audrey", "Lucy", "Addison", "Willow", "Aubrey", "Leah", "Everly", "Emilia", "Natalie",
                "Aurora", "Olivia", "Emma", "Ava", "Sophia", "Isabella", "Charlotte", "Amelia", "Mia", "Harper", "Evelyn", "Abigail",
                "Emily", "Ella", "Elizabeth", "Camila", "Luna", "Sofia", "Avery", "Mila", "Aria", "Scarlett", "Penelope", "Layla", "Chloe",
                "Victoria", "Madison", "Eleanor", "Grace", "Nora", "Riley", "Zoey", "Hannah", "Hazel", "Lily", "Ellie", "Violet", "Lillian",
                "Zoe", "Stella", "Nova", "Brooklyn", "Praisely", "Savannah", "Claire", "Skylar", "Isla", "Genesis", "Naomi", "Elena",
                "Caroline", "Eliana", "Anna", "Maya", "Valentina", "Ruby", "Kennedy", "Ivy", "Ariana", "Aaliyah", "Cora", "Madelyn",
                "Alice", "Kinsley", "Hailey", "Gabriella", "Allison", "Gianna", "Serenity", "Samantha", "Sarah", "Autumn", "Quinn", "Eva",
                "Piper", "Sophie", "Sadie", "Delilah", "Josephine", "Nevaeh", "Adeline", "Arya", "Emery", "Lydia", "Clara", "Vivian",
                "Mandeline", "Peyton", "Julia", "Rylee"};
        babe = "male";
        gender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gender.isChecked()) {

                    babe = "female";

                }
                else {

                    babe = "male";

                }
            }
        });

        gen.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                if (!father.getText().toString().isEmpty() && !mother.getText().toString().isEmpty()) {

                    baby.setVisibility(View.VISIBLE);

                    if (babe.equals("male")) {

                        maleN = Math.round(Math.random() * (males.length - 1));
                        baby.setText("Generated name: " + males[(int) maleN] + " " + father.getText().toString());

                    } else {

                        femN = Math.round(Math.random() * (females.length - 1));
                        baby.setText("Generated name: " + females[(int) femN] + " " + father.getText().toString());

                    }
                } else {

                    if (father.getText().toString().isEmpty()){

                        father.setError("This field cannot be empty");

                    }

                    if (mother.getText().toString().isEmpty()){

                        mother.setError("This field cannot be empty");

                    }

                }

            }
        });


    }

    @Override
    public void onBackPressed(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Warning");
        dialog.setMessage("Are you sure you want to exit this app?");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, exit.class);
                startActivity(intent);
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}