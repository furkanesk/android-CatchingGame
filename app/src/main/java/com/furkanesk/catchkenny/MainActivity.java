package com.furkanesk.catchkenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    int score;
    Button button;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    ImageView image9;
    ImageView image10;
    ImageView image11;
    ImageView image12;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        button = findViewById(R.id.button);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        imageArray = new ImageView[] {image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12};
        for(ImageView images: imageArray) {
            images.setVisibility(View.INVISIBLE);
        }
    }
    public void start(View view){
        catching();

        new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long time) {
                    text1.setText("Time: " + time / 1000);
                    button.setEnabled(false);
                }

                @Override
                public void onFinish() {
                    text1.setText("TIME UP");
                    handler.removeCallbacks(runnable);
                    for(ImageView images: imageArray) {
                        images.setVisibility(View.INVISIBLE);
                    }
                    button.setEnabled(true);
                }
            }.start();
        }
    public void scored(View view){
        score ++;
        text2.setText("Score: "+score);
    }
    public void catching(){
        handler = new Handler();
        runnable =new Runnable() {
            @Override
            public void run() {
                for(ImageView images: imageArray) {
                    images.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int a = random.nextInt(12);
                imageArray[a].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable, 1000);
            }
        };
        handler.post(runnable);
    }
}
