package com.example.jjuarez.moneyconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double usdConversionRate = 0.788331;
    double cadConversionRate = 1.268559;
    double moneyEntered = 0.0;
    double convertedCurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText money = (EditText) findViewById(R.id.txtMoney);
        final RadioButton usdToCad = (RadioButton) findViewById(R.id.USD_to_CAD);
        final RadioButton cadToUsd = (RadioButton) findViewById(R.id.CAD_to_USD);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moneyEntered = Double.parseDouble(money.getText().toString());
                    DecimalFormat currency = new DecimalFormat("$##,###.##");
                    if ( usdToCad.isChecked()){
                        if(moneyEntered <= 10000){
                            convertedCurrency = moneyEntered * cadConversionRate;
                            result.setText(currency.format(convertedCurrency));

                        }else{
                            Toast.makeText(MainActivity.this, "Amount must be less than $10,000.00",Toast.LENGTH_LONG).show();
                        }
                    }
                    if ( cadToUsd.isChecked()){
                        if(moneyEntered <= 10000){
                            convertedCurrency = moneyEntered * usdConversionRate;
                            result.setText(currency.format(convertedCurrency));

                        }else{
                            Toast.makeText(MainActivity.this, "Amount must be less than $10,000.00",Toast.LENGTH_LONG).show();
                        }
                    }
            }
        });
    }
}
