package com.example.juegogato;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class iniciarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);
    }


    public void evento_game(View view) {
        Toast.makeText(iniciarActivity.this,"abriendo",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(iniciarActivity.this,GameActivity.class);
        EditText name;
        name= findViewById(R.id.txt_name);
        String nombre=name.getText().toString();
        intent.putExtra("nombre",nombre);
        startActivity(intent);

    }
}
