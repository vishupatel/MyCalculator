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
    private TextView mCalculatorDisplay;
    private Boolean userIsInTheMiddleOfTypingANumber = false;
    private CalculatorClass mCalculatorClass;
    private static final String DIGITS = "0123456789.";
    private Button Advance;
    Context context;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculatorClass = new CalculatorClass();
        mCalculatorDisplay = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent();
        String txtBoxValue = intent.getStringExtra("txtBoxValue");
        mCalculatorDisplay = (TextView) findViewById(R.id.textView1);

        if(txtBoxValue == "" || txtBoxValue == "0"){
            mCalculatorDisplay.setText("0");
        }else{
            mCalculatorDisplay.setText(txtBoxValue);
            userIsInTheMiddleOfTypingANumber = true;
        }

        Advance = (Button) findViewById(R.id.buttonAdvance);
        Advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  txtBoxValue =  mCalculatorDisplay.getText().toString();
                Intent intent;
                intent = new Intent(MainActivity.this, AdvanceView.class);
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
            if (userIsInTheMiddleOfTypingANumber) {

                if (buttonPressed.equals(".") && mCalculatorDisplay.getText().toString().contains(".")) {

                } else {
                    mCalculatorDisplay.append(buttonPressed);
                }

            } else {

                if (buttonPressed.equals(".")) {
                    mCalculatorDisplay.setText(0 + buttonPressed);
                } else {
                    mCalculatorDisplay.setText(buttonPressed);
                }

                userIsInTheMiddleOfTypingANumber = true;
            }

        } else if(buttonPressed.equalsIgnoreCase("DEL")) {

            if(mCalculatorDisplay.getText().length() <=1) {
                userIsInTheMiddleOfTypingANumber = false;
                mCalculatorDisplay.setText("0");
            }else {
                userIsInTheMiddleOfTypingANumber = false;
                String str = mCalculatorDisplay.getText().toString();
                mCalculatorDisplay.setText(str.substring(0, str.length() -1));
            }
        }else{
                if (userIsInTheMiddleOfTypingANumber) {
                    mCalculatorClass.setOperand(Double.parseDouble(mCalculatorDisplay.getText().toString()));
                    userIsInTheMiddleOfTypingANumber = false;
                }
                mCalculatorClass.performOperation(buttonPressed);
            mCalculatorDisplay.setText(mCalculatorClass.getResult() + "");
            }

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("OPERAND", mCalculatorClass.getResult());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCalculatorClass.setOperand(savedInstanceState.getDouble("OPERAND"));
        mCalculatorDisplay.setText(mCalculatorClass.getResult() + "");
    }
}