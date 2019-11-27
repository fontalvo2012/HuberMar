package com.example.jhosely.hubermar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;

public class Informe2Activity extends AppCompatActivity {
    private static String URL_LOGIN="http://www.hubemar.simecomsas.co/mreportes.php?";

    public Tabla tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tabla);


        tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.informe2);
        Generar();
    }
    private void Generar(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject= new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray= jsonObject.getJSONArray("datos");

                    if(success.equals("1")){
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);
                            ArrayList<String> contenido=new ArrayList<>();
                            contenido.add(object.getString("NUMERO_VIN").trim());
                            contenido.add(object.getString("BANCO").trim());
                            contenido.add(object.getString("NUMERO_STICKER").trim());
                            contenido.add(object.getString("FPAGO").trim());
                            contenido.add(object.getString("NUMERO_ACEPTACION").trim());
                            contenido.add(object.getString("FACEPTACION").trim());
                            contenido.add(object.getString("NUMERO_LEVANTE").trim());
                            contenido.add(object.getString("FLEVANTE").trim());
                            contenido.add(object.getString("NUMERO_REG_LICENCIA").trim());
                            contenido.add(object.getString("FAPROBACION").trim());
                            contenido.add(object.getString("LINEA_PRODUCCION").trim());
                            contenido.add(object.getString("NOMBRE_TRANSPORTADOR").trim());
                            contenido.add(object.getString("NOMBRE_PAIS").trim());
                            tabla.agregarFilaTabla(contenido);
                        }

                    }else{

                    }

                } catch (JSONException e) {
                    Toast.makeText(Informe2Activity.this,"Hubo algun error 1 "+e.toString(),Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Toast.makeText(Informe2Activity.this,"Hubo algun error 2 "+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("usuario",Global.usuario);
                params.put("clave",Global.clave);
                params.put("p_tipo",Global.reporte);
                params.put("p_importador",Global.importador);
                params.put("p_ejecutivo","0");
                params.put("p_modalidad","I");
                params.put("p_faceptai","");
                params.put("p_faceptaf","");
                params.put("p_fmercanciai","");
                params.put("p_fmercanciaf","");
                params.put("p_fretiroi","");
                params.put("p_fretirof","");
                params.put("p_fstickeri","");
                params.put("p_fstickerf","");
                params.put("p_ffacturai","");
                params.put("p_ffacturaf","");
                params.put("p_numeroped","");
                params.put("p_sucursal",Global.sucursal);
                params.put("p_reporte",Global.reporte);
                params.put("p_numerodo",Global.numeroDo);
                params.put("p_ordencompra",Global.ordenCompra);
                params.put("p_numeroacep",Global.noAceptacion);
                params.put("p_faperturai",Global.aperturaIni);
                params.put("p_faperturaf",Global.aperturaFin);
                params.put("p_flevantei",Global.levanteIni);
                params.put("p_flevantef",Global.levanteFin);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
