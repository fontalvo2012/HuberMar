package com.example.jhosely.hubermar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private Button generar,confi,soporte;
    private TextView nombreUser,perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        generar=findViewById(R.id.generarInf);
        confi=findViewById(R.id.configuracion);
        soporte=findViewById(R.id.soporte);
        SpinnerJson.SpinerTerceros(this);
        nombreUser=findViewById(R.id.nombreUser);
        perfil=findViewById(R.id.perfil);

        nombreUser.setText(Global.nombre);
        perfil.setText(Global.perfil);

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form1=new Intent(getApplicationContext(),esradoTramiteActivity.class);
                startActivity(Form1);
            }
        });

    }
}
