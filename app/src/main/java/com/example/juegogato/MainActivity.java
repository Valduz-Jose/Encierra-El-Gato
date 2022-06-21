package com.example.juegogato;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evento_cerrar(View view) {
        finishAffinity();
    }

    public void evento_jugar(View view) {
        //nombre de jugador


        Intent intent = new Intent(MainActivity.this,iniciarActivity.class);
        startActivity(intent);

    }

    public void evento_puntajes(View view) {
        //implementacion de los mejores puntajes
        SharedPreferences shpref=getSharedPreferences("Puntaje", Context.MODE_PRIVATE);
        int puntaje= shpref.getInt("score",0);
        String nombre= shpref.getString("name","no hay!");
        String show= nombre+" con "+String.valueOf(puntaje);
        Toast.makeText(MainActivity.this,"mejor puntaje: "+show,Toast.LENGTH_SHORT).show();

    }
}