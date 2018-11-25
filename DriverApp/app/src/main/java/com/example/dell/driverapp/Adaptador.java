package com.example.dell.driverapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Clase encargada de ofrecer un adaptador de una interfaz a otra
 */
public class Adaptador extends BaseAdapter{

    //Atributos
    private static LayoutInflater inflater = null;
    Context contexto;
    ArrayList<Contactos> contactos = new ArrayList<>();

///////////////////////////////////////////////////////////////////////////

   public Adaptador(Context contexto, ArrayList<Contactos> contactos){
        this.contexto = contexto;
        this.contactos = contactos;

       inflater = LayoutInflater.from(contexto);


   }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista,null);
        TextView nombre = vista.findViewById(R.id.nombre);
        TextView estado = vista.findViewById(R.id.estado);
        TextView calificacion  = vista.findViewById(R.id.calificacion);
        final ImageView imagen = vista.findViewById(R.id.imagen1);

        nombre.setText(contactos.get(i).getCarnet());
        estado.setText(contactos.get(i).getNombre());
       calificacion.setText(contactos.get(i).getCalificacion());

        return vista;
    }

    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
