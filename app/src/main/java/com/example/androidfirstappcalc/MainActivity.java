package com.example.androidfirstappcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Получение компонентов из лайаута
         *
         */
//        TextView textView = findViewById(R.id.text1);
//        Button button1 = findViewById(R.id.button);
        //
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText("First input");
//                System.out.println("Console hi");
//                Log.e("Log e -->", "Some f message");
//                Log.v("Log e -->", "Some f message");
//            }
//        });
        editText = findViewById(R.id.editText);


    }

    public void numHandler(View view) {
        Button button = (Button) view;
        editText.append(button.getText());
    }

}