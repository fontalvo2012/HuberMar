package com.example.jhosely.hubermar;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


/**
 * Created by jhosely on 22/10/19.
 */

public class SpinnerJson {

    public static ArrayAdapter<String> comboAdapter;
    public static ArrayList<String>indx=new ArrayList<String>();
    private static String URL_LOGIN="http://192.168.1.67:8080/logearse/sucursales.php";




    public static void SpinerTerceros(final Context context){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject= new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray= jsonObject.getJSONArray("listado");
                    String[] valores= new String[jsonArray.length()];
                    List<String> datos = new ArrayList<> ();
                    if(success.equals("1")){
                       // Toast.makeText(context,""+jsonArray.toString(),Toast.LENGTH_SHORT).show();
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);
                            valores[i]=object.getString("valor");
                            SpinnerJson.indx.add(object.getString("id"));
                        }
                        Collections.addAll(datos,valores);
                        SpinnerJson.comboAdapter=new ArrayAdapter<>(context,android.R.layout.simple_spinner_item,datos);
                    }else{

                    }

                } catch (JSONException e) {
                    Toast.makeText(context,"Spinner algun error 1 "+e.toString(),Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Toast.makeText(context,"Spinner algun error 2 "+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("usuario","jalmeida");
                params.put("clave","jalmeida");
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
