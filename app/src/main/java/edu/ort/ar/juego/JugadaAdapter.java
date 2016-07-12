package edu.ort.ar.juego;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 41823413 on 5/7/2016.
 */
public class JugadaAdapter extends BaseAdapter {

    ArrayList<Jugada> ArrayJugadas;
    Context context;

    public JugadaAdapter(Context context, ArrayList<Jugada> ArrayJugadas) {
        this.context = context;
        this.ArrayJugadas=ArrayJugadas;
    }

    @Override
    public int getCount() {
        return ArrayJugadas.size();
    }

    @Override
    public Object getItem(int i) {
        return ArrayJugadas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, viewGroup, false);


        }

        TextView TVJugadas = (TextView)view.findViewById(R.id.jugadas);
        TextView TVUsername = (TextView)view.findViewById(R.id.username);
        TextView TVContador = (TextView)view.findViewById(R.id.contador);
        Jugada j = ArrayJugadas.get(position);
        TVJugadas.setText(j.jugadas);
        TVUsername.setText(j.username);
        TVContador.setText(String.valueOf(j.contador));




        return view;
    }
}