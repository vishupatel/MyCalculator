package org.mycalculator.com.mycalculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by vishakha14 on 5/2/2015.
 */
public class AdvanceView extends Activity {
    private TextView mCalculatorDisplay;
    String fieldValue;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanceview);



        Intent intent = getIntent();
        String txtBoxValue = intent.getStringExtra("txtBoxValue");
        mCalculatorDisplay = (TextView) findViewById(R.id.advanceView1);
        if(txtBoxValue.equals("")){
            mCalculatorDisplay.setText("0");
        }else{
            mCalculatorDisplay.setText(txtBoxValue);
        }


        Button buttonBasic = (Button) findViewById(R.id.buttonBasic);
        buttonBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtBoxValue = (String) mCalculatorDisplay.getText();
                Intent intent = new Intent(AdvanceView.this, MainActivity.class);
                intent.putExtra("txtBoxValue", txtBoxValue);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonSquareRoot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if (fieldValue == "" || mCalculatorDisplay.equals("0")) {

                } else {
                    double number = Float.parseFloat(fieldValue);
                    double result = Math.sqrt(number);
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });


        findViewById(R.id.buttonSine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    double number = Float.parseFloat(fieldValue);
                    double result = Math.sin(number);
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });

        findViewById(R.id.buttonCosine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    double number = Float.parseFloat(fieldValue);
                    double result = Math.cos(number);
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });

        findViewById(R.id.buttonTangent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    double number = Float.parseFloat(fieldValue);
                    double result = Math.tan(number);
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });

        findViewById(R.id.buttonLog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    double number = Float.parseFloat(fieldValue);
                    double result = Math.log(number);
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });

        findViewById(R.id.buttonNaturalLog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    double number = Float.parseFloat(fieldValue);
                    double result = Math.log10(number);
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCalculatorDisplay.setText("0");
            }
        });

        findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCalculatorDisplay.getText().length() <=1) {
                    mCalculatorDisplay.setText("0");
                }else {
                    String str = mCalculatorDisplay.getText().toString();
                    mCalculatorDisplay.setText(str.substring(0, str.length() -1));
                }
            }
        });

        findViewById(R.id.buttonPi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    double number = Float.parseFloat(fieldValue);
                    double result = number * Math.PI;
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });

        findViewById(R.id.buttonSquared).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    double number = Float.parseFloat(fieldValue);
                    double result = number * number;
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });

        findViewById(R.id.buttonExponential).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    double number = Float.parseFloat(fieldValue);
                    double result = number * 2.71828;
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });

        findViewById(R.id.buttonExclamation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    int number = (int) Float.parseFloat(fieldValue);
                    double result = 1;
                    if(number >=2){
                        for(int i = 2; i<= number; i++){
                            result *= i;
                        }
                    }
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });



        /* Need to work on this */
        findViewById(R.id.buttonPercentage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fieldValue = mCalculatorDisplay.getText().toString();
                if(fieldValue == "" || mCalculatorDisplay.equals("0")){

                }else{
                    double number = Float.parseFloat(fieldValue);
                    double result = number/100;
                    mCalculatorDisplay.setText(result + "");

                }
            }
        });



    }
}
