package com.beproject.trafficalert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText uname,password;
    TextView register;
    Button login;
    RequestQueue requestQueue;
    public static final String URL ="http://traffalert.netau.net/user_control.php";
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (EditText)findViewById(R.id.uname);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        register=(TextView)findViewById(R.id.register);

        requestQueue= Volley.newRequestQueue(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.names().get(0).equals("success")){
                                Toast.makeText(getApplicationContext(),"Success"+jsonObject.getString("success"),Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Welcome.class));
                            }
                            else if (jsonObject.names().get(0).equals("error")){
                                Toast.makeText(getApplicationContext(),"Error: "+jsonObject.getString("error"),Toast.LENGTH_SHORT).show();
                                uname.setText(null);
                                password.setText(null);

                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Warning: "+jsonObject.getString("blank"),Toast.LENGTH_SHORT).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                     @Override
                     protected Map<String, String> getParams() throws AuthFailureError {
                         HashMap<String,String> hashmap = new HashMap<String, String>();
                         hashmap.put("username",uname.getText().toString());
                         hashmap.put("password",password.getText().toString());
                         return hashmap;

                     }
                 };

                requestQueue.add(request);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignupActivity.class));
            }
        });
    }

}
