package com.example.jhosely.hubermar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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

public class LoginActivity extends AppCompatActivity {
    private TextView registrer;
    private EditText clave,usuario;
    private Button aceptar;
    private ProgressBar loading;
   // private static String URL_LOGIN="http://192.168.1.67:8080/logearse/login.php";
    //private static String URL_LOGIN="http://www.hubemar.simecomsas.co/mconecta.php";
   private static String URL_LOGIN="http://sqlapp.hubemar.com:84/mconecta.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registrer=findViewById(R.id.registrer);
        clave=findViewById(R.id.clave);
        usuario=findViewById(R.id.usuario);
        aceptar=findViewById(R.id.aceptar);
        loading=findViewById(R.id.loading);

        registrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,LoginActivity.class));
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=usuario.getText().toString().trim();
                String pass=clave.getText().toString().trim();

                if (!user.isEmpty() || !pass.isEmpty()){
                    login(user,pass);
                }else{
                    usuario.setError("Ingrese Usuario");
                    clave.setError("Ingrese Clave");
                }

            }
        });
    }
    private void login(final String usuario, final String clave){
        loading.setVisibility(View.VISIBLE);
       //aceptar.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(LoginActivity.this,"Respuesta"+response,Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject= new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray= jsonObject.getJSONArray("login");
                    if(success.equals("1")){
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);
                            String user = object.getString("usuario").trim();
                            String rol= object.getString("rol").trim();
                            String nombre=object.getString("nombre").trim();
                            String informacion=object.getString("informacion").trim();;
                            Toast.makeText(LoginActivity.this,"Success Login. \nTu Usuario: "
                                    +user+"\nTu Rol"
                                    +rol+"\n Info:"+informacion,Toast.LENGTH_SHORT)
                                    .show();
                            Global.nombre=nombre;
                            Global.perfil=rol;
                            Global.informacion=informacion;
                            Global.clave=clave;
                            Global.usuario=usuario;
                            Intent Form2=new Intent(getApplicationContext(),Principal.class);
                            startActivity(Form2);
                            loading.setVisibility(View.GONE );
                        }

                    }else{
                        Toast.makeText(LoginActivity.this,"USUARIO O CONTRASEÑA INCORRECTA ",Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    loading.setVisibility(View.GONE );
                    //aceptar.setVisibility(View.GONE );
                    Toast.makeText(LoginActivity.this,"Hubo algun error 1 "+e.toString(),Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE );
                     //   aceptar.setVisibility(View.GONE );
                        Toast.makeText(LoginActivity.this,"Hubo algun error 2 "+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("usuario",usuario);
                params.put("clave",clave);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
