package in.codehex.facilis;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import in.codehex.facilis.util.AppController;
import in.codehex.facilis.util.Config;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEditText,passwordEditText;
    String username, password,userid,token;
    Button submitButton;
    private static String TAG = LoginActivity.class.getSimpleName();
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        usernameEditText = (EditText) findViewById(R.id.username_edit_text);
        passwordEditText = (EditText) findViewById(R.id.password_edit_text);
        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

    }

   private void doLogin(){

       JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
               Config.loginUrl, null,
               new Response.Listener<JSONObject>() {

                   @Override
                   public void onResponse(JSONObject response) {
                       Log.d(TAG, response.toString());
                       pDialog.hide();
                   }
               }, new Response.ErrorListener() {

           @Override
           public void onErrorResponse(VolleyError error) {
               VolleyLog.d(TAG, "Error: " + error.getMessage());
               pDialog.hide();
           }
       }) {

           @Override
           protected Map<String, String> getParams() {
               Map<String, String> params = new HashMap<String, String>();
               params.put("name", "Droider");
               return params;
           }

       };

// Adding request to request queue
       AppController.getInstance().addToRequestQueue(jsonObjReq);

   }
}
