package com.grademojo.volley2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

public class StringRequestActivity extends AppCompatActivity {

    private String TAG = StringRequestActivity.class.getSimpleName();


    private Button btnStringReq;
    private TextView msgResponse;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request);


        btnStringReq = (Button) findViewById(R.id.btnStringReq);
        msgResponse = (TextView) findViewById(R.id.msgResponse);


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);


        btnStringReq.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                makeStringReq();
            }
        });
    }


    private void showProgressDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }


    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }



    private void makeStringReq() {
        showProgressDialog();



        StringRequest strReq = new StringRequest(Request.Method.GET,
                Const.URL_STRING_REQ,

                new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                //VolleyLog.d(TAG, response.toString());

                Log.d(TAG, response.toString());


                msgResponse.setText(response.toString());
                hideProgressDialog();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                //VolleyLog.d(TAG, "Error: " + error.getMessage());

                Log.d(TAG, "Error: " + error.getMessage());



                hideProgressDialog();
            }
        });



        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, this);
    }


    @Override
    protected void onStop() {

        AppController.getInstance().cancelPendingRequests(this);

        hideProgressDialog();


        super.onStop();
    }
}

