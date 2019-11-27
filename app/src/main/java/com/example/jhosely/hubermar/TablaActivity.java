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

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;

public class TablaActivity extends AppCompatActivity {
    private static String URL_LOGIN="http://www.hubemar.simecomsas.co/mreportes.php?";

    public Tabla tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tabla);


        tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.dim_reporte_dim);
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
                            //String cantidad = object.getString("CANTIDAD").trim();
                            ArrayList<String> contenido=new ArrayList<>();
                            contenido.add(object.getString("ANIO").trim());
                            contenido.add(object.getString("MES").trim());
                            contenido.add(object.getString("NUMERO_FORMULARIO_DI").trim());
                            contenido.add(object.getString("FECHA_ACEPTACION").trim());
                            contenido.add(object.getString("NUMERO_DO").trim());
                            contenido.add(object.getString("NUMERO_PEDIDO").trim());
                            contenido.add(object.getString("FECHA_APERTURA").trim());
                            contenido.add(object.getString("NOMBRE_SEGMENTO").trim());
                            contenido.add(object.getString("NUMERO_IDENTIFICACION").trim());
                            contenido.add(object.getString("NOMBRE_IMPORTADOR").trim());
                            contenido.add(object.getString("NOMBRE_ADMINISTRACION").trim());
                            contenido.add(object.getString("NUMERO_IDENTIFICACION").trim());
                            contenido.add(object.getString("NOMBRE_PERSONA").trim());
                            contenido.add(object.getString("FACTURA").trim());
                            contenido.add(object.getString("FECHA_FACTURA").trim());
                            contenido.add(object.getString("NUMERO_LISTA_EMPAQUE").trim());
                            contenido.add(object.getString("CODIGO_CONDICION_ENTREGA").trim());
                            contenido.add(object.getString("NOMBRE_EXPORTADOR").trim());
                            contenido.add(object.getString("PESO_NETO").trim());
                            contenido.add(object.getString("PESO_BRUTO").trim());
                            contenido.add(object.getString("VALOR_TOTAL_FOB").trim());
                            contenido.add(object.getString("VALOR_CIF").trim());
                            contenido.add(object.getString("TRM").trim());
                            contenido.add(object.getString("FECHA_DOC_TRANS").trim());
                            contenido.add(object.getString("NUMERO_DOC_TRANS").trim());
                            contenido.add(object.getString("FECHA_MANIFIESTO").trim());
                            contenido.add(object.getString("NUMERO_STICKER").trim());
                            contenido.add(object.getString("FECHA_PAGO").trim());
                            contenido.add(object.getString("DIM").trim());
                            contenido.add(object.getString("SELECTIVIDAD").trim());
                            contenido.add(object.getString("VALOR_TOTAL_FOB").trim());
                            contenido.add(object.getString("VALOR_FLETES").trim());
                            contenido.add(object.getString("VALOR_SEGUROS").trim());
                            contenido.add(object.getString("VALOR_OTROS_GASTOS").trim());
                            contenido.add(object.getString("AJUSTE_VALOR").trim());
                            contenido.add(object.getString("VALOR_ADUANA").trim());
                            contenido.add(object.getString("PORCENTAJE_ARANCEL").trim());
                            contenido.add(object.getString("BASE_ARANCEL").trim());
                            contenido.add(object.getString("TOTAL_ARANCEL").trim());
                            contenido.add(object.getString("PORCENTAJE_IVA").trim());
                            contenido.add(object.getString("BASE_IVA").trim());
                            contenido.add(object.getString("TOTAL_IVA").trim());
                            contenido.add(object.getString("TOTAL_LIQUIDADO").trim());
                            contenido.add(object.getString("NUMERO_LEVANTE").trim());
                            contenido.add(object.getString("FECHA_LEVANTE").trim());
                            contenido.add(object.getString("TRAMITE_REALIZADO_POR").trim());
                            contenido.add(object.getString("CODIGO_UAP").trim());
                            contenido.add(object.getString("NUMERO_ACEPTACION").trim());
                            contenido.add(object.getString("FORMULARIO_FISICO").trim());
                            contenido.add(object.getString("FECHA_ACEPTACION").trim());
                            contenido.add(object.getString("FECHA_RETIRO_TOTAL").trim());
                            contenido.add(object.getString("CODIGO_MODALIDAD").trim());
                            contenido.add(object.getString("CODIGO_POSICION").trim());
                            contenido.add(object.getString("CODIGO_UNIDAD_CCIAL_DIAN").trim());
                            contenido.add(object.getString("CANTIDAD").trim());
                            contenido.add(object.getString("NUMERO_REG_LICENCIA").trim());
                            contenido.add(object.getString("PROGRAMA_AUTORIZADO").trim());
                            contenido.add(object.getString("CIP").trim());
                            contenido.add(object.getString("C46").trim());
                            contenido.add(object.getString("C47").trim());
                            contenido.add(object.getString("C48").trim());
                            contenido.add(object.getString("C49").trim());
                            contenido.add(object.getString("C50").trim());
                            contenido.add(object.getString("DESCRIPCION").trim());
                            contenido.add(object.getString("CODIGO_DEPOSITO").trim());
                            tabla.agregarFilaTabla(contenido);
                        }

                    }else{

                    }

                } catch (JSONException e) {
                    Toast.makeText(TablaActivity.this,"Hubo algun error 1 "+e.toString(),Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                       Toast.makeText(TablaActivity.this,"Hubo algun error 2 "+error.toString(),Toast.LENGTH_SHORT).show();
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
