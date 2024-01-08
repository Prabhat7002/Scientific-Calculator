package com.prabhat.FirstApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    Button btn_clearAll, btn_Braces;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.txt_Display);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            display.setShowSoftInputOnFocus(false);
        }

        btn_clearAll =  findViewById(R.id.btn_clearAll);
        btn_clearAll.setOnClickListener(this::clearBTNPush);

        btn_Braces =  findViewById(R.id.btn_braces);
        btn_Braces.setOnClickListener(this::Braces);
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zero));
    }

    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.one));
    }

    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.two));
    }

    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.three));
    }

    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.four));
    }

    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.five));
    }

    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.six));
    }

    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.seven));
    }

    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eight));
    }

    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nine));
    }

    public void multiplyBTNPush(View view){
        updateText(getResources().getString(R.string.multiply));
    }

    public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divide));
    }

    public void subtractBTNPush(View view){
        updateText(getResources().getString(R.string.subtract));
    }

    public void addBTNPush(View view){
        updateText(getResources().getString(R.string.add));
    }

    public void clearBTNPush(View view){
        display.setText("");
        previousCalculation.setText("");
    }

    public void Braces(View view){
        int curPos = display.getSelectionStart();
        int openBrace = 0 ;
        int closedBrace = 0;
        int textLen = display.getText().length();

        for(int i =0; i<curPos;i++){
            if(display.getText().toString().charAt(i) == '('){
                openBrace += 1;
            }
            if(display.getText().toString().charAt(i) == ')'){
                closedBrace += 1;
            }
        }
        if(openBrace == closedBrace || display.getText().toString().charAt(textLen - 1) == '('){
            updateText("(");
            display.setSelection(curPos+1);
        }
        else if(closedBrace < openBrace && display.getText().toString().charAt(textLen - 1) != '('){
            updateText(")");
        }
        display.setSelection(curPos+1);
    }

    public void decimalBTNPush(View view){
        updateText(getResources().getString(R.string.point));
    }

    public void equalBTNPush(View view){
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);
        userExp = userExp.replaceAll(getResources().getString(R.string.multiply), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void backspaceBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void trigCosBTNPush(View view){
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("asin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("acos(");
    }

    public void trigArcTanBTNPush(View view){
        updateText("atan(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void log10BTNPush(View view){
        updateText("log10(");
    }

    public void log2BTNPush(View view){
        updateText("log2(");
    }

    public void inverse(View view){ // improve this button
        updateText("1/(");
    }

    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }

    public void xpowereBTNPush(View view){
        updateText("e^(");
    }

    public void piBTNPush(View view){
        updateText("pi");
    }

    public void eBTNPush(View view){
        updateText("e");
    }

    public void xSquaredBTNPush(View view){
        updateText("^(2)");
    }

    public void xCubeBTNPush(View view){
        updateText("^(3)");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void radBTNPush(View view){
        updateText("rad(");
    }

    public void factorialBTNPush(View view){
        updateText("!");
    }

    public void degBTNPush(View view){
        updateText("deg(");
    }
}