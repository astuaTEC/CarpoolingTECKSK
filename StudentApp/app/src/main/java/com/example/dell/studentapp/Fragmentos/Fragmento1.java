package com.example.dell.studentapp.Fragmentos;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.example.dell.studentapp.Adaptador;
import com.example.dell.studentapp.Contactos;
import com.example.dell.studentapp.R;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento1 extends Fragment {

    //Atributos
    ListView lista;
    ArrayList<Contactos>  contactos = new ArrayList<>();
    ///////////////////////////////////////////////////////////////

    /**
     * Constructor
     */
    // Required empty public constructor
        public Fragmento1() {
            // Exists only to defeat instantiation.
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contactos.clear();

        readObject();

        View rootView = inflater.inflate(R.layout.fragment_fragmento3, container, false);
        lista  = rootView.findViewById(R.id.lista);
        lista.setAdapter(new Adaptador(this.getContext(), contactos));

        return rootView;
    }

    /**
     * Metodo para leer los datos que hay en la API
     * Crea objetos tipo Contactos
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
                Contactos contacto = new Contactos();
                contacto.setCalificacion("4.5");
                contacto.setCarnet(result.get("Carnet").toString());
                contacto.setNombre("Amigo");
                contactos.add(contacto);
            }
        } catch (ParseException e) {

        }
    }

}
