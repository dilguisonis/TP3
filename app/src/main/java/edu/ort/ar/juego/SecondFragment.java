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
import android.widget.TextView;

import org.w3c.dom.Text;


public class SecondFragment extends Fragment {

    Jugada j;
    View v;

    private TextView Hola;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true); // to show actionbar icon calling onCreateOptionsMenu
        // Inflate the layout for this fragment



        v= inflater.inflate(R.layout.activity_second_fragment, container, false);

        MainActivity ma = (MainActivity)getActivity();
        ma.setJ(j);
        Hola = (TextView)v.findViewById(R.id.lolazo);
        Hola.setText(j.jugadas);


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