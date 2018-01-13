package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private RadioGroup radio1Group;
    private RadioGroup radio2Group;
    private RadioButton radio1Button;
    private Button btnDisplay;
    boolean resultQ1;
    boolean resultQ2;
    boolean resultQ3;
    boolean resultQ4;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Create a toast message, displayed when a user fills in an answer.
    CharSequence textToast = " Thanks for your answer!";

    //display toast
    public void onRadioButtonClickedQ1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked. Right answer updates to true, wrong to false.
        switch (view.getId()) {
            case (R.id.radio1):
                if (checked)
                    resultQ4 = false;
                break;
            case R.id.radio2:
                if (checked)
                    resultQ1 = false;
                break;
            case R.id.radio3:
                if (checked)
                    resultQ1 = true;
                break;
            case R.id.radio4:
                if (checked)
                    resultQ1 = false;
                break;
        }
    }

    public void onRadioButtonClickedQ2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked. Right answer updates to true, wrong to false.
        switch (view.getId()) {
            case (R.id.radiob1):
                if (checked)
                    resultQ4 = false;
                break;
            case R.id.radiob2:
                if (checked)
                    resultQ1 = false;
                break;
            case R.id.radiob3:
                if (checked)
                    resultQ4 = false;
                break;
            case R.id.radiob4:
                if (checked)
                    resultQ4 = true;
                break;
        }
    }

    public void onClear(View v) {
       /* Clears all selected radio buttons to default */
        radio1Group = findViewById(R.id.radioGroup1);
        radio1Group.clearCheck();
        radio2Group = findViewById(R.id.radioGroup2);
        radio2Group.clearCheck();
        CheckBox checkBox2_1 = findViewById(R.id.checkboxa1);
        checkBox2_1.setChecked(false);
        CheckBox checkBox2_2 = findViewById(R.id.checkboxa2);
        checkBox2_2.setChecked(false);
        CheckBox checkBox2_3 = findViewById(R.id.checkboxa3);
        checkBox2_3.setChecked(false);
        CheckBox checkBox2_4 = findViewById(R.id.checkboxa4);
        checkBox2_4.setChecked(false);
        CheckBox checkBox3_1 = findViewById(R.id.checkboxb1);
        checkBox3_1.setChecked(false);
        CheckBox checkBox3_2 = findViewById(R.id.checkboxb2);
        checkBox3_2.setChecked(false);
        CheckBox checkBox3_3 = findViewById(R.id.checkboxb3);
        checkBox3_3.setChecked(false);
        CheckBox checkBox3_4 = findViewById(R.id.checkboxb4);
        checkBox3_4.setChecked(false);
        EditText resultQ5 = findViewById(R.id.edittext1);
        resultQ5.setText("");
        EditText resultQ6 = findViewById(R.id.edittext2);
        resultQ6.setText("");

        score = 0;
    }

    //Method called when Submit Button is clicked.
    public void onSubmit(View view) {
        CheckBox question2__1 = (CheckBox) findViewById(R.id.checkboxa1);
        boolean question2_1 = question2__1.isChecked();
        CheckBox question2__2 = (CheckBox) findViewById(R.id.checkboxa2);
        boolean question2_2 = question2__2.isChecked();
        CheckBox question2__3 = (CheckBox) findViewById(R.id.checkboxa3);
        boolean question2_3 = question2__3.isChecked();
        CheckBox question2__4 = (CheckBox) findViewById(R.id.checkboxa4);
        boolean question2_4 = question2__4.isChecked();
        if ((question2_1) && (question2_2) && (!question2_3) && (!question2_4)) {
            resultQ2 = true;
        }
        CheckBox question3__1 = (CheckBox) findViewById(R.id.checkboxb1);
        boolean question3_1 = question3__1.isChecked();
        CheckBox question3__2 = (CheckBox) findViewById(R.id.checkboxb2);
        boolean question3_2 = question3__2.isChecked();
        CheckBox question3__3 = (CheckBox) findViewById(R.id.checkboxb3);
        boolean question3_3 = question3__3.isChecked();
        CheckBox question3__4 = (CheckBox) findViewById(R.id.checkboxb4);
        boolean question3_4 = question3__4.isChecked();
        if ((question3_1) && (question3_2) && (!question3_3) && (!question3_4)) {
            resultQ3 = true;
        }


        //Calls method to calculate the score.
        int finalScore = calculateScore(score, resultQ1, resultQ2, resultQ3, resultQ4);
        Toast.makeText(this, "Score:  " + finalScore + textToast, Toast.LENGTH_SHORT).show();
    }

    public int calculateScore(int score, boolean resultQ1, boolean resultQ2, boolean resultQ3, boolean resultQ4) {
        if (resultQ1) {
            score += 1;
        }
        if (resultQ2) {
            score += 1;
        }
        if (resultQ3) {
            score += 1;
        }
        if (resultQ4) {
            score += 1;
        }
        if (resultQ5.equals("dias") || resultQ5.equals("Dias") || resultQ5.equals("zeus") || resultQ5.equals("Zeus")) {
            score += 1;
        }
        if (resultQ6.equals("Nafplio") || resultQ6.equals("nafplio") || resultQ6.equals("nauplio") || resultQ6.equals("Nauplio")) {
            score += 1;
        }


        return (score);
    }

    //Five question - right answer is: dias or zeus
    EditText resultQ5 = findViewById(R.id.edittext1);

    //Six question - right answer is: nafplio - Nafplio
    EditText resultQ6 = findViewById(R.id.edittext2);

}


