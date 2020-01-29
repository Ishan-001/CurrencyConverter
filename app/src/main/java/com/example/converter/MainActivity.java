package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.app.Activity;

public class MainActivity extends Activity {

    Spinner spin;
    TextView box;
    String[] currency={"DOLLAR","EURO","POUND","FRANC","YEN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        box= findViewById(R.id.tv);
        final EditText et = (EditText) findViewById(R.id.editText);
        et.setText("0");
        spin = (Spinner) findViewById(R.id.s1);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long l) {
                int amount;
                amount = Integer.parseInt(et.getText().toString());
                switch(currency[position]){
                    case "DOLLAR":  double amount2=amount*0.014;
                        box.setText(Double.toString(amount2));
                        break;

                    case "EURO":    amount2=amount*0.013;
                        box.setText(Double.toString(amount2));
                        break;

                    case "POUND":   amount2=amount*0.011;
                        box.setText(Double.toString(amount2));
                        break;


                    case "YEN": amount2=amount*1.55;
                        box.setText(Double.toString(amount2));
                        break;

                    case "FRANC": amount2=0.014*amount;
                        box.setText(Double.toString(amount2));
                        break;

                }
                Toast.makeText(getApplicationContext(),currency[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                box.setText("");
            }
        });
        ArrayAdapter<String> aa=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,currency);
        spin.setAdapter(aa);

    }


}
