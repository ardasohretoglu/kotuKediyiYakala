package com.sohretoglu.arda.catchthecat;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textScore;
    TextView textTime;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView [] arrayImage;
    Runnable runnable;
    Handler handler;
    int score;
    Runnable runnable2;
    Handler handler2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        arrayImage = new ImageView[] {imageView9,imageView8,
                imageView7,imageView6,
                imageView5,imageView4,imageView3,
                imageView2,imageView1};
        movingImages();

        score=0;

        new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long milisUntilFinished) {
                TextView textTime = (TextView) findViewById(R.id.textTime);
                textTime.setText("Time : "+milisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                TextView textTime = (TextView) findViewById(R.id.textTime);
                textTime.setText("Game Over ");
                handler.removeCallbacks(runnable);
                for(ImageView image : arrayImage)
                {
                    image.setVisibility(View.INVISIBLE);
                }

            }
        }.start();
    }



    public void increaseScore (View view)
    {
        textScore = (TextView) findViewById(R.id.textScore);
        score++;
        textScore.setText("Score : "+ score);
    }

    public void movingImages()
    {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : arrayImage)
                {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int a = random.nextInt(8-0);
                arrayImage[a].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);

    }
}
