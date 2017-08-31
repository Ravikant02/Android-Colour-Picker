package com.ravikant.colorpicker;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private TextView txtColor;
    private ImageView imgColorPicker;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtColor = (TextView) findViewById(R.id.txtColor);
        imgColorPicker = (ImageView) findViewById(R.id.imgColorPicker);

        imgColorPicker.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                imgColorPicker.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(imgColorPicker.getDrawingCache());
                imgColorPicker.setDrawingCacheEnabled(false);

                int x = (int) event.getX();
                int y = (int) event.getY();

                if (y < 0) {
                    y = 0;
                }
                if (x < 0) {
                    x = 0;
                }

                int pixel = bitmap.getPixel(x, y);

                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);

                int argb = Color.argb(255, red, green, blue);

                txtColor.setBackgroundColor(argb);
                // toolbar.setBackgroundColor(argb);
        }
        return true;
    }
}
