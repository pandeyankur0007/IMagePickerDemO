package com.example.ankur.imagepickerdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.mvc.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "OUTCOME_IMAGEPATH";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image_view);
        ImagePicker.setMinQuality(600, 600);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        String imagePath = ImagePicker.getImagePathFromResult(this, requestCode, resultCode, data);
        Log.d(TAG, imagePath);

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onPickImage(View view) {
        ImagePicker.pickImage(this, "Select your image:");
    }

}
