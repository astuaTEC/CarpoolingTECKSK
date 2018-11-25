package com.example.dell.driverapp.Fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.driverapp.Adaptador;
import com.example.dell.driverapp.Driver;
import com.example.dell.driverapp.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento2 extends Fragment {

    //Atributos
    Button scaner;
    TextView codigo;
    Button agregar;
    Button amigo;
    String resultado;
//////////////////////////////////////////////

    /**
     * Constructor
     */
    public Fragmento2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragmento1, container, false);
        scaner = rootView.findViewById(R.id.escaneo);
        codigo = rootView.findViewById(R.id.textView6);
        agregar = rootView.findViewById(R.id.registro);
        amigo = rootView.findViewById(R.id.amigos);

        scaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Escanear();
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultado != "") {
                    getActivity().getIntent().putExtra("info",resultado);
                    resultado = "";
                    codigo.setText("");
                    Toast.makeText(getContext(),"Carnet Agregado",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Escanea un Código",Toast.LENGTH_LONG).show();
                }

            }
        });
        amigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultado != "") {
                    createObject(resultado);
                    resultado = "";
                    codigo.setText("");
                    Toast.makeText(getContext(),"Amigo agregado",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Escanea un Código",Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootView;
    }

    /**
     * Metodo para escanear los codigos de barra
      */
    public void Escanear(){

        IntentIntegrator intent = IntentIntegrator.forSupportFragment(this);
        intent.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);

        intent.setPrompt("Escanear Codigo");
        intent.setCameraId(0);
        intent.setBeepEnabled(false);
        intent.setBarcodeImageEnabled(false);
        intent.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(result != null){
            if(result.getContents() == null){
                codigo.setText(result.getContents());
                Toast.makeText(getContext(),"Cancelaste el escaneo",Toast.LENGTH_LONG).show();
            }
            else{
                codigo.setText(result.getContents());
                resultado = result.getContents();

            }
        }
        else{
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    /**
     * Metodo para agregar un amigo y guardarlo en la API
     * @param carnet el carnet
     */
    public void createObject( String carnet) {
        ParseObject entity = new ParseObject("Persona");

        entity.put("Carnet", carnet);

        // Saves the new object.
        // Notice that the SaveCallback is totally optional!
        entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                // Here you can handle errors, if thrown. Otherwise, "e" should be null
            }
        });
    }

}
