package com.example.jhosely.hubermar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Form5Activity extends AppCompatActivity {
    private Button basicos,espesifica,filtro,generar,mostrar;
    private TextView nombreUser,perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form5);

        basicos=findViewById(R.id.basicos);
        espesifica=findViewById(R.id.espesifica);
        filtro=findViewById(R.id.filtro);
        generar=findViewById(R.id.generar);
        mostrar=findViewById(R.id.mostrar);

        nombreUser=findViewById(R.id.nombreUser);
        perfil=findViewById(R.id.perfil);

        nombreUser.setText(Global.nombre);
        perfil.setText(Global.perfil);

        basicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form2=new Intent(getApplicationContext(),Form2Activity.class);
                startActivity(Form2);
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
                Intent Form1=new Intent(getApplicationContext(),Form1Activity.class);
                startActivity(Form1);
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Global.reporte.equals("1")){
                    Intent tabla=new Intent(getApplicationContext(),TablaActivity.class);
                    startActivity(tabla);
                }
                if (Global.reporte.equals("67")){
                    Intent inf2=new Intent(getApplicationContext(),Informe2Activity.class);
                    startActivity(inf2);
                }

            }
        });
    }
}
