package com.example.androidfirstappcalc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private String previousNumber;
    private String operation;
    private boolean isNewDigit = true;
    public final static String TAG_INFO = "Info message ==> ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText.setText("0");
    }

    public void backSpaceBtn(View view) {
        String number = editText.getText().toString();
        if (!number.equals("0")) {
            number = number.substring(0, number.length() - 1);
        }
        editText.setText(number);
    }

    public void clearAll(View view) {
        editText.setText("0");
        previousNumber = null;
        operation = null;
        isNewDigit = true;
    }

    public void clearNumber(View view) {
        editText.setText("0");
        operation = null;
        isNewDigit = true;
    }

    @SuppressLint("SetTextI18n")
    public void numHandler(View view) {
        Log.i(TAG_INFO, "previousNumber : " + previousNumber);
        Log.i(TAG_INFO, "operation : " + operation);
        if (isNewDigit) {
            editText.setText("0");
            isNewDigit = false;
        }

        Button btn = (Button) view;
        String number = editText.getText().toString();
        String buttonText = btn.getText().toString();

        if (Character.isDigit(buttonText.charAt(0))) {
            if (!number.equals("0")) {
                editText.append(buttonText);
            } else {
                editText.setText(buttonText);
            }
        } else {
            switch (buttonText) {
                case "+/-":
                    if (!number.equals("0")) {
                        if (number.charAt(0) == '-') {
                            editText.setText(number.substring(1));
                        } else {
                            editText.setText("-" + number);

                        }
                        break;
                    }

                case "-":
                    signResolveHelper(number, "-");
                    break;
                case "+":
                    signResolveHelper(number, "+");
                    break;
                case "/":
                    signResolveHelper(number, "/");
                    break;
                case "*":
                    signResolveHelper(number, "*");
                    break;

                case "=":
                    if (previousNumber == null) {
                        editText.setText("0");
                    } else {
                        editText.setText(Logic.executeOperation(previousNumber, number, operation));
                        previousNumber = null;
                    }
                    isNewDigit = true;
                    operation = null;
                    break;
            }
        }
    }

    private void signResolveHelper(String number, String sign) {
        if (previousNumber == null) {
            previousNumber = number;
        } else {
            previousNumber = Logic.executeOperation(previousNumber, number, operation);
        }
        operation = sign;
        editText.setText("0");
    }
}
