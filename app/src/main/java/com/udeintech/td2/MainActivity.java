package com.udeintech.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText_number1;
    private EditText editText_number2;
    private TextView resultat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void computeAdd(View view){
        editText_number1=findViewById(R.id.txtedit_number1);
        editText_number2=findViewById(R.id.txtedit_number2);
        resultat=findViewById(R.id.tv_resualtat);
        double number1=0;
        double number2=0;
        try {
            number1=Double.parseDouble(editText_number1.getText().toString().trim());
        }catch (Exception e) {
            Toast.makeText(this,"Entrer un nombre",Toast.LENGTH_LONG).show();
        }
        try {
            number2=Double.parseDouble(editText_number2.getText().toString().trim());
        }catch (Exception e) { Toast.makeText(this,"Entrer un nombre",Toast.LENGTH_LONG).show();}

        double result=number1+number2;
        resultat.setText(Double.toString(result));

    }
    public  void openquestion1(View view){
        Intent intent=new Intent(this,Calcutatrice1.class);
        startActivity(intent);

    }
    public  void openquestion2(View view){
        Intent intent=new Intent(this,Calculatrice2.class);
        startActivity(intent);

    }

    public  void openquestion4(View view){
        Intent intent=new Intent(this,Calculatrice3.class);
        startActivity(intent);

    }
}