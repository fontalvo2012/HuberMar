package com.example.jhosely.hubermar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class informacionGeneralActivity extends AppCompatActivity {
    private static String URL_LOGIN="http://sqlapp.hubemar.com:84/json/infoestado.php";
    public Tabla tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_general);

        tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.parametros);
        Generar();

    }
    private void Generar(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String cadena="";
                try {
                    JSONObject jsonObject= new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray= jsonObject.getJSONArray("datos");
                    if(success.equals("1")){
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);
                            ArrayList<String> contenido=new ArrayList<>();
                            contenido.add(object.getString("NUMERO_DO").trim());
                            cadena = object.getString("NUMERO_PEDIDO").trim();
                            if(cadena.equals("")){
                                cadena="N/A";
                            }
                            if(cadena.length()>10){
                                cadena=cadena.substring(0,10);
                            }
                            contenido.add(cadena);

                            contenido.add(object.getString("FECHA_APERTURA").trim());
                            contenido.add(object.getString("REGIMEN").trim());
                            tabla.agregarFilaTabla(contenido);
                        }

                    }else{
                    }
                } catch (JSONException e) {
                    Toast.makeText(informacionGeneralActivity.this,"Hubo algun error 1 "+e.toString(),Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(informacionGeneralActivity.this,"Hubo algun error 2 "+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("tipo","1");
                params.put("formato","JSON");
                params.put("numdo","");
                params.put("pedido","");
                params.put("importador",Global.informacion);
                params.put("regimen","TODOS");
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
