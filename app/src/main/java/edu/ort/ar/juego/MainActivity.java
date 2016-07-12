package edu.ort.ar.juego;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Jugada j;
    private DrawerLayout drawerLayout;
    private FragmentTabHost tabHost;
    private String userName="";
    private String color="";

    public int puntaje=0;
    public String jugadas=null;
    ListView listVW;

    private TextView navUserName;

    baseTP3SQLiteHelper accesoBaseTP3;
    SQLiteDatabase baseDatos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        listVW = (ListView) findViewById(R.id.listview);

        inicializarToolbar(); // Setear Toolbar como action bar
        inicializarTabs(); // Crear los tabs

    }

    public Jugada getJ() {
        return j;
    }

    public void setJ(Jugada j1) {

        this.j = j1;

        if (baseDeDatosAbierta() == true)
        {
            ContentValues nuevoRegistro;

            nuevoRegistro   =new ContentValues();
            if (j.username == null){
                j.username = "jugador";
            }
            nuevoRegistro.put("Usuario", j.username);
            nuevoRegistro.put("Contador", j.contador);
            nuevoRegistro.put("Jugada", j.jugadas);

            baseDatos.insert("Jugadas", null, nuevoRegistro);
        }
    }



    private void inicializarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        setearListener(navigationView);
        navUserName = (TextView)navigationView.getHeaderView(0).findViewById(R.id.nav_username);

    }

    private void inicializarTabs() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(
                tabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                FirstFragment.class, null);
        tabHost.addTab(
                tabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                SecondFragment.class, null);
    }


    // Listener de los clicks en el drawer
    private void setearListener(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                switch(item.getItemId()) {
                    case R.id.nav_reset:
                        Log.d("Choose:","Camera");
                        tabHost.setCurrentTab(0);
                        break;
                    case R.id.nav_trash:
                        Log.d("Choose:","Gallery");
                        tabHost.setCurrentTab(1);
                        break;
                    case R.id.nav_user:
                        Log.d("Choose:","Send");
                        FragmentManager fm = getSupportFragmentManager();
                        UserNameDialog userNameDialog = new UserNameDialog();
                        userNameDialog.show(fm, "fragment_edit_name");
                        break;
                    case R.id.nav_background:
                        Log.d("Choose:","Send");
                        FragmentManager fmi = getSupportFragmentManager();
                        ColorSelectDialog ColorSelectDialog = new ColorSelectDialog();
                        ColorSelectDialog.show(fmi, "fragment_spinner");
                        break;
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

    }


    // Abre el drawer al clickear el burger
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUserName (String userName) {
        this.userName = userName;  // Setear variable de clase
        navUserName.setText(userName); // Setear el texto en la cabecera del drawer
    }



    public void onItemSelected(int pos) {
        tabHost.getTabContentView().getChildAt(pos).setBackgroundColor(getResources().getColor(R.color.Rojo));
    }

    public String getColor(){return color;}
    public String getUserName() {
        return userName;
    }
    public String getJugadas() {
        return jugadas;
    }
    public int getPuntaje() {
        return puntaje;
    }



    Boolean baseDeDatosAbierta(){
        Boolean responder;
        accesoBaseTP3=new baseTP3SQLiteHelper(this, "baseTP3", null, 1);
        baseDatos=accesoBaseTP3.getWritableDatabase();
        if (baseDatos!= null)
        {
            responder = true;
        }
        else
        {
            responder = true;
        }
        return responder;
    }



}