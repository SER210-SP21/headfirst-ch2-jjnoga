package edu.quinnipiac.ser210.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

public class CalcActivity extends AppCompatActivity {
    EditText input1, input2;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = (Button) findViewById(R.id.addition);
        Button sub = (Button) findViewById(R.id.subtraction);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        res = (TextView) findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                performOp('+');
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                performOp('-');
            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = parentView.getItemAtPosition(position).toString();
                if (selectedItem.equals("*"))
                {
                    performOp('*');
                }
                else if (selectedItem.equals("/"))
                {
                    performOp('/');
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });
    }

    private void performOp(char op)
    {
        Log.v("Debug", "method performOp called");
        if ((input1.getText() != null) && (input2.getText() != null))
        {
            double num1 = Double.valueOf(input1.getText().toString());
            double num2 = Double.valueOf(input2.getText().toString());

            Log.v("Debug", "num 1" + num1 + " num 2 " + num2);
            double result = 0;

            switch(op)
            {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            res.setText(Double.toString(result));
        }
    }
}