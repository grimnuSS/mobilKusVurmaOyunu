package com.kusvurmaoyunu.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Kus {
    public int hiz = 20;
    public boolean vurulduKus = true;
    int x, y, kusSay = 1;
    Bitmap kus1, kus2, kus3, kus4;

    Kus (Resources res){
        kus1 = BitmapFactory.decodeResource(res, R.drawable.kus1);
        kus2 = BitmapFactory.decodeResource(res, R.drawable.kus2);
        kus3 = BitmapFactory.decodeResource(res, R.drawable.kus3);
        kus4 = BitmapFactory.decodeResource(res, R.drawable.kus4);

        //200 173

        kus1 = Bitmap.createScaledBitmap(kus1, 200, 173, false);
        kus2 = Bitmap.createScaledBitmap(kus2, 200, 173, false);
        kus3 = Bitmap.createScaledBitmap(kus3, 200, 173, false);
        kus4 = Bitmap.createScaledBitmap(kus4, 200, 173, false);

        y = -173;
    }
    Bitmap getKus(){
        if (kusSay == 1){
            kusSay++;
            return kus1;
        }
        if (kusSay == 2){
            kusSay++;
            return kus2;
        }
        if (kusSay == 3){
            kusSay++;
            return kus3;
        }
        kusSay = 1;
        return kus4;
    }
    Rect getCarpismaKontrol(){
        return  new Rect(x, y, x+200, y+173);
    }
}
