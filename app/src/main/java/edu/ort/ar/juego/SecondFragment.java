package edu.ort.ar.juego;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class SecondFragment extends Fragment {

    Jugada j;
    View v;
    ListView listVW;
    ArrayList<Jugada> ArrayJugadas;
    Cursor conjuntoDeRegistros;
    String usuario;
    Integer contador;
    String jugada;
    JugadaAdapter adapter;

    private TextView Hola;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayJugadas = new ArrayList<Jugada>();

        j = new Jugada("","",0);
        MainActivity ma = (MainActivity)getActivity();

        conjuntoDeRegistros=ma.baseDatos.rawQuery("SELECT usuario, contador, jugada FROM jugadas", null);
        if (conjuntoDeRegistros.moveToFirst() == true)
        {
            do { //
                usuario = conjuntoDeRegistros.getString(0);
                contador = conjuntoDeRegistros.getInt(1);
                jugada = conjuntoDeRegistros.getString(2);
                if (usuario == "")
                {usuario = "jugador";}
                //j.username = usuario;
                j.contador = contador;
                j.jugadas = jugada;
                ArrayJugadas.add(j);
                j = new Jugada("", "", 0);
            }   while(conjuntoDeRegistros.moveToNext() == true);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true); // to show actionbar icon calling onCreateOptionsMenu
        // Inflate the layout for this fragment


        v= inflater.inflate(R.layout.activity_second_fragment, container, false);

        MainActivity ma = (MainActivity)getActivity();
        listVW = (ListView) v.findViewById(R.id.listview);
        j = ma.getJ();
        ArrayJugadas.add(j);
         adapter = new JugadaAdapter(getContext(), ArrayJugadas);
        listVW.setAdapter(adapter);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.second,menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_trash:
                MainActivity ma = (MainActivity)getActivity();
               if (ma.baseDeDatosAbierta() == true)
               {
                   ma.baseDatos.delete("Jugadas", "", null);
                   ArrayJugadas.clear();
                   adapter.notifyDataSetChanged();
               }
                break;
        }
        return true;
    }

}