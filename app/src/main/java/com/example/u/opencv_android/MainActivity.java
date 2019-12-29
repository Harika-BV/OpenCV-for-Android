package com.example.u.opencv_android;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.OpenCVLoader;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenCVLoader.initDebug();
    }

    public void cannyEdge(View v){
        startActivity(new Intent(MainActivity.this, CannyEdgeDetector.class));
    }

    public void grayScale(View v){
        startActivity(new Intent(MainActivity.this, GrayScaleConversion.class));
    }

    public void adjustBrightness(View v){
        startActivity(new Intent(MainActivity.this, AdjustBrightness.class));
    }


    public void MedianBlur(View v){
        startActivity(new Intent(MainActivity.this, MedianBlur.class));
    }


    public void GaussianBlur(View v){
        startActivity(new Intent(MainActivity.this, GaussianBlur.class));
    }


    public void changeColor(View v){
        startActivity(new Intent(MainActivity.this, changeColor.class));
    }


    public void mirrorImage(View v){
        startActivity(new Intent(MainActivity.this, MirrorImage.class));
    }


    public void avgblur(View v){
        startActivity(new Intent(MainActivity.this, AverageBlur.class));
    }

    public void sobel(View v){
        startActivity(new Intent(MainActivity.this, SobelEdgeDetector.class));
    }

}