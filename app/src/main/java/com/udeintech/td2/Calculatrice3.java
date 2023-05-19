package com.udeintech.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Stack;

public class Calculatrice3 extends AppCompatActivity {
    private EditText ecran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice3);
        ecran=findViewById(R.id.tv_ecran1);
    }
    public void btn0(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"0");
    }
    public void btn1(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"1");
    }
    public void btn2(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"2");
    }
    public void btn3(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"3");
    }
    public void btn4(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"4");
    }
    public void btn5(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"5");
    }
    public void btn6(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"6");
    }
    public void btn7(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"7");
    }
    public void btn8(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"8");
    }
    public void btn9(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"9");
    }
    public void btnplus(View v)
    {
        String text =ecran.getText().toString().trim();
        if (!(text.endsWith("+")||text.endsWith("-")||text.endsWith("*")||text.endsWith("/")))
        {
            ecran.setText(text+"+");
        }
        else {}
    }
    public void btnmoins(View v)
    {
        String text =ecran.getText().toString().trim();
        if (!(text.endsWith("+")||text.endsWith("-")||text.endsWith("*")||text.endsWith("/")))
        {
            ecran.setText(text+"-");
        }
        else {}
    }
    public void btnmul(View v)
    {
        String text =ecran.getText().toString().trim();
        if (!(text.endsWith("+")||text.endsWith("-")||text.endsWith("*")||text.endsWith("/")))
        {
            ecran.setText(text+"*");
        }
        else {}
    }
    public void btndiv(View v)
    {
        String text =ecran.getText().toString().trim();
        if (!(text.endsWith("+")||text.endsWith("-")||text.endsWith("*")||text.endsWith("/")))
        {
            ecran.setText(text+"/");
        }
        else {}
    }
    public void screenclear(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.getText().clear();
    }
    public void parentheseOuvrante(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+"(");
    }
    public void point(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+".");
    }


    public void delete(View v)
    {
        String text =ecran.getText().toString().trim();
        if(text.length()>=1)
        {
            String newtext=text.substring(0,text.length()-1);
            ecran.setText(newtext);
        }

    }
    public void parentheseFermante(View v)
    {
        String text =ecran.getText().toString().trim();
        ecran.setText(text+")");
    }
    public void calcule(View v)
    {

        String text=ecran.getText().toString();
        if (!(text.endsWith("+")||text.endsWith("-")||text.endsWith("*")||text.endsWith("/")||text.endsWith("(")))
        {
            double val = evaluate(text);
            ecran.setText(Double.toString(val));
        }else {
            ecran.setText("Erreur de syntaxe");
        }

    }
    public static double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                double num = 0;
                double decimal = 0;
                int decimalPlaces = 0;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    if (expression.charAt(i) == '.') {
                        decimal = num;
                        num = 0;
                        decimalPlaces = 1;
                    } else if (decimalPlaces > 0) {
                        decimalPlaces *= 10;
                        num = num * 10 + (expression.charAt(i) - '0');
                    } else {
                        num = num * 10 + (expression.charAt(i) - '0');
                    }
                    i++;
                }
                i--;
                if (decimalPlaces > 0) {
                    num = decimal + (num / decimalPlaces);
                }
                values.push(num);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.empty() && hasPrecedence(c, operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c);
            }
        }

        while (!operators.empty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    public static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

}