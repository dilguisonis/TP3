package edu.ort.ar.juego;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

    private TextView Hola;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true); // to show actionbar icon calling onCreateOptionsMenu
        // Inflate the layout for this fragment

        ArrayJugadas = new ArrayList<Jugada>();
        v= inflater.inflate(R.layout.activity_second_fragment, container, false);
        MainActivity ma = (MainActivity)getActivity();
        listVW = (ListView) v.findViewById(R.id.listview);
        j = ma.getJ();
        ArrayJugadas.add(j);
        JugadaAdapter adapter = new JugadaAdapter(getContext(), ArrayJugadas);
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
                Log.d("gallery", "ison");
                break;
        }
        return true;
    }

}