package com.example.juegogato;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    public Button[][] ArrButtons;
    public int[][] matriz;
    public int cont,realScore;
    public int continuar;
    public TextView TvScore, TvScoreReal;
    public String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        matriz= new int [7][7];
        cont=0;
        realScore=7*7*100;
        continuar = (int)Math.floor(Math.random()*7)+1;
        TextView TvName;
        TvName= findViewById(R.id.TvName);
        TvScore= findViewById(R.id.TvScore);
        TvScoreReal= findViewById(R.id.TvScoreReal);
        Bundle intent= getIntent().getExtras();
        nombre= intent.getString("nombre");
        TvName.setText(nombre);
        ArrButtons= new Button[7][7];
        init();

    }

    @Override
    public void onClick(View v) {
        Button b= (Button)v;
        b.setBackgroundResource(R.drawable.circulo);
        switch (b.getId()){
            case R.id.button00:
                matriz[0][0]=1;
                break;
            case R.id.button01:
                matriz[0][1]=1;
                break;
            case R.id.button02:
                matriz[0][2]=1;
                break;
            case R.id.button03:
                matriz[0][3]=1;
                break;
            case R.id.button04:
                matriz[0][4]=1;
                break;
            case R.id.button05:
                matriz[0][5]=1;
                break;
            case R.id.button06:
                matriz[0][6]=1;
                break;
            case R.id.button10:
                matriz[1][0]=1;
                break;
            case R.id.button11:
                matriz[1][1]=1;
                break;
            case R.id.button12:
                matriz[1][2]=1;
                break;
            case R.id.button13:
                matriz[1][3]=1;
                break;
            case R.id.button14:
                matriz[1][4]=1;
                break;
            case R.id.button15:
                matriz[1][5]=1;
                break;
            case R.id.button16:
                matriz[1][6]=1;
                break;
            case R.id.button20:
                matriz[2][0]=1;
                break;
            case R.id.button21:
                matriz[2][1]=1;
                break;
            case R.id.button22:
                matriz[2][2]=1;
                break;
            case R.id.button23:
                matriz[2][3]=1;
                break;
            case R.id.button24:
                matriz[2][4]=1;
                break;
            case R.id.button25:
                matriz[2][5]=1;
                break;
            case R.id.button26:
                matriz[2][6]=1;
                break;
            case R.id.button30:
                matriz[3][0]=1;
                break;
            case R.id.button31:
                matriz[3][1]=1;
                break;
            case R.id.button32:
                matriz[3][2]=1;
                break;
            case R.id.button33:
                matriz[3][3]=1;
                break;
            case R.id.button34:
                matriz[3][4]=1;
                break;
            case R.id.button35:
                matriz[3][5]=1;
                break;
            case R.id.button36:
                matriz[3][6]=1;
                break;
            case R.id.button40:
                matriz[4][0]=1;
                break;
            case R.id.button41:
                matriz[4][1]=1;
                break;
            case R.id.button42:
                matriz[4][2]=1;
                break;
            case R.id.button43:
                matriz[4][3]=1;
                break;
            case R.id.button44:
                matriz[4][4]=1;
                break;
            case R.id.button45:
                matriz[4][5]=1;
                break;
            case R.id.button46:
                matriz[4][6]=1;
                break;
            case R.id.button50:
                matriz[5][0]=1;
                break;
            case R.id.button51:
                matriz[5][1]=1;
                break;
            case R.id.button52:
                matriz[5][2]=1;
                break;
            case R.id.button53:
                matriz[5][3]=1;
                break;
            case R.id.button54:
                matriz[5][4]=1;
                break;
            case R.id.button55:
                matriz[5][5]=1;
                break;
            case R.id.button56:
                matriz[5][6]=1;
                break;
            case R.id.button60:
                matriz[6][0]=1;
                break;
            case R.id.button61:
                matriz[6][1]=1;
                break;
            case R.id.button62:
                matriz[6][2]=1;
                break;
            case R.id.button63:
                matriz[6][3]=1;
                break;
            case R.id.button64:
                matriz[6][4]=1;
                break;
            case R.id.button65:
                matriz[6][5]=1;
                break;
            case R.id.button66:
                matriz[6][6]=1;
                break;
        }
        b.setEnabled(false);
        continuar= MovGato(continuar);
        if(continuar==0){
            GatoWin();
            recreate();
        }
        if(continuar==10){
            GatoLose();
            recreate();
        }
        if(continuar!=0 && continuar !=10){
            cont++;
            realScore-=100;
        }
        TvScore.setText(String.valueOf(cont));
        TvScoreReal.setText(String.valueOf(realScore));
    }
    public int MovGato(int dir){
        do{
            for(int i=0;i<7;i++){
                for(int j=0;j<7;j++){
                    if(matriz[i][j]==2){
                        if(i==0||j==0||i==6||j==6){
                            return 0;
                        }else{
                            if(matriz[i][j+1]==1&&matriz[i-1][j+1]==1&&matriz[i-1][j]==1&&matriz[i-1][j-1]==1&&matriz[i][j-1]==1&&matriz[i+1][j-1]==1&&matriz[i+1][j]==1&&matriz[i+1][j+1]==1){
                                return 10;
                            }
                        }
                        if(matriz[i][j+1]==0 && dir==1){//derecha
                            matriz[i][j+1]=2;
                            matriz[i][j]=0;
                            ArrButtons[i][j+1].setBackgroundResource(R.drawable.gato);
                            ArrButtons[i][j+1].setEnabled(false);
                            ArrButtons[i][j].setBackgroundResource(android.R.drawable.btn_default);
                            ArrButtons[i][j].setEnabled(true);
                            return 1;

                        }else if(matriz[i-1][j+1]==0 && dir==2){//diagonalderechasuperior
                            matriz[i-1][j+1]=2;
                            matriz[i][j]=0;
                            ArrButtons[i-1][j+1].setBackgroundResource(R.drawable.gato);
                            ArrButtons[i-1][j+1].setEnabled(false);
                            ArrButtons[i][j].setBackgroundResource(android.R.drawable.btn_default);
                            ArrButtons[i][j].setEnabled(true);
                            return 2;

                        }else if(matriz[i-1][j]==0 && dir==3){//arriba
                            matriz[i-1][j]=2;
                            matriz[i][j]=0;
                            ArrButtons[i-1][j].setBackgroundResource(R.drawable.gato);
                            ArrButtons[i-1][j].setEnabled(false);
                            ArrButtons[i][j].setBackgroundResource(android.R.drawable.btn_default);
                            ArrButtons[i][j].setEnabled(true);
                            return 3;

                        }else if(matriz[i-1][j-1]==0 && dir==4){//diagonalsuperiorizquierda
                            matriz[i-1][j-1]=2;
                            matriz[i][j]=0;
                            ArrButtons[i-1][j-1].setBackgroundResource(R.drawable.gato);
                            ArrButtons[i-1][j-1].setEnabled(false);
                            ArrButtons[i][j].setBackgroundResource(android.R.drawable.btn_default);
                            ArrButtons[i][j].setEnabled(true);
                            return 4;

                        }else if(matriz[i][j-1]==0 && dir==5){//izquierda
                            matriz[i][j-1]=2;
                            matriz[i][j]=0;
                            ArrButtons[i][j-1].setBackgroundResource(R.drawable.gato);
                            ArrButtons[i][j-1].setEnabled(false);
                            ArrButtons[i][j].setBackgroundResource(android.R.drawable.btn_default);
                            ArrButtons[i][j].setEnabled(true);
                            return 5;

                        }else if(matriz[i+1][j-1]==0 && dir==6){//diagonalinferiorizquierda
                            matriz[i+1][j-1]=2;
                            matriz[i][j]=0;
                            ArrButtons[i+1][j-1].setBackgroundResource(R.drawable.gato);
                            ArrButtons[i+1][j-1].setEnabled(false);
                            ArrButtons[i][j].setBackgroundResource(android.R.drawable.btn_default);
                            ArrButtons[i][j].setEnabled(true);
                            return 6;

                        }else if(matriz[i+1][j]==0 && dir==7){//abajo
                            matriz[i+1][j]=2;
                            matriz[i][j]=0;
                            ArrButtons[i+1][j].setBackgroundResource(R.drawable.gato);
                            ArrButtons[i+1][j].setEnabled(false);
                            ArrButtons[i][j].setBackgroundResource(android.R.drawable.btn_default);
                            ArrButtons[i][j].setEnabled(true);
                            return 7;

                        }else if(matriz[i+1][j+1]==0 && dir==8){//diagonalinferiorderecha
                            matriz[i+1][j+1]=2;
                            matriz[i][j]=0;
                            ArrButtons[i+1][j+1].setBackgroundResource(R.drawable.gato);
                            ArrButtons[i+1][j+1].setEnabled(false);
                            ArrButtons[i][j].setBackgroundResource(android.R.drawable.btn_default);
                            ArrButtons[i][j].setEnabled(true);
                            return 8;
                        }
                        if(dir>=8){
                            dir=1;
                        }else{
                            dir++;
                        }

                    }

                }

            }
        }while(true);
    }
    public void GatoWin(){
        Toast.makeText(this, "El Gato Gano", Toast.LENGTH_SHORT).show();
    }
    public void GatoLose(){
        Toast.makeText(this, "Has Ganado, Felicitaciones! con: "+String.valueOf(realScore), Toast.LENGTH_SHORT).show();
        actualizar_puntaje(nombre,realScore);

    }
    public void init(){
        ArrButtons[0][0]=(Button)findViewById(R.id.button00);
        ArrButtons[0][1]=(Button)findViewById(R.id.button01);
        ArrButtons[0][2]=(Button)findViewById(R.id.button02);
        ArrButtons[0][3]=(Button)findViewById(R.id.button03);
        ArrButtons[0][4]=(Button)findViewById(R.id.button04);
        ArrButtons[0][5]=(Button)findViewById(R.id.button05);
        ArrButtons[0][6]=(Button)findViewById(R.id.button06);
        ArrButtons[1][0]=(Button)findViewById(R.id.button10);
        ArrButtons[1][1]=(Button)findViewById(R.id.button11);
        ArrButtons[1][2]=(Button)findViewById(R.id.button12);
        ArrButtons[1][3]=(Button)findViewById(R.id.button13);
        ArrButtons[1][4]=(Button)findViewById(R.id.button14);
        ArrButtons[1][5]=(Button)findViewById(R.id.button15);
        ArrButtons[1][6]=(Button)findViewById(R.id.button16);
        ArrButtons[2][0]=(Button)findViewById(R.id.button20);
        ArrButtons[2][1]=(Button)findViewById(R.id.button21);
        ArrButtons[2][2]=(Button)findViewById(R.id.button22);
        ArrButtons[2][3]=(Button)findViewById(R.id.button23);
        ArrButtons[2][4]=(Button)findViewById(R.id.button24);
        ArrButtons[2][5]=(Button)findViewById(R.id.button25);
        ArrButtons[2][6]=(Button)findViewById(R.id.button26);
        ArrButtons[3][0]=(Button)findViewById(R.id.button30);
        ArrButtons[3][1]=(Button)findViewById(R.id.button31);
        ArrButtons[3][2]=(Button)findViewById(R.id.button32);
        ArrButtons[3][3]=(Button)findViewById(R.id.button33);
        ArrButtons[3][3].setEnabled(false);
        ArrButtons[3][4]=(Button)findViewById(R.id.button34);
        ArrButtons[3][5]=(Button)findViewById(R.id.button35);
        ArrButtons[3][6]=(Button)findViewById(R.id.button36);
        ArrButtons[4][0]=(Button)findViewById(R.id.button40);
        ArrButtons[4][1]=(Button)findViewById(R.id.button41);
        ArrButtons[4][2]=(Button)findViewById(R.id.button42);
        ArrButtons[4][3]=(Button)findViewById(R.id.button43);
        ArrButtons[4][4]=(Button)findViewById(R.id.button44);
        ArrButtons[4][5]=(Button)findViewById(R.id.button45);
        ArrButtons[4][6]=(Button)findViewById(R.id.button46);
        ArrButtons[5][0]=(Button)findViewById(R.id.button50);
        ArrButtons[5][1]=(Button)findViewById(R.id.button51);
        ArrButtons[5][2]=(Button)findViewById(R.id.button52);
        ArrButtons[5][3]=(Button)findViewById(R.id.button53);
        ArrButtons[5][4]=(Button)findViewById(R.id.button54);
        ArrButtons[5][5]=(Button)findViewById(R.id.button55);
        ArrButtons[5][6]=(Button)findViewById(R.id.button56);
        ArrButtons[6][0]=(Button)findViewById(R.id.button60);
        ArrButtons[6][1]=(Button)findViewById(R.id.button61);
        ArrButtons[6][2]=(Button)findViewById(R.id.button62);
        ArrButtons[6][3]=(Button)findViewById(R.id.button63);
        ArrButtons[6][4]=(Button)findViewById(R.id.button64);
        ArrButtons[6][5]=(Button)findViewById(R.id.button65);
        ArrButtons[6][6]=(Button)findViewById(R.id.button66);
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                    matriz[i][j]=0;

            }
        }
        matriz[3][3]=2;
        int rand = 6;
        int [] x = new int[rand];
        int [] y = new int[rand];
        for(int i=0;i<rand;i++){
            do{
                x[i]= (int )Math.floor(Math.random()*6);
                y[i]= (int )Math.floor(Math.random()*6);
            }while(x[i]==3 && y[i]==3);
        }

        for(int i=0;i<rand;i++){
            matriz[x[i]][y[i]]=1;
            ArrButtons[x[i]][y[i]].setBackgroundResource(R.drawable.circulo);
            ArrButtons[x[i]][y[i]].setEnabled(false);
        }

        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                ArrButtons[i][j].setOnClickListener(this);
            }
        }
    }

    public void actualizar_puntaje(String nombre, int realScore){
        SharedPreferences shpref=getSharedPreferences("Puntaje",Context.MODE_PRIVATE);
        if(realScore>shpref.getInt("score",0)){
            SharedPreferences.Editor editor = shpref.edit();
            editor.putString("name",nombre);
            editor.putInt("score",realScore);
            editor.commit();
        }


    }

}