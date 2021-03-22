package com.example.modifiedbmi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BMI    extends AppCompatActivity {
    TextView dpname , dptotal;
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        dpname = findViewById(R.id.name);
        dptotal = findViewById(R.id.total);

        sharedPref = getSharedPreferences("pref", MODE_PRIVATE);

        String name = sharedPref.getString("name", null);
        String total = sharedPref.getString("strTotal", null);
        dpname.setText(name);
        dptotal.setText(total);
    }
}