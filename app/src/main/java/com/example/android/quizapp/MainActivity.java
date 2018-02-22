package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    boolean resultQ5;
    boolean resultQ6;


    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //display toast
    public void onRadioButtonClickedQ1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked. Right answer updates to true, wrong to false.
        switch (view.getId()) {
            case (R.id.radio1):
                if (checked)
                    resultQ1 = false;
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
                    resultQ4 = false;
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
       /* Clears all selected radio buttons, checkboxes, edittexts to default */
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
        EditText question5 = findViewById(R.id.edittext1);
        question5.setText("");
        EditText question6 = findViewById(R.id.edittext2);
        question6.setText("");
        resultQ1 = false;
        resultQ2 = false;
        resultQ3 = false;
        resultQ4 = false;
        resultQ5 = false;
        resultQ6 = false;
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

        // If RadioGroup is empty in question 1
        RadioGroup radio1Group = findViewById(R.id.radioGroup1);
        if (radio1Group.getCheckedRadioButtonId() == -1) {
            score = 0;
            Toast.makeText(this, R.string.noanswerQ1, Toast.LENGTH_SHORT).show();
            return;
        }
        // If CheckBox is empty in question 2
        if ((!question2_2) && (!question2_3) && (!question2_1) && (!question2_4)) {
            score = 0;
            Toast.makeText(this, R.string.noanswerQ2, Toast.LENGTH_SHORT).show();
            return;
        }

        if ((question2_2) && (question2_3) && (!question2_1) && (!question2_4)) {
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

        // If CheckBox is empty in question 3
        if ((!question3_2) && (!question3_3) && (!question3_1) && (!question3_4)) {
            score = 0;
            Toast.makeText(this, R.string.noanswerQ3, Toast.LENGTH_SHORT).show();
            return;
        }

        if ((question3_1) && (question3_3) && (!question3_2) && (!question3_4)) {
            resultQ3 = true;
        }

        // If RadioGroup is empty in question 4
        RadioGroup radio2Group = findViewById(R.id.radioGroup2);
        if (radio2Group.getCheckedRadioButtonId() == -1) {
            score = 0;
            Toast.makeText(this, R.string.noanswerQ4, Toast.LENGTH_SHORT).show();
            return;
        }

        //Five question - right answer is: dias or zeus
        EditText question_5 = findViewById(R.id.edittext1);
        String question5 = question_5.getText().toString();
        // If EditText is empty in question 5
        if (question5.isEmpty()) {
            score = 0;
            Toast.makeText(this, R.string.noanswerQ5, Toast.LENGTH_SHORT).show();
            return;
        }
        if (question5.equals(getString(R.string.dias)) || question5.equals(getString(R.string.Dias)) || question5.equals(getString(R.string.zeus)) || question5.equals(getString(R.string.Zeus))) {
            resultQ5 = true;
        }
        //Six question - right answer is: nafplio - Nafplio
        EditText question_6 = findViewById(R.id.edittext2);
        String question6 = question_6.getText().toString();
        // If EditText is empty in question 6
        if (question6.isEmpty()) {
            score = 0;
            Toast.makeText(this, R.string.noanswerQ6, Toast.LENGTH_SHORT).show();
            return;
        }
        if (question6.equals(getString(R.string.Nafplio1)) || question6.equals(getString(R.string.nafplio1)) || question6.equals(getString(R.string.nauplio)) || question6.equals(getString(R.string.Nauplio))) {
            resultQ6 = true;
        }


        //Calls method to calculate the score.
        int finalScore = calculateScore(score, resultQ1, resultQ2, resultQ3, resultQ4, resultQ5, resultQ6);
        //Create a toast message, displayed when a user fills in an answer.
        CharSequence textToast = "\n" + getString(R.string.thanks);
        // Message if Questions is Correct or Wrong
        String message = "";
        if (resultQ1) {
            message += "\n" + getString(R.string.Q1isCorrect);
        } else {
            message += "\n" + getString(R.string.Q1isWrong);
        }
        if (resultQ2) {
            message += "\n" + getString(R.string.Q2isCorrect);
        } else {
            message += "\n" + getString(R.string.Q2isWrong);
        }
        if (resultQ3) {
            message += "\n" + getString(R.string.Q3isCorrect);
        } else {
            message += "\n" + getString(R.string.Q3isWrong);
        }
        if (resultQ4) {
            message += "\n" + getString(R.string.Q4isCorrect);
        } else {
            message += "\n" + getString(R.string.Q4isWrong);
        }
        if (resultQ5) {
            message += "\n" + getString(R.string.Q5isCorrect);
        } else {
            message += "\n" + getString(R.string.Q5isWrong);
        }
        if (resultQ6) {
            message += "\n" + getString(R.string.Q6isCorrect);
        } else {
            message += "\n" + getString(R.string.Q6isWrong);
        }
        Toast.makeText(this, getString(R.string.score) + " " + finalScore + "\n" + textToast + "\n" + message, Toast.LENGTH_SHORT).show();

    }

    public int calculateScore(int score, boolean resultQ1, boolean resultQ2, boolean resultQ3, boolean resultQ4, boolean resultQ5, boolean resultQ6) {
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
        if (resultQ5) {
            score += 1;
        }
        if (resultQ6) {
            score += 1;
        }

        return (score);
    }


}
