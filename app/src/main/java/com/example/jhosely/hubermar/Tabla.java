package com.example.jhosely.hubermar;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jhosely on 9/10/19.
 */

public class Tabla {

    private TableLayout tabla; // Layout donde se pintará la tabla
    private ArrayList<TableRow> filas; // Array de las filas de la tabla
    private Activity actividad;
    private Resources rs;
    private int FILAS, COLUMNAS; // Filas y columnas de nuestra tabla

    public Tabla(Activity actividad, TableLayout tabla)
    {
        this.actividad = actividad;
        this.tabla = tabla;
        rs = this.actividad.getResources();
        FILAS = COLUMNAS = 0;
        filas = new ArrayList<TableRow>();
    }


    public void agregarCabecera(int recursocabecera)
    {
        TableRow.LayoutParams layoutCelda;
        TableRow fila = new TableRow(actividad);
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        fila.setLayoutParams(layoutFila);

        String[] arraycabecera = rs.getStringArray(recursocabecera);
        COLUMNAS = arraycabecera.length;

        for(int i = 0; i < arraycabecera.length; i++)
        {
            TextView texto = new TextView(actividad);
            layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(arraycabecera[i]), TableRow.LayoutParams.WRAP_CONTENT);
            texto.setText(arraycabecera[i]);
            texto.setGravity(Gravity.CENTER_HORIZONTAL);
            texto.setTextAppearance(actividad, R.style.estilo_celda_cab);
            texto.setBackgroundResource(R.drawable.borde_cab);
            texto.setLayoutParams(layoutCelda);
            fila.addView(texto);
        }

        tabla.addView(fila);
        filas.add(fila);

        FILAS++;
    }

    /**
     * Agrega una fila a la tabla
     * @param elementos Elementos de la fila
     */
    public void agregarFilaTabla(ArrayList<String> elementos)
    {
        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow fila = new TableRow(actividad);
        fila.setLayoutParams(layoutFila);

        for(int i = 0; i< elementos.size(); i++)
        {
            if(i==0){
                final Button button=new Button(actividad);
                button.setText(String.valueOf(elementos.get(i)));
                button.setGravity(Gravity.CENTER_HORIZONTAL);
                button.setTextAppearance(actividad,R.style.estilo_celda);
                button.setBackgroundResource(R.drawable.border);
                layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(button.getText().toString()), TableRow.LayoutParams.WRAP_CONTENT);
                button.setLayoutParams(layoutCelda);
                fila.addView(button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(actividad,"Respuesta:"+button.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                TextView texto = new TextView(actividad);
                texto.setText(String.valueOf(elementos.get(i)));
                texto.setGravity(Gravity.CENTER_HORIZONTAL);
                texto.setTextAppearance(actividad, R.style.estilo_celda);
                texto.setBackgroundResource(R.drawable.border);
                layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(texto.getText().toString()), TableRow.LayoutParams.WRAP_CONTENT);
                texto.setLayoutParams(layoutCelda);
                fila.addView(texto);
            }

        }

        tabla.addView(fila);
        filas.add(fila);
        FILAS++;
    }
    private int obtenerAnchoPixelesTexto(String texto)
    {
        Paint p = new Paint();
        Rect     bounds = new Rect();
        p.setTextSize(50);
        p.getTextBounds(texto, 0, texto.length(), bounds);
        return bounds.width();
    }
}
