package com.example.u.opencv_android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;

public class MirrorImage  extends AppCompatActivity {

    ImageView imageView;
    Mat img;
    Button flip_270, flip_90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mirror_image);
        imageView = findViewById(R.id.image_canny);

        flip_90 = findViewById(R.id.flip_90);
        flip_270 = findViewById(R.id.flip_270);


        img = new Mat();
        Utils.bitmapToMat(TempStoreImage.getResult_image(), img);

        flip_90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Core.flip(img, img, 1);
                Bitmap img_bitmap = Bitmap.createBitmap(img.cols(), img.rows(),Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(img, img_bitmap);
                imageView.setImageBitmap(img_bitmap);
            }
        });



        flip_270.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Core.flip(img, img, 0);
                Bitmap img_bitmap = Bitmap.createBitmap(img.cols(), img.rows(),Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(img, img_bitmap);
                imageView.setImageBitmap(img_bitmap);
            }
        });

    }
}
