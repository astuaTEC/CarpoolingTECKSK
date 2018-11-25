package com.example.dell.driverapp.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.driverapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento3 extends Fragment {

    /**
     * Constructor
     */
    public Fragmento3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragmento2, container, false);

        return rootView;
    }

}
