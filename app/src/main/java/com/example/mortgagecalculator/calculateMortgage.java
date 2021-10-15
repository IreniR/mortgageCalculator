package com.example.mortgagecalculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class calculateMortgage extends AppCompatActivity {

    Button calc_btn;
    EditText principal_loan_amount, interest_rate, num_months;
    TextView mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_mortgage);

        //Set the specific widget type to the widget id
        calc_btn = (Button) findViewById(R.id.calc_btn);

        principal_loan_amount = (EditText) findViewById(R.id.principal_amount_value);
        interest_rate = (EditText) findViewById(R.id.interest_rate_value);
        num_months = (EditText) findViewById(R.id.num_months_value);

        mortgage = (TextView) findViewById(R.id.calculated_amount);

        //when calculate button is clicked
        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If field(s) are empty present toast message
                if(TextUtils.isEmpty(principal_loan_amount.getText().toString()) || TextUtils.isEmpty(interest_rate.getText().toString()) || TextUtils.isEmpty(num_months.getText().toString())){
                    Toast myToast = Toast.makeText(getApplicationContext(), "Field Cannot be Empty", Toast.LENGTH_SHORT);
                    myToast.show();
                } //else calculate the mortgage
                else {
                    mortgageVal(v);
                }
            }
        });
    }

    public void mortgageVal(View view){

        //convert the string values inputted by user to double values
        double principal_amount = Integer.parseInt(principal_loan_amount.getText().toString());
        double interest_amount = Integer.parseInt(interest_rate.getText().toString());
        double total_num_payments = Integer.parseInt(num_months.getText().toString());

        //Calculated the monthly mortgage in different parts and display in decimal
        double monthly_interest_amount =(interest_amount / (100.00 * 12.00));
        double val1 = principal_amount * monthly_interest_amount * Math.pow((1 + monthly_interest_amount), total_num_payments);
        double val2 = Math.pow((1 + monthly_interest_amount), total_num_payments) - 1;

        double mortgage_amount = val1 / val2;
        DecimalFormat df = new DecimalFormat("#.##");
        mortgage_amount = Double.valueOf(df.format(mortgage_amount));

        //send monthly payment amount to TextView
        String final_amount = Double.toString(mortgage_amount);
        mortgage.setText( "Calculated Monthly Mortgage: "  + final_amount);

    }
}
