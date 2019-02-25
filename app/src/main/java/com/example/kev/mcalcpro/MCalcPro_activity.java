package com.example.kev.mcalcpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ca.roumani.i2c.MPro;

public class MCalcPro_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcalcpro_layout);
    }

    public void onClick(View v)
    {
        MPro mp = new MPro();
        mp.setPrinciple(((EditText) findViewById(R.id.pBox)).getText().toString());
        mp.setAmortization(((EditText) findViewById(R.id.aBox)).getText().toString());
        mp.setInterest(((EditText) findViewById(R.id.iBox)).getText().toString());

        String s = "Monthly Payment = " + mp.computePayment("%,.2f");
        s += "\n\n";

        s += "By making this payments for " + ((EditText) findViewById(R.id.aBox)).getText().toString();
        s += "years, the mortgage will be paid in full. But if";
        s += "you terminate the mortgage on its nth";
        s += "anniversary, the balance still owing depends";
        s += "on n as shown below:";
        s += "\n\n";
        s += "\n\n";

        s += String.format("%8d", 0) + mp.outstandingAfter(0, "%,16.0f");
        s += "\n\n";
        s += String.format("%8d", 1) + mp.outstandingAfter(1, "%,16.0f");
        s += "\n\n";
        s += String.format("%8d", 2) + mp.outstandingAfter(2, "%,16.0f");
        s += "\n\n";
        s += String.format("%8d", 3) + mp.outstandingAfter(3, "%,16.0f");
        s += "\n\n";
        s += String.format("%8d", 4) + mp.outstandingAfter(4, "%,16.0f");
        s += "\n\n";
        s += String.format("%8d", 5) + mp.outstandingAfter(5, "%,16.0f");
        s += "\n\n";
        s += String.format("%8d", 10) + mp.outstandingAfter(10, "%,16.0f");
        s += "\n\n";
        s += String.format("%8d", 15) + mp.outstandingAfter(15, "%,16.0f");
        s += "\n\n";
        s += String.format("%8d", 20) + mp.outstandingAfter(20, "%,16.0f");

        ((TextView) findViewById(R.id.output)).setText(s);
    }

    public static void main(String[] args) {
        MPro mp = new MPro();
        mp.setPrinciple("400000");
        mp.setAmortization("20");
        mp.setInterest("5");

        String s = "Monthly Payment = " + mp.computePayment("%,.2f");
        s += "/n/n";
        s += "By making this payments for " + 20;

        System.out.println(s);
    }
}
