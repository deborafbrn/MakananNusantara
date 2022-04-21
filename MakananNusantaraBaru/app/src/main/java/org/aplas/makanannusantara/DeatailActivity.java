package org.aplas.makanannusantara;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DeatailActivity extends AppCompatActivity {

    ImageView imageViewFotoMakanan;
    TextView  textViewNamaMakanan, textViewInfoMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatail);

        imageViewFotoMakanan = findViewById(R.id.imageViewFotoMakanan);
        textViewNamaMakanan = findViewById(R.id.textViewNamaMakanan);
        textViewInfoMakanan = findViewById(R.id.textViewInfoMakanan);


        getIncomingExtra();



    }

    private  void getIncomingExtra(){

        if(getIntent().hasExtra("foto_makanan") && getIntent().hasExtra("nama_makanan") && getIntent().hasExtra("info_makanan")){

            String fotomakanan = getIntent().getStringExtra("foto_makanan");
            String namamakanan = getIntent().getStringExtra("nama_makanan");
            String infoMakanan = getIntent().getStringExtra("info_makanan");

            setDataActivity(fotomakanan,namamakanan,infoMakanan);

        }

    }

    private void setDataActivity(String fotomakanan,String namaMakanan, String infomakanan){

        Glide.with(this).asBitmap().load(fotomakanan).into(imageViewFotoMakanan);

        textViewNamaMakanan.setText(namaMakanan);
        textViewInfoMakanan.setText(infomakanan);

    }

}