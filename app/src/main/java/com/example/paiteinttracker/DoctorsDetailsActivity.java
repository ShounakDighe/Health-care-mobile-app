package com.example.paiteinttracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorsDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name: Manas Gaikwad", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: Siddesh Karwa", "Hospital Address : Nigdi", "Exp :15yrs", "Mobile No:9102736170", "900"},
                    {"Doctor Name: Yashvardhan", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 7898989898", "300"},
                    {"Doctor Name : Jadhav", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No: 9898000000", "500"},
                    {"Doctor Name:Dighe", "Hospital Address : Katraj", "Exp : 11yrs", "Mobile No: 7798989898", "800"}
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name: Gaikwad", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: Karwa", "Hospital Address : Nigdi", "Exp :15yrs", "Mobile No:9102736170", "900"},
                    {"Doctor Name: Shounak", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 7898989898", "300"},
                    {"Doctor Name : Jadhav", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No: 9898000000", "500"},
                    {"Doctor Name:Yashvardhan", "Hospital Address : Katraj", "Exp : 11yrs", "Mobile No: 7798989898", "800"}
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name: Manas ", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: Siddesh ", "Hospital Address : Nigdi", "Exp :15yrs", "Mobile No:9102736170", "900"},
                    {"Doctor Name: Yash", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 7898989898", "300"},
                    {"Doctor Name : Vardhan", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No: 9898000000", "500"},
                    {"Doctor Name:Gaikwad", "Hospital Address : Katraj", "Exp : 11yrs", "Mobile No: 7798989898", "800"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name: Gaikwad ", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: karwa ", "Hospital Address : Nigdi", "Exp :15yrs", "Mobile No:9102736170", "900"},
                    {"Doctor Name: Jadhav", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 7898989898", "300"},
                    {"Doctor Name : Dighe", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No: 9898000000", "500"},
                    {"Doctor Name:Shounak", "Hospital Address : Katraj", "Exp : 11yrs", "Mobile No: 7798989898", "800"}
            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name: Manas G ", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name: Siddesh K", "Hospital Address : Nigdi", "Exp :15yrs", "Mobile No:9102736170", "900"},
                    {"Doctor Name: Yash J", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No: 7898989898", "300"},
                    {"Doctor Name : Vardhan J", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No: 9898000000", "500"},
                    {"Doctor Name:Gaikwad M", "Hospital Address : Katraj", "Exp : 11yrs", "Mobile No: 7798989898", "800"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_details);

        tv = findViewById(R.id.textViewDBTitle);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorsDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);

        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorsDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][2]);
                it.putExtra("text5",  doctor_details[i][4] + "/-");
                startActivity(it);

            }
        });

    }
}
