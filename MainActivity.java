package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private Button zero,one,two,three,four,five,six,seven,eight,nine,point;
        private Button add,sub,mul,div,equal;
        private Button clear,delete;
        private TextView insert,result;
        private final char ADD = '+';
        private final  char SUB ='-';
        private final char MUL='*';
        private final char DIV ='/';
        private final char EQUAL = 0;
        private double value1 =Double.NaN;
        private double value2;
        private char OPERATION_SELECTED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one=findViewById(R.id.btn_one);
        two=findViewById(R.id.btn_two);
        three=findViewById(R.id.btn_three);
        four=findViewById(R.id.btn_four);
        five=findViewById(R.id.btn_five);
        six=findViewById(R.id.btn_6);
        seven=findViewById(R.id.btn_seven);
        eight=findViewById(R.id.btn_eight);
        nine=findViewById(R.id.btn_nine);
        zero=findViewById(R.id.btn_zero);
        add=findViewById(R.id.btn_add);
        sub=findViewById(R.id.btn_sub);
        mul=findViewById(R.id.btn_multiply);
        div=findViewById(R.id.btn_divide);
        equal=findViewById(R.id.btn_equal);
        clear=findViewById(R.id.btn_clearAll);
        delete=findViewById(R.id.btn_delete);
        insert=findViewById(R.id.txt_insert);
        result=findViewById(R.id.txt_result);
        point=findViewById(R.id.btn_point);


        //setting up on click listener
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              insert.setText(insert.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString() + "1");

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString() +"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString() +"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString() + "9");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText().toString()+".");
            }
        });
        //lets code for OPERATIONS
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                OPERATION_SELECTED=ADD;
                result.setText(String.valueOf(value1)+ "+");
                insert.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                OPERATION_SELECTED=SUB;
                result.setText(String.valueOf(value1)+ "-");
                insert.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                OPERATION_SELECTED=MUL;
                result.setText(String.valueOf(value1)+ "*");
                insert.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                OPERATION_SELECTED=DIV;
                result.setText(String.valueOf(value1)+"/");
                insert.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                OPERATION_SELECTED=EQUAL;
                result.setText(result.getText().toString()+String.valueOf(value2)+"="+String.valueOf(value1));
                insert.setText(null);
            }
        });
        //lets Set clear and delete button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1=Double.NaN;
                value2=Double.NaN;
                insert.setText(null);
                insert.setText(null);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(insert.getText().length()>0){
                    CharSequence len = insert.getText().toString();
                    insert.setText(len.subSequence(0,len.length()-1));
                }
            }
        });
    }
    //calculation part
    private void calculate(){
        if(!Double.isNaN(value1)){
            value2=Double.parseDouble(insert.getText().toString());
            switch (OPERATION_SELECTED){
                case ADD:
                    value1=value1+value2;
                    break;
                case SUB:
                    value1=value1-value2;
                    break;
                case MUL:
                    value1=value1*value2;
                    break;
                case DIV:
                    value1=value1/value2;
                    break;
                case EQUAL:
                    break;
            }
        }
        else{
            value1=Double.parseDouble(insert.getText().toString());
        }
    }

}
