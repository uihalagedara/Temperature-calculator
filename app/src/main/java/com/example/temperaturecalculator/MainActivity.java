package com.example.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_values;
    RadioButton btn_farenhiet;
    RadioButton btn_celcius;
    Button calculator;
    TextView tv_displayvalues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_values = findViewById(R.id.tv_value);
        btn_farenhiet = findViewById(R.id.btn_farenhiet);
        btn_celcius = findViewById(R.id.btn_celcius);
        calculator = findViewById(R.id.calculate);
        tv_displayvalues = findViewById(R.id.tv_displayvalue);

    }

    @Override
    protected void onResume() {
        super.onResume();
        calculator.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        Calculations cal = new Calculations();
        String temp_val = et_values.getText().toString();

        if (TextUtils.isEmpty(temp_val)) {
            Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
        } else {
            Float temp = Float.parseFloat(temp_val);
            if (btn_celcius.isChecked()) {
                temp = cal.convertCelciusToFahrenheit(temp);
            } else if (btn_farenhiet.isChecked()) {
                temp = cal.convertFahrenheitToCelcius(temp);
            } else {
                Toast.makeText(this, "Please select a radio button!", Toast.LENGTH_LONG).show();
                temp = 0.0f;
            }

            tv_displayvalues.setText(new Float(temp).toString());
        }

    }
}






