package com.kusvurmaoyunu.app;

import static com.kusvurmaoyunu.app.OyunEkrani.ekranBuyuklukX;
import static com.kusvurmaoyunu.app.OyunEkrani.ekranBuyuklukY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Kursun {
    int x, y;
    Bitmap kursun;
    Kursun(Resources res){
        kursun = BitmapFactory.decodeResource(res, R.drawable.kursun);


        kursun = Bitmap.createScaledBitmap(kursun, 54, 56, false);
    }

    Rect getCarpismaKontrol(){
        return  new Rect(x, y, x+54, y+56);
    }
}
