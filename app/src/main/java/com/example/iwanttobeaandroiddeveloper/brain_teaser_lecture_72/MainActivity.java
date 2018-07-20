package com.example.iwanttobeaandroiddeveloper.brain_teaser_lecture_72;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    int current_question_number=1,questionRight=0, a = 0, b = 0,result=0;
    int question_n=0;
    TextView answerBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go).setVisibility(View.VISIBLE);//go button disable
        findViewById(R.id.timer).setVisibility(View.INVISIBLE);//timer enabled
        findViewById(R.id.question).setVisibility(View.INVISIBLE);//question enabled
        findViewById(R.id.result).setVisibility(View.INVISIBLE);//result enabled
        findViewById(R.id.button1).setVisibility(View.INVISIBLE);//button 1 enabled
        findViewById(R.id.button2).setVisibility(View.INVISIBLE);//button 2 enabled
        findViewById(R.id.button3).setVisibility(View.INVISIBLE);//button 3 enabled
        findViewById(R.id.button4).setVisibility(View.INVISIBLE);//button 4 enabled
        findViewById(R.id.answer_box).setVisibility(View.INVISIBLE);//answer box disable
        findViewById(R.id.final_result).setVisibility(View.INVISIBLE);//play_again disable

    }

    public void go(View view)
    {
        findViewById(R.id.go).setVisibility(View.INVISIBLE);//go button disable
        findViewById(R.id.timer).setVisibility(View.VISIBLE);//timer enabled
        findViewById(R.id.question).setVisibility(View.VISIBLE);//question enabled
        findViewById(R.id.result).setVisibility(View.VISIBLE);//result enabled
        findViewById(R.id.button1).setVisibility(View.VISIBLE);//button 1 enabled
        findViewById(R.id.button2).setVisibility(View.VISIBLE);//button 2 enabled
        findViewById(R.id.button3).setVisibility(View.VISIBLE);//button 3 enabled
        findViewById(R.id.button4).setVisibility(View.VISIBLE);//button 4 enabled
        findViewById(R.id.answer_box).setVisibility(View.INVISIBLE);//answer box disable
        findViewById(R.id.final_result).setVisibility(View.INVISIBLE);//final_result disable

        TextView resTextView= (TextView)findViewById(R.id.result);
        resTextView.setTextSize(24);
        resTextView.setText("0/1");
        set_Question();

        new CountDownTimer(30000,1000)
        {

            @Override
            public void onTick(long millisecondsuntildone) {
                // timer start
                TextView timer= (TextView)findViewById(R.id.timer);
                timer.setText((int) millisecondsuntildone/1000+"s");
            }

            @Override
            public void onFinish() {

                findViewById(R.id.final_result).setVisibility(View.VISIBLE);//enable final result
                answerBox.setText("Final Result: "+questionRight+"/"+current_question_number);
                answerBox.setTextSize(20);
                Button b1= (Button) findViewById(R.id.button1);
                Button b2= (Button) findViewById(R.id.button2);
                Button b3= (Button) findViewById(R.id.button3);
                Button b4= (Button) findViewById(R.id.button4);
               b1.setClickable(false);
                b2.setClickable(false);
                b3.setClickable(false);
                b4.setClickable(false);



            }
        }.start();

    }

    public void set_Question() {
        Random r = new Random();
        a = r.nextInt(50)+1;
        b = r.nextInt(50)+1;
        result = a + b;
        TextView question = (TextView) findViewById(R.id.question);

        question.setText(a + " + " + b);
        Random question_no = new Random();
         question_n=question_no.nextInt(4)+1;
        Button b1= (Button) findViewById(R.id.button1);
        Button b2= (Button) findViewById(R.id.button2);
        Button b3= (Button) findViewById(R.id.button3);
        Button b4= (Button) findViewById(R.id.button4);

        b1.setClickable(true);
        b2.setClickable(true);
        b3.setClickable(true);
        b4.setClickable(true);;


        if (question_n == 1)
        {
            b1.setText(String.valueOf(result));
            b2.setText(String.valueOf(r.nextInt(50)+1));
            b3.setText(String.valueOf(r.nextInt(50)+1));
            b4.setText(String.valueOf(r.nextInt(50)+1));


        }
        else if(question_n==2)
        {

                b1.setText(String.valueOf(r.nextInt(50)+1));
                b2.setText(String.valueOf(result));
                b3.setText(String.valueOf(r.nextInt(50)+1));
                b4.setText(String.valueOf(r.nextInt(50)+1));

        }

        else if(question_n==3)
        {
            b1.setText(String.valueOf(r.nextInt(50)+1));
            b2.setText(String.valueOf(r.nextInt(50)+1));
            b3.setText(String.valueOf(result));
            b4.setText(String.valueOf(r.nextInt(50)+1));
        }
        else
        {
            b1.setText(String.valueOf(r.nextInt(50)+1));
            b2.setText(String.valueOf(r.nextInt(50)+1));
            b3.setText(String.valueOf(r.nextInt(50)+1));
            b4.setText(String.valueOf(result));
        }



    }

    public void answerClicked(View view)
    {
        current_question_number++;

         answerBox = (TextView) findViewById(R.id.answer_box);
        Button getClickedButton;

        switch (view.getId())
        {
            case R.id.button1:
                getClickedButton=(Button) findViewById(R.id.button1);
                if(result==Integer.parseInt((String) getClickedButton.getText())) {
                    answerBox.setVisibility(View.VISIBLE);
                    questionRight++;
                    answerBox.setText("Correct !!!");
                }
                else
                {
                    answerBox.setVisibility(View.VISIBLE);
                    answerBox.setText("Wrong !!!");
                }

                break;

            case R.id.button2:
                getClickedButton=(Button) findViewById(R.id.button2);
                if(result==Integer.parseInt((String) getClickedButton.getText())) {
                    answerBox.setVisibility(View.VISIBLE);
                    questionRight++;
                    answerBox.setText("Correct !!!");
                }
                else
                {
                    answerBox.setVisibility(View.VISIBLE);
                    answerBox.setText("Wrong !!!");
                }
                break;

            case R.id.button3:
                getClickedButton=(Button) findViewById(R.id.button3);
                if(result==Integer.parseInt((String) getClickedButton.getText())) {
                    answerBox.setVisibility(View.VISIBLE);
                    questionRight++;
                    answerBox.setText("Correct !!!");
                }
                else
                {
                    answerBox.setVisibility(View.VISIBLE);
                    answerBox.setText("Wrong !!!");
                }

                break;

            case R.id.button4:
                getClickedButton=(Button) findViewById(R.id.button4);
                if(result==Integer.parseInt((String) getClickedButton.getText())) {
                    answerBox.setVisibility(View.VISIBLE);
                    questionRight++;
                    answerBox.setText("Correct !!!");
                }
                else
                {
                    answerBox.setVisibility(View.VISIBLE);
                    answerBox.setText("Wrong !!!");
                }

                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

        TextView result= (TextView)findViewById(R.id.result);
        result.setText(questionRight+"/"+current_question_number);
        result.setTextSize(24);
    set_Question();
    }

    public void playagain(View view) {
        findViewById(R.id.final_result).setVisibility(View.INVISIBLE);
        questionRight=0;current_question_number=0;
        findViewById(R.id.go).setVisibility(View.VISIBLE);//go button disable
        findViewById(R.id.timer).setVisibility(View.INVISIBLE);//timer enabled
        findViewById(R.id.question).setVisibility(View.INVISIBLE);//question enabled
        findViewById(R.id.result).setVisibility(View.INVISIBLE);//result enabled
        findViewById(R.id.button1).setVisibility(View.INVISIBLE);//button 1 enabled
        findViewById(R.id.button2).setVisibility(View.INVISIBLE);//button 2 enabled
        findViewById(R.id.button3).setVisibility(View.INVISIBLE);//button 3 enabled
        findViewById(R.id.button4).setVisibility(View.INVISIBLE);//button 4 enabled
        findViewById(R.id.answer_box).setVisibility(View.INVISIBLE);//answer box disable
        findViewById(R.id.final_result).setVisibility(View.INVISIBLE);//play_again disable
    }

    }
