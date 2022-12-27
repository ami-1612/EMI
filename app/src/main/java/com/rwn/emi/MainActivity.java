package com.rwn.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText e1, e2, e3;
    Button b1, b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        result = findViewById(R.id.result);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Float p = Float.valueOf(e1.getText().toString());
                Float r = Float.valueOf(e2.getText().toString());
                Float n = Float.valueOf(e3.getText().toString());

                r = r/(12*100);

                float final_r = 1.0f;

                for (int i = 0; i < n*12; i++) {
                    final_r = final_r*(1+r);
                }

                float f_ans = p*r*(final_r/(final_r-1));

                result.setText("Your Payable Amount With Intrest : "+(f_ans+p)+"\n\n"+"Your Intrest is : "+f_ans);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                e1.setText("");
                e2.setText("");
                e3.setText("");
                result.setText("");

            }
        });

    }
}