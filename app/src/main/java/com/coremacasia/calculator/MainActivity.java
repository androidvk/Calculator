package com.coremacasia.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity {
private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,
        bCE,bDot,bEquals,bMultiply,bMinus,
        bPlus;
private TextView textView;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        b0=findViewById(R.id.b0);
        bCE =findViewById(R.id.b00);
        bDot=findViewById(R.id.bDot);
        bPlus=findViewById(R.id.bPlus);
        bMinus=findViewById(R.id.bMinus);
        bMultiply=findViewById(R.id.bMultiply);
        bEquals=findViewById(R.id.bEquals);

        userClick();


    }

    private void userClick() {

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(4);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(5);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(6);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(7);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(8);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(9);
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromUser(0);
            }
        });

        bCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               textView.setText("0");
            }
        });

        bEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator ="=";
                calculate();
            }
        });

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               operator ="+";
                operate();
            }
        });

        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator ="*";
                operate();
            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator ="-";
                operate();
            }
        });

        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator =".";
                operate();
            }
        });

    }

    private void calculate() {
        String currentText=textView.getText().toString().trim();
        double result=0;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try{
            result = (double)engine.eval(currentText);
        }catch(Exception e){
            Toast.makeText(this,"Exception Raised",Toast.LENGTH_SHORT).show();
        }
       // currentText = currentText +"\n"+ "="+(result);
        textView.setText(String.valueOf(result));
    }

    private void operate() {
        String x=textView.getText().toString().trim();
        textView.setText(x+ operator);
    }

    private void getTextFromUser(int userInput) {
        String x=textView.getText().toString().trim();
        textView.setText(x+String.valueOf(userInput));

    }

}


