package com.blogspot.bitsoftwaresolution.mekpark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Animation;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ViewFlipper;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;

    RadioButton RadioButton1, RadioButton2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] images={R.drawable.one, R.drawable.two};
        v_flipper=findViewById(R.id.v_flipper);
        RadioButton1=findViewById(R.id.RadioButton1);
        RadioButton2=findViewById(R.id.RadioButton2);


        for(int image:images){
            flipperImages(image);

        }

        v_flipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {


                if(RadioButton1.isChecked()==true){
                    RadioButton2.setChecked(true);
                    RadioButton1.setChecked(false);
                }
                else{
                    RadioButton1.setChecked(true);
                    RadioButton2.setChecked(false);
                }

            }
        });

    }

    public void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setInAnimation(this,android.R.anim.slide_out_right);


    }

}