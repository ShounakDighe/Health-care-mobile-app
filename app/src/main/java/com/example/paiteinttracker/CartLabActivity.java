package com.example.paiteinttracker;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CartLabActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton,btncheckout,btnback;
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView tvTotal;
    private String[][]packages={};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        btnback = findViewById(R.id.btnBack);
        dateButton = findViewById(R.id.buttonDate);
        timeButton = findViewById(R.id.buttonTime);
        btncheckout = findViewById(R.id.btncheckout);
        tvTotal= findViewById(R.id.tvtotal);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();

        Database db = new Database(getApplicationContext(),"AissmsHealthCare",null,1);

        float totalAmount = 0;
        ArrayList dbData =db.getCartData(username,"lab");
        Toast.makeText(getApplicationContext(),""+dbData,Toast.LENGTH_LONG);

        packages = new String[dbData.size()][];
        int i;
        for ( i=0;i<packages.length;i++);
        {
            packages[i]= new String[5];}

       /// for(int i)


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartLabActivity.this, labtestActivity.class));
            }
        });

        initTimePicker();

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });


        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });


    }

    private void initDatePicker(){
        DatePickerDialog. OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet (DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton.setText(i2 + "/"+i1+"/" +i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal. get (Calendar. YEAR);
        int month = cal.get (Calendar.MONTH);
        int day = cal.get (Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }


    private void initTimePicker(){
        TimePickerDialog. OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener ()  {
            @Override
            public void onTimeSet (TimePicker timePicker, int i, int i1) {

                timeButton.setText(i + ":"+i1);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal. get (Calendar. HOUR);
        int mins = cal.get (Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, true);
    }
}
