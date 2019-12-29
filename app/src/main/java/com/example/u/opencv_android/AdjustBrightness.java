package com.example.u.opencv_android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


public class AdjustBrightness extends AppCompatActivity {
    ImageView imageView;
    Mat img, dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manipulations);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.image_canny);

        img = new Mat();
        Utils.bitmapToMat(TempStoreImage.getResult_image(), img);
        dest = new Mat(img.rows(), img.cols(), img.type());
        img.convertTo(dest, -1, 2,50);
        Bitmap img_bitmap = Bitmap.createBitmap(dest.cols(), dest.rows(),Bitmap.Config.ARGB_8888);
        Imgproc.cvtColor(dest,dest,Imgproc.COLOR_BGRA2BGR);
        Utils.matToBitmap(dest, img_bitmap);
        imageView.setImageBitmap(img_bitmap);

    }
}
