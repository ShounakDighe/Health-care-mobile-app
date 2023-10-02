package com.example.paiteinttracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this, Home.class));
            }
        });



            CardView familyphysians = findViewById(R.id.cardFamilyPhysians);
            familyphysians.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent it = new Intent(FindDoctorActivity.this, DoctorsDetailsActivity.class);
                    it.putExtra("title", "Family Physicians");
                    startActivity(it);
                }
            });


        CardView dietician = findViewById(R.id.cardDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorsDetailsActivity.class);
                it.putExtra("title", "Dietician");
                startActivity(it);
            }
        });


        CardView dentist = findViewById(R.id.cardDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorsDetailsActivity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });


        CardView surgeon = findViewById(R.id.cardsurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorsDetailsActivity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });

        CardView cardiologists = findViewById(R.id.cardcardiologists);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorsDetailsActivity.class);
                it.putExtra("title", "Cardiologists");
                startActivity(it);
            }
        });
    }
}