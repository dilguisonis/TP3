package edu.ort.ar.juego;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class FirstFragment extends Fragment implements View.OnClickListener {

    CustomButton button1;
    CustomButton button2;
    CustomButton button3;
    CustomButton button4;
    CustomButton button5;
    CustomButton button6;
    CustomButton button7;
    CustomButton button8;
    CustomButton button9;
    View v;
    Jugada j;
    ArrayList<Jugada> ArrayJugadas;






    String user;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true); // to show actionbar icon calling onCreateOptionsMenu
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.activity_first_fragment, container, false);

        button1 = (CustomButton) v.findViewById(R.id.imageButton1);
        button2 = (CustomButton) v.findViewById(R.id.imageButton2);
        button3 = (CustomButton) v.findViewById(R.id.imageButton3);
        button4 = (CustomButton) v.findViewById(R.id.imageButton4);
        button5 = (CustomButton) v.findViewById(R.id.imageButton5);
        button6 = (CustomButton) v.findViewById(R.id.imageButton6);
        button7 = (CustomButton) v.findViewById(R.id.imageButton7);
        button8 = (CustomButton) v.findViewById(R.id.imageButton8);
        button9 = (CustomButton) v.findViewById(R.id.imageButton9);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        ArrayJugadas = new ArrayList<>();

        j = new Jugada("","",0);
        return v;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.first, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_reset:
                j = new Jugada("", "", 0);
                button1.reset();button2.reset();button3.reset();button4.reset();button5.reset();button6.reset();button7.reset();button8.reset();button9.reset();
                break;
        }
        return true;
    }


    @Override
    public void onClick(View view) {
        j.contador++;
        switch (view.getId()) {
            case R.id.imageButton1:
               button1.flip();
               button2.flip();
               button4.flip();
                j.jugadas += "1, ";
                break;
            case R.id.imageButton2:
                button1.flip();
                button2.flip();
                button3.flip();
                button5.flip();
                j.jugadas += "2, ";
                break;
            case R.id.imageButton3:
                button2.flip();
                button3.flip();
                button6.flip();
                j.jugadas+= "3, ";
                break;
            case R.id.imageButton4:
                button1.flip();
                button7.flip();
                button4.flip();
                button5.flip();
                j.jugadas+= "4, ";
                break;
            case R.id.imageButton5:
                button4.flip();
                button2.flip();
                button6.flip();
                button5.flip();
                button8.flip();
                j.jugadas+= "5, ";
                break;
            case R.id.imageButton6:
                button3.flip();
                button5.flip();
                button6.flip();
                button9.flip();
                j.jugadas+= "6, ";
                break;
            case R.id.imageButton7:
                button4.flip();
                button7.flip();
                button8.flip();
                j.jugadas+= "7, ";
                break;
            case R.id.imageButton8:
                button8.flip();
                button5.flip();
                button7.flip();
                button9.flip();
                j.jugadas+= "8, ";
                break;
            case R.id.imageButton9:
                button8.flip();
                button6.flip();
                button9.flip();
                j.jugadas+= "9, ";
                break;
        }

        //hola
        if (button1.lolazo == true && button2.lolazo == true && button3.lolazo == true && button4.lolazo == true && button5.lolazo == true && button6.lolazo == true && button7.lolazo == true && button8.lolazo == true && button9.lolazo == true)
        {
            MainActivity ma = (MainActivity)getActivity();
            user= ma.getUserName();
            j.username = user.toString();
            ma.setJ(j);
            Toast.makeText(getActivity(), "ganaste "+ user + " - " + j.jugadas + " - " + j.contador, Toast.LENGTH_SHORT).show();

            j = new Jugada("", "", 0);

            button1.reset();
            button2.reset();
            button3.reset();
            button4.reset();
            button5.reset();
            button6.reset();
            button7.reset();
            button8.reset();
            button9.reset();

        }
        if (button1.lolazo == false && button2.lolazo == false && button3.lolazo == false && button4.lolazo == false && button5.lolazo == false && button6.lolazo == false && button7.lolazo == false && button8.lolazo == false && button9.lolazo == false)
        {
            MainActivity ma = (MainActivity)getActivity();
            user= ma.getUserName();
            j.username = user.toString();
            ma.setJ(j);
            Toast.makeText(getActivity(),"ganaste "+ user + " - " + j.jugadas + " - " + j.contador, Toast.LENGTH_LONG).show();
            j = new Jugada("", "", 0);

            button1.reset();
            button2.reset();
            button3.reset();
            button4.reset();
            button5.reset();
            button6.reset();
            button7.reset();
            button8.reset();
            button9.reset();
        }

    }


}