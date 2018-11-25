package com.example.dell.driverapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Metodo para manejar la ventana pop up
 */
public class Pop extends AppCompatActivity {

    //Atributos
    private RatingBar ratingBar;
    private Button button;

    ///////////////////////////////////////

    /**
     * Metodo para iniciar la ventana
     * @param savedInstanceState instancia
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        getSupportActionBar().hide();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int ancho = dm.widthPixels;
        int alto = dm.heightPixels;
        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setMax(5);
        button  = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Pop.this,"Stars: " + (int) ratingBar.getRating(), Toast.LENGTH_SHORT).show();
                ratingBar.setRating(0);
                finish();
            }
        });
        getWindow().setLayout((int)(ancho*.8),(int) (alto*.4));

    }
}
