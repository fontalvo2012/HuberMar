package com.example.jhosely.hubermar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Form2Activity extends AppCompatActivity {
    private Button basicos,espesifica,filtro,generar,listo1;
    private TextView nombreUser,perfil;
    private Spinner sucursal,terceros,reporte,importador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

        basicos=findViewById(R.id.basicos);
        espesifica=findViewById(R.id.espesifica);
        filtro=findViewById(R.id.filtro);
        generar=findViewById(R.id.generar);

        nombreUser=findViewById(R.id.nombreUser);
        perfil=findViewById(R.id.perfil);

        nombreUser.setText(Global.nombre);
        perfil.setText(Global.perfil);

        //Spinner
            sucursal=findViewById(R.id.sucursal);
            terceros=findViewById(R.id.terceros);
            reporte=findViewById(R.id.reporte);
            listo1=findViewById(R.id.listo1);
            importador=findViewById(R.id.importador);
        // Fin Spinner
            sucursal.setSelection(Global.posSucursal);
            terceros.setSelection(Global.posTercero);
            reporte.setSelection(Global.posReporte);
            importador.setSelection(Global.posImportador);
        //


        terceros.setAdapter(SpinnerJson.comboAdapter);



        listo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Form2Activity.this,"Parametros Fijados",Toast.LENGTH_SHORT).show();
                Global.tercero=terceros.getSelectedItem()+" ";
                Global.posTercero=terceros.getSelectedItemPosition();
                Global.setImportador(importador.getSelectedItem()+"");
                Global.posImportador=importador.getSelectedItemPosition();
                Global.setSucursal(sucursal.getSelectedItem()+"");
                Global.posSucursal=sucursal.getSelectedItemPosition();
                Global.setReporte(reporte.getSelectedItem()+"");
                Global.posReporte=reporte.getSelectedItemPosition();
                Intent Form3=new Intent(getApplicationContext(),Form3Activity.class);
                startActivity(Form3);
            }
        });



        basicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form1=new Intent(getApplicationContext(),Form1Activity.class);
                startActivity(Form1);
            }
        });

        espesifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form3=new Intent(getApplicationContext(),Form3Activity.class);
                startActivity(Form3);
            }
        });

        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form4=new Intent(getApplicationContext(),Form4Activity.class);
                startActivity(Form4);
            }
        });
        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form5=new Intent(getApplicationContext(),Form5Activity.class);
                startActivity(Form5);
            }
        });
    }
}
