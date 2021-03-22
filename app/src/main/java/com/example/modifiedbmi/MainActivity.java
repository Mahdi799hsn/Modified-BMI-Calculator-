package com.example.modifiedbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Weight;
    EditText Height;
    TextView display1;
    TextView display2;
    SharedPreferences sharedPreferences;

    Button Enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=findViewById(R.id.txtName);
        Weight=findViewById(R.id.txtWeight);
        Height=findViewById(R.id.txtHeight);
        display1=findViewById(R.id.txtDisplay1);
        display2=findViewById(R.id.txtDisplay2);
        Enter=findViewById(R.id.btnEnter);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);
        if(name != null)
        {
            Intent intent = new Intent(this, BMI.class);
            startActivity(intent);
        }
        String total =sharedPreferences.getString("total",null);
        if(total != null)
        {
            Intent intent = new Intent(this, BMI.class);
            startActivity(intent);
        }

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",Name.getText().toString());
                String txtWeight;
                String txtHeight;

                txtWeight = Weight.getText().toString();
                txtHeight = Height.getText().toString();

                double num1 = Double.parseDouble(txtWeight);
                double num2 = Double.parseDouble(txtHeight);
                double total = num1 / (num2 * num2);

                String strTotal= String.valueOf(total);

                editor.putString("strTotal",strTotal);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), BMI.class);
                startActivity(intent);
            }
        });
    }
}