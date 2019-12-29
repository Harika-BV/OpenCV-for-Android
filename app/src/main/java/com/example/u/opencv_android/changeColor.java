package com.example.u.opencv_android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class changeColor extends AppCompatActivity {

    ImageView imageView;
    Mat img;
    Button winter, pink, cool, ocean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrast);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageView = findViewById(R.id.image_canny);

        winter = findViewById(R.id.winter);
        pink  =findViewById(R.id.pink);
        cool = findViewById(R.id.cool);
        ocean = findViewById(R.id.ocean);


        img = new Mat();
        Utils.bitmapToMat(TempStoreImage.getResult_image(), img);

        winter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Imgproc.cvtColor(img, img, Imgproc.COLORMAP_WINTER);
                Mat img_result = img.clone();
                Bitmap img_bitmap = Bitmap.createBitmap(img_result.cols(), img_result.rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(img_result, img_bitmap);
                imageView.setImageBitmap(img_bitmap);

            }
        });

        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Imgproc.cvtColor(img, img, Imgproc.COLORMAP_PINK);
                Mat img_result = img.clone();
                Bitmap img_bitmap = Bitmap.createBitmap(img_result.cols(), img_result.rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(img_result, img_bitmap);
                imageView.setImageBitmap(img_bitmap);

            }
        });

        cool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Imgproc.cvtColor(img, img, Imgproc.COLORMAP_AUTUMN);
                Mat img_result = img.clone();
                Bitmap img_bitmap = Bitmap.createBitmap(img_result.cols(), img_result.rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(img_result, img_bitmap);
                imageView.setImageBitmap(img_bitmap);


            }
        });

        ocean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Imgproc.cvtColor(img, img, Imgproc.COLORMAP_OCEAN);
                Mat img_result = img.clone();
                Bitmap img_bitmap = Bitmap.createBitmap(img_result.cols(), img_result.rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(img_result, img_bitmap);
                imageView.setImageBitmap(img_bitmap);

            }
        });


    }
}
