package com.example.u.opencv_android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class SobelEdgeDetector extends AppCompatActivity {

    ImageView imageView;
    Mat img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manipulations);
        imageView = findViewById(R.id.image_canny);

        img = new Mat();
        Utils.bitmapToMat(TempStoreImage.getResult_image(), img);

        Mat blurredImage=new Mat();
        Size size=new Size(7,7);
        Imgproc.GaussianBlur(img, blurredImage, size, 0,0);
        Mat gray = new Mat();
        Imgproc.cvtColor(blurredImage, gray, Imgproc.COLOR_RGB2GRAY);
        Mat xFirstDervative =new Mat(),yFirstDervative =new Mat();
        int ddepth= CvType.CV_16S;

        Imgproc.Sobel(gray, xFirstDervative,ddepth , 1,0);
        Imgproc.Sobel(gray, yFirstDervative,ddepth , 0,1);

        Mat absXD=new Mat(),absYD=new Mat();

        Core.convertScaleAbs(xFirstDervative, absXD);
        Core.convertScaleAbs(yFirstDervative, absYD);

        Mat edgeImage=new Mat();
        Core.addWeighted(absXD, 0.5, absYD, 0.5, 0, edgeImage);

        Bitmap img_bitmap = Bitmap.createBitmap(edgeImage.cols(), edgeImage.rows(),Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(edgeImage, img_bitmap);
        imageView.setImageBitmap(img_bitmap);
    }
}
