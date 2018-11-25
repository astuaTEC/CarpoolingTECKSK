package com.example.dell.studentapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

/**
 * Clase para probar la API
 */
public class Back4app extends AppCompatActivity {

    //Atributos
    Button enviar;
    Button recibir;
    /////////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba_api);
        enviar = findViewById(R.id.button3);
        recibir = findViewById(R.id.button4);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createObject();
            }
        });
        recibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readObject();
            }
        });

    }

    /**
     * Metodo para crear y guardar un objeto en la API
     */
    public void createObject() {
        ParseObject entity = new ParseObject("Persona");

        entity.put("Carnet", "2018143188");
        entity.put("Longitud", "1.9985547");
        entity.put("Latitud", "2.6564944");

        // Saves the new object.
        // Notice that the SaveCallback is totally optional!
        entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                // Here you can handle errors, if thrown. Otherwise, "e" should be null
            }
        });
    }

    /**
     * Metodo para leer los objetos contenidos en la API
     */
    public void readObject() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Persona");

        // The query will search for a ParseObject, given its objectId.
        // When the query finishes running, it will invoke the GetCallback
        // with either the object, or the exception thrown
        try {
            List<ParseObject> results = query.find();
            for (ParseObject result : results) {
                System.out.println("Likes " + result.get("Carnet").toString());
                Toast.makeText(getApplicationContext(),result.get("Carnet").toString(),Toast.LENGTH_SHORT).show();

            }
        } catch (ParseException e) {

        }
    }
}
