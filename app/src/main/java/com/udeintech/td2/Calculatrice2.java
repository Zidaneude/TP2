package com.udeintech.td2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Calculatrice2 extends AppCompatActivity {
    private EditText ecran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice2);
    }

    public  void plusAction(View view){
        ecran=findViewById(R.id.tv_ecran);
        String text=ecran.getText().toString().trim()+"+";
        ecran.setText(text);

    }
    public  void egaleAction(View view){
        ecran=findViewById(R.id.tv_ecran);
        String text=ecran.getText().toString().trim();
        String[] num=text.split("\\+");
        List<Integer>list_number=new ArrayList<>();
        for (int i=0;i<num.length;i++)
        {
            try {
                list_number.add(Integer.parseInt(num[i]));
            }catch (Exception e)
            {

            }

        }
        int resul=0;

        for (int i=0;i<list_number.size();i++)
        {
            resul=resul+list_number.get(i);
        }
        ecran.setText(Integer.toString(resul));

    }
    public  void clearction(View view){
        ecran=findViewById(R.id.tv_ecran);
        ecran.getText().clear();
       // ecran.setText("");

    }
}