package com.example.dell.studentapp.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.dell.studentapp.R;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento4 extends Fragment {

    //Atributos
    Switch aSwitch;
    Switch aSwitch2;
    Switch aSwitch3;
    /////////////////////////////////////

    /**
     * Constructor
     */
    public Fragmento4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragmento4, container, false);
        aSwitch = rootView.findViewById(R.id.switch1);
        aSwitch2 = rootView.findViewById(R.id.switch2);
        aSwitch3 = rootView.findViewById(R.id.switch3);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "Encendido",Toast.LENGTH_SHORT).show();
                    getActivity().getIntent().putExtra("car",isChecked);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Apagado" ,Toast.LENGTH_SHORT).show();
                    getActivity().getIntent().putExtra("car","");
                }
            }
        });
        aSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "Encendido",Toast.LENGTH_SHORT).show();
                    getActivity().getIntent().putExtra("xmi",isChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Apagado" ,Toast.LENGTH_SHORT).show();
                }
            }
        });

        aSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "Encendido",Toast.LENGTH_SHORT).show();
                    getActivity().getIntent().putExtra("amigo",isChecked);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Apagado" ,Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }

}
