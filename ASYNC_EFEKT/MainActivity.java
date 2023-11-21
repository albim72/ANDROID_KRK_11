package com.marcin.asynchr_efekt_graficzny;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button przycisk;
    private ImageView obraz;
    private TextView napis;
    private ProgressBar stan;
    private Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przycisk = (Button) findViewById(R.id.btnEfekt);
        obraz = (ImageView) findViewById(R.id.imageGory);
        napis = (TextView) findViewById(R.id.textView);
        stan = (ProgressBar) findViewById(R.id.progressBar);

        Bitmap temp = BitmapFactory.decodeResource(getResources(),R.drawable.gory);
        bmp = temp.copy(Bitmap.Config.ARGB_8888,true);
        stan.setVisibility(ProgressBar.INVISIBLE);
    }

    public void kliknieto_start(View v){
        Proces p = new Proces();
        p.execute();
    }

    class Proces extends AsyncTask<Void,Void,Void> {

        private int nr,ile=5000;

        @Override
        protected Void doInBackground(Void... voids) {

            int szer=bmp.getWidth(), wys=bmp.getHeight();
            int x,y,kolor;
            int d =20;

            Canvas c = new Canvas(bmp);
            Paint p = new Paint();
            p.setStyle(Paint.Style.STROKE);
            Random rand  = new Random();

            for(nr=0;nr<ile;nr++){
                x = rand.nextInt(szer);
                y = rand.nextInt(wys);
                kolor = bmp.getPixel(x,y);

                p.setColor(kolor);
                c.drawLine(x-d,y-d,x+d,y+d,p);
                c.drawLine(x-d,y+d,x+d,y-d,p);
                publishProgress();
            }
            p.setColor(Color.WHITE);
            c.drawRect(0,0,szer-1,wys-1,p);
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            
            stan.setVisibility(ProgressBar.VISIBLE);
            przycisk.setEnabled(false);
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            
            obraz.setImageBitmap(bmp);
            przycisk.setEnabled(true);
            stan.setVisibility(ProgressBar.INVISIBLE);
            napis.setText("koniec przetwarzania obrazu...");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            
            napis.setText("Stan: " + nr + "/" + ile);
            if(nr%1000 == 0)
                obraz.setImageBitmap(bmp);
        }
    }
}
