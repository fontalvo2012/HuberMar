package com.example.jhosely.hubermar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Form3Activity extends AppCompatActivity {
    private Button basicos,espesifica,filtro,generar,listo2;
    private TextView nombreUser,perfil;
    private EditText numeroDo,noPedido,orden,aceptacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form3);

        basicos=findViewById(R.id.basicos);
        espesifica=findViewById(R.id.espesifica);
        filtro=findViewById(R.id.filtro);
        generar=findViewById(R.id.generar);

        nombreUser=findViewById(R.id.nombreUser);
        perfil=findViewById(R.id.perfil);

        nombreUser.setText(Global.nombre);
        perfil.setText(Global.perfil);

        //Edittext
            numeroDo=findViewById(R.id.numeroDo);
            noPedido=findViewById(R.id.noPedido);
            orden=findViewById(R.id.orden);
            aceptacion=findViewById(R.id.aceptacion);
            listo2=findViewById(R.id.listo2);
        //Fin Edittext

        numeroDo.setText(Global.numeroDo);
        noPedido.setText(Global.noPedido);
        orden.setText(Global.ordenCompra);
        aceptacion.setText(Global.noAceptacion);

        listo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Form3Activity.this,"Parametros Fijados",Toast.LENGTH_SHORT).show();
                Global.numeroDo=numeroDo.getText()+"";
                Global.noPedido=noPedido.getText()+"";
                Global.ordenCompra=orden.getText()+"";
                Global.noAceptacion=aceptacion.getText()+"";
                Intent Form4=new Intent(getApplicationContext(),Form4Activity.class);
                startActivity(Form4);

            }
        });



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
                Intent Form1=new Intent(getApplicationContext(),Form1Activity.class);
                startActivity(Form1);
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
