package com.example.android.beckettquiz;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus ( );
        if ( view != null && (ev.getAction ( ) == MotionEvent.ACTION_UP || ev.getAction ( ) == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass ( ).getName ( ).startsWith ( "android.webkit." ) ) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen ( scrcoords );
            float x = ev.getRawX ( ) + view.getLeft ( ) - scrcoords[0];
            float y = ev.getRawY ( ) + view.getTop ( ) - scrcoords[1];
            if ( x < view.getLeft ( ) || x > view.getRight ( ) || y < view.getTop ( ) || y > view.getBottom ( ) )
                (( InputMethodManager ) this.getSystemService ( Context.INPUT_METHOD_SERVICE )).hideSoftInputFromWindow ( (this.getWindow ( ).getDecorView ( ).getApplicationWindowToken ( )), 0 );
        }
        return super.dispatchTouchEvent ( ev );
    }
    /**
     * This method is called, when the Submit Answers button is clicked
     */
    public void submitAnswers(View view) {
        String name = getName();
        String summaryMessage;
        summaryMessage = createSummary(name, calculateTotalScore());
        Toast.makeText(this, summaryMessage, Toast.LENGTH_LONG).show();
    }

    /**
     * Checks EditText name
     *
     * @return string of the name
     */
    private String getName() {
        EditText name = findViewById ( R.id.your_name_view );
        String nameText = name.getText().toString();
        return nameText;
    }

    /**
     * This method creates summary message
     *
     * @param name
     * @return summaryMessage
     */
    private String createSummary(String name, int totalScore) {
        String summaryMessage = "Congratulations, " + name + "!";
        summaryMessage = summaryMessage + "\nYour score is " + totalScore + " of 12!";
        return summaryMessage;
    }

    /**
     * This method calculates total score
     */
    private int calculateTotalScore() {
        int totalScore = 0;
        /**
         *  This method checks if question 1 right answer is checked and ads 1 point to total score, if it is
         */
        RadioButton four_q1 = findViewById ( R.id.four_q1 );
        four_q1.isChecked();
        if (four_q1.isChecked()) {
            totalScore = totalScore + 1;
        }
        /**
         *  This method checks if question 2 right answer is checked and ads 1 point to total score, if it is
         */
        RadioButton barclay_q2 = findViewById ( R.id.barclay_q2 );
        barclay_q2.isChecked();
        if (barclay_q2.isChecked()) {
            totalScore = totalScore + 1;
        }

        /**
         *  This method checks if question 3 right answer is checked and ads 1 point to total score, if it is
         */
        RadioButton q3_suzanne = findViewById ( R.id.q3_suzanne );
        q3_suzanne.isChecked();
        if (q3_suzanne.isChecked()) {
            totalScore = totalScore + 1;
        }
        /**
         *  This method checks if question 4 right answers are checked and ads 1+1 point to total score, if it is
         */
        boolean cook_q4 = ((CheckBox) findViewById(R.id.cook_q4)).isChecked();
        if (cook_q4) {
            totalScore = totalScore + 1;
        }
        boolean pre_q4 = ((CheckBox) findViewById(R.id.pre_q4)).isChecked();
        if (pre_q4) {
            totalScore = totalScore + 1;
        }
        /**
         *  This method checks if question 5 right answer is checked and ads 1 point to total score, if it is
         */
        RadioButton q5_3 = findViewById ( R.id.q5_3 );
        q5_3.isChecked();
        if (q5_3.isChecked()) {
            totalScore = totalScore + 1;
        }
        /**
         *  This method checks if question 6 right answer is checked and ads 1 point to total score, if it is
         */
        RadioButton right_q6 = findViewById ( R.id.right_q6 );
        right_q6.isChecked();
        if (right_q6.isChecked()) {
            totalScore = totalScore + 1;
        }
        /**
         *  This method checks if question 7 right answer is checked and ads 1 point to total score, if it is
         */
        RadioButton france_q7 = findViewById ( R.id.france_q7 );
        france_q7.isChecked();
        if (france_q7.isChecked()) {
            totalScore = totalScore + 1;
        }

        /**
         *  This method checks if question 7 right answer is checked and ads 1 point to total score, if it is
         */
        RadioButton buster_q8 = findViewById ( R.id.buster_q8 );
        buster_q8.isChecked();
        if (buster_q8.isChecked()) {
            totalScore = totalScore + 1;
        }

        /**
         *  This method checks if question 9 right answers are checked and ads 1+1 point to total score, if it is
         */
        boolean q9_godot = ((CheckBox) findViewById(R.id.q9_godot)).isChecked();
        if (q9_godot) {
            totalScore = totalScore + 1;
        }
        boolean q9_endgame = ((CheckBox) findViewById(R.id.q9_endgame)).isChecked();
        if (q9_endgame) {
            totalScore = totalScore + 1;
        }
        /**
         *  This method checks if question 10 right answer is checked and ads 1 point to total score, if it is
         */
        RadioButton q10_no = findViewById ( R.id.q10_no );
        q10_no.isChecked();
        if (q10_no.isChecked()) {
            totalScore = totalScore + 1;
        }
        return totalScore;
    }

}
