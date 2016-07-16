package com.bam.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MathActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button firstAnswerButton;
    private Button secondAnswerButton;
    private Button thirdAnswerButton;

    private int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        questionTextView = (TextView) findViewById(R.id.questionTextView);
        firstAnswerButton = (Button) findViewById(R.id.firstAnswerButton);
        secondAnswerButton = (Button) findViewById(R.id.secondAnswerButton);
        thirdAnswerButton = (Button) findViewById(R.id.thirdAnswerButton);

        nextQuestion();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String chosen = (String) b.getText();
                if(chosen.equals(String.valueOf(answer))){
                    nextQuestion();
                }
            }
        };

        firstAnswerButton.setOnClickListener(listener);
        secondAnswerButton.setOnClickListener(listener);
        thirdAnswerButton.setOnClickListener(listener);
    }

    private void nextQuestion(){
        int[] questionSet = QuestionGenerator.generateQuestionSet();
        answer = questionSet[2];
        questionTextView.setText(questionSet[0] + " + " + questionSet[1]);
        Random randomGenerator = new Random();
        int randomButton = randomGenerator.nextInt(3);
        switch(randomButton){
            case 0:
                firstAnswerButton.setText(String.valueOf(answer));
                secondAnswerButton.setText(String.valueOf(questionSet[3]));
                thirdAnswerButton.setText(String.valueOf(questionSet[4]));
                break;
            case 1:
                firstAnswerButton.setText(String.valueOf(questionSet[3]));
                secondAnswerButton.setText(String.valueOf(answer));
                thirdAnswerButton.setText(String.valueOf(questionSet[4]));
                break;
            case 2:
                firstAnswerButton.setText(String.valueOf(questionSet[3]));
                secondAnswerButton.setText(String.valueOf(questionSet[4]));
                thirdAnswerButton.setText(String.valueOf(answer));
                break;
            default:
                break;
        }
    }
}
