package com.example.u.opencv_android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class GrayScaleConversion  extends AppCompatActivity {

    ImageView imageView;
    Mat img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manipulations);
        imageView = findViewById(R.id.image_canny);

        img = new Mat();
        Utils.bitmapToMat(TempStoreImage.getResult_image(), img);
        Imgproc.cvtColor(img, img, Imgproc.COLOR_BGR2GRAY);

        Mat img_result = img.clone();
        Bitmap img_bitmap = Bitmap.createBitmap(img_result.cols(), img_result.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_result, img_bitmap);
        imageView.setImageBitmap(img_bitmap);
    }
}