package org.mycalculator.com.mycalculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {
    private TextView txtCalcView;
    private Boolean MiddleOfTyping = false;
    private Operations ObjOperator;
    private static final String DIGITS = "0123456789.";
    private Button Advance;
    Context context;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObjOperator = new Operations();
        txtCalcView = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent();
        String txtBoxValue = intent.getStringExtra("txtBoxValue");
        txtCalcView = (TextView) findViewById(R.id.textView1);

        if(txtBoxValue == "" || txtBoxValue == "0"){
            txtCalcView.setText("0");
        }else{
            txtCalcView.setText(txtBoxValue);
            MiddleOfTyping = true;
        }

        Advance = (Button) findViewById(R.id.buttonAdvance);
        Advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  txtBoxValue =  txtCalcView.getText().toString();
                Intent intent;
                intent = new Intent(MainActivity.this, AdvanceCalc.class);
                intent.putExtra("txtBoxValue", txtBoxValue);
                startActivity(intent);

            }
        });

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);

        findViewById(R.id.buttonDelete).setOnClickListener(this);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
        findViewById(R.id.buttonSubtract).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonDivide).setOnClickListener(this);
        findViewById(R.id.buttonDecimalPoint).setOnClickListener(this);
        findViewById(R.id.buttonEquals).setOnClickListener(this);
        findViewById(R.id.buttonClear).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String buttonPressed = ((Button) v).getText().toString();

        if (DIGITS.contains(buttonPressed)) {
            if (MiddleOfTyping) {

                if (buttonPressed.equals(".") && txtCalcView.getText().toString().contains(".")) {

                } else {
                    txtCalcView.append(buttonPressed);
                }

            } else {

                if (buttonPressed.equals(".")) {
                    txtCalcView.setText(0 + buttonPressed);
                } else {
                    txtCalcView.setText(buttonPressed);
                }


            }
            MiddleOfTyping = true;

        } else if(buttonPressed.equalsIgnoreCase("DEL")) {

            if(txtCalcView.getText().length() <=1) {
                MiddleOfTyping = false;
                txtCalcView.setText("0");
            }else {
                MiddleOfTyping = false;
                String str = txtCalcView.getText().toString();
                txtCalcView.setText(str.substring(0, str.length() -1));
            }
        }else{
                if (MiddleOfTyping) {
                    ObjOperator.setOperand(Double.parseDouble(txtCalcView.getText().toString()));
                    MiddleOfTyping = false;
                }
            ObjOperator.Operation(buttonPressed);
            txtCalcView.setText(ObjOperator.getResult() + "");
        }

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("OPERAND", ObjOperator.getResult());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ObjOperator.setOperand(savedInstanceState.getDouble("OPERAND"));
        txtCalcView.setText(ObjOperator.getResult() + "");
    }
}