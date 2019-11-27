package com.example.jhosely.hubermar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class esradoTramiteActivity extends AppCompatActivity {
    private Button parametros,listado,detalles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esrado_tramite);

        parametros= findViewById(R.id.parametros);
        listado=findViewById(R.id.listado);
        detalles=findViewById(R.id.detalles);

        parametros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form1=new Intent(getApplicationContext(),ParametrosActivity.class);
                startActivity(Form1);
            }
        });

    }
}
