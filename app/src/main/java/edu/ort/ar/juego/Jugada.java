package edu.ort.ar.juego;

/**
 * Created by 41823413 on 28/6/2016.
 */
public class Jugada {
    public String username = "";
    public String jugadas = "";
    public int contador = 0;

    public Jugada(String username,String jugadas, int contador)
    {   this.username = username;
        this.jugadas = jugadas;
        this.contador= contador;
    }

}
