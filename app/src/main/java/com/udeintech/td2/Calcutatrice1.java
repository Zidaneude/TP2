package com.udeintech.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Calcutatrice1 extends AppCompatActivity {
    private EditText editText_number1;
    private EditText editText_number2;
    private TextView resultat;
    private Spinner spinner;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcutatrice1);

        ArrayList<String>opera=new ArrayList<>();
        opera.add("+");
        opera.add("-");
        opera.add("/");
        opera.add("*");
        spinner=findViewById(R.id.spiner_operateur);
        ArrayAdapter<String>operateur_adapteur=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,opera);
        spinner.setAdapter(operateur_adapteur);

    }
    public  void calculsomme1(View v)
    {
        double result=0;
        editText_number1=findViewById(R.id.txtedit_quest1_number1);
        editText_number2=findViewById(R.id.txtedit_quest1_number2);
        resultat=findViewById(R.id.tv_resualtat);
        double number1=0;
        double number2=0;
        try {
            number1=Double.parseDouble(editText_number1.getText().toString().trim());
        }catch (Exception e){}
        try {
            number2=Double.parseDouble(editText_number2.getText().toString().trim());
        }catch (Exception e){}

        String op=spinner.getSelectedItem().toString();
        switch (op)
        {
            case "+":
                result=number1+number2;
                break;
            case "-":
                result=number1-number2;
                break;
            case "*":
                result=number1*number2;
                break;
            case "/":
                try {
                    result=number1/number2;
                }catch (Exception e)
                {

                }
                break;
            default:
        }
        resultat.setText(Double.toString(result));
    }
}