package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button equal;
    private Button addition;
    private Button subtraction;
    private Button multiplication;
    private Button divide;
    private Button dot;
    private Button clear;

    private TextView solve;
    private TextView answer;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = 0;
    private char SOLVE;

    private double value1 = Double.NaN;
    private double value2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "0");

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "1");

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "2");

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "3");

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "4");

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "5");

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "6");

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "7");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "8");

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + "9");

            }
        });
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                SOLVE = ADDITION;
                answer.setText(String.valueOf(value1) + "+");
                solve.setText(null);
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                SOLVE = SUBTRACTION;
                answer.setText(String.valueOf(value1) + "-");
                solve.setText(null);
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                SOLVE = MULTIPLICATION;
                answer.setText(String.valueOf(value1) + "*");
                solve.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                SOLVE = DIVISION;
                answer.setText(String.valueOf(value1) + "/");
                solve.setText(null);
            }
        });
        equal.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                SOLVE = EQUAL;
                answer.setText(solve.getText().toString() + String.valueOf(value2) + "=" + String.valueOf(value1));
                solve.setText(null);
            }
        }));
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve.setText(solve.getText().toString() + ".");

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(solve.getText().length() > 0) {
                    CharSequence value = solve.getText().toString();
                    solve.setText(value.subSequence(0, value.length()-1));
                }
                else {
                    value1 = Double.NaN;
                    value2 = Double.NaN;
                    solve.setText(null);
                    answer.setText(null);
                }
            }
        });
    }

    private void setupUIViews() {
        zero = (Button)findViewById(R.id.btn00);
        one = (Button)findViewById(R.id.btn01);
        two = (Button)findViewById(R.id.btn02);
        three = (Button)findViewById(R.id.btn03);
        four = (Button)findViewById(R.id.btn04);
        five = (Button)findViewById(R.id.btn05);
        six = (Button)findViewById(R.id.btn06);
        seven = (Button)findViewById((R.id.btn07));
        eight = (Button)findViewById(R.id.btn08);
        nine = (Button)findViewById((R.id.btn09));
        dot = (Button)findViewById(R.id.btnDot);
        clear = (Button)findViewById(R.id.btnClear);
        addition = (Button)findViewById(R.id.btnAdd);
        subtraction = (Button)findViewById(R.id.btnMinus);
        multiplication = (Button)findViewById(R.id.btnMultiply);
        divide = (Button)findViewById(R.id.btnDivide);
        equal = (Button)findViewById(R.id.btnResult);
        solve = (TextView)findViewById(R.id.solve);
        answer = (TextView)findViewById(R.id.answer);
    }

    private void compute() {
        if (!Double.isNaN(value1)) {
            value2 = Double.parseDouble(solve.getText().toString());
            switch (SOLVE) {
                case ADDITION:
                    value1 = value1 + value2;
                    break;
                case SUBTRACTION:
                    value1 = value1 - value2;
                    break;
                case MULTIPLICATION:
                    value1 = value1 * value2;
                    break;
                case DIVISION:
                    value1 = value1 / value2;
                    break;
                case EQUAL:
                    break;
            }
        }
        else {
            value1 = Double.parseDouble(solve.getText().toString());
        }
    }
}