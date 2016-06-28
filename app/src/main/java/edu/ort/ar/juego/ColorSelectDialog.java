package edu.ort.ar.juego;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Leandro on 6/9/2016.
 */
public class ColorSelectDialog extends DialogFragment {
    Spinner categoriaCp;


    public ColorSelectDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_select_dialog, container);

        final MainActivity mainActivity  = (MainActivity) getActivity(); // Politicamente incorrecto

        categoriaCp = (Spinner) view.findViewById(R.id.spinner);

        final ArrayList<String> Colores = new ArrayList<>();
        Colores.add("Electronica");
        Colores.add("Calzado");
        Colores.add("Hogar");
        Colores.add("Automoviles");
        final ArrayAdapter<String> categAdapter;
        categAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,Colores);
        categAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        categoriaCp.setAdapter(categAdapter);

        Button b = (Button) view.findViewById(R.id.confirmar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click","OK");

                int color = categoriaCp.getSelectedItemPosition();
                String colorloco = categoriaCp.getSelectedItem().toString();
                mainActivity.onItemSelected(color);
               // mainActivity.getColor(colorloco);
                dismiss();
            }
        });
        getDialog().setTitle("Ingrese nombre de usuario");

        return view;
    }

}