package com.example.u.opencv_android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

public class Histogram extends AppCompatActivity {

    ImageView imageView;
    Mat img;

    Point PointmP1, PointmP2, mP1,mP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manipulations);
        imageView = findViewById(R.id.image_canny);

        img = new Mat();
        Utils.bitmapToMat(TempStoreImage.getResult_image(), img);

        img.convertTo(img, CvType.CV_8UC1);

        Mat enhancedImage = new Mat();
        Imgproc.cvtColor(img,enhancedImage,Imgproc.COLOR_HSV2RGB);

        Bitmap img_bitmap = Bitmap.createBitmap(enhancedImage.cols(),enhancedImage.rows(),Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(enhancedImage, img_bitmap);
        imageView.setImageBitmap(img_bitmap);
    }


}
