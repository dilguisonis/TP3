package edu.ort.ar.juego;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by 41823413 on 12/7/2016.
 */
public class baseTP3SQLiteHelper extends SQLiteOpenHelper {
    public baseTP3SQLiteHelper(Context contexto, String Nombre, SQLiteDatabase.CursorFactory fabrica, int Version)
    {
        super(contexto, Nombre, fabrica, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCrearTablaPersonas;
        sqlCrearTablaPersonas="create table jugadas(usuario text, contador int, jugada text)";
        sqLiteDatabase.execSQL(sqlCrearTablaPersonas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
