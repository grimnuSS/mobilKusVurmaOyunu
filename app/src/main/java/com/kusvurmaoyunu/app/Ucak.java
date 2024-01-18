package com.kusvurmaoyunu.app;

import static com.kusvurmaoyunu.app.OyunEkrani.ekranBuyuklukX;
import static com.kusvurmaoyunu.app.OyunEkrani.ekranBuyuklukY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Ucak {

    public boolean yukariGit = false;
    int atesEt = 0;
    int x, y, genislik, yukseklik, kanatHareketi = 0, atesSay = 1;
    Bitmap ucak1, ucak2, ucakAtes1, ucakAtes2, ucakAtes3, ucakAtes4, ucakAtes5, kaza;
    private OyunEkrani oyunEkrani;

    Ucak (OyunEkrani oyunEkrani, int ekranY, Resources res){

        this.oyunEkrani = oyunEkrani;

        ucak1 = BitmapFactory.decodeResource(res, R.drawable.ucak1);
        ucak2 = BitmapFactory.decodeResource(res, R.drawable.ucak2);

        genislik *= (int) ekranBuyuklukX;
        yukseklik *= (int) ekranBuyuklukY;

        ucak1 = Bitmap.createScaledBitmap(ucak1, 240, 180, false);
        ucak2 = Bitmap.createScaledBitmap(ucak2, 240, 180, false);

        ucakAtes1 = BitmapFactory.decodeResource(res, R.drawable.ucakates1);
        ucakAtes2 = BitmapFactory.decodeResource(res, R.drawable.ucakates2);
        ucakAtes3 = BitmapFactory.decodeResource(res, R.drawable.ucakates3);
        ucakAtes4 = BitmapFactory.decodeResource(res, R.drawable.ucakates4);
        ucakAtes5 = BitmapFactory.decodeResource(res, R.drawable.ucakates5);

        ucakAtes1 = Bitmap.createScaledBitmap(ucakAtes1, 240, 180, false);
        ucakAtes2 = Bitmap.createScaledBitmap(ucakAtes2, 240, 180, false);
        ucakAtes3 = Bitmap.createScaledBitmap(ucakAtes3, 240, 180, false);
        ucakAtes4 = Bitmap.createScaledBitmap(ucakAtes4, 240, 180, false);
        ucakAtes5 = Bitmap.createScaledBitmap(ucakAtes5, 240, 180, false);

        kaza = BitmapFactory.decodeResource(res, R.drawable.kaza);
        kaza = Bitmap.createScaledBitmap(kaza, 240, 180, false);

        y = ekranY / 2;
        x = (int) (64 * ekranBuyuklukX);
    }

    Bitmap getUcak(){
        if (atesEt != 0) {
            if (atesSay == 1){
                atesSay++;
                return ucakAtes1;
            }
            if (atesSay == 2){
                atesSay++;
                return ucakAtes1;
            }
            if (atesSay == 3){
                atesSay++;
                return ucakAtes1;
            }
            if (atesSay == 4){
                atesSay++;
                return ucakAtes1;
            }
            atesSay = 5;
            atesEt--;
            oyunEkrani.Kursun();

        }
        if(kanatHareketi == 0){
            kanatHareketi++;
            return ucak1;
        }
        kanatHareketi--;
        return ucak2;
    }
    Rect getCarpismaKontrol(){
        return  new Rect(x, y, x+240, y+180);
    }
    Bitmap getKaza(){
        return kaza;
    }
}
