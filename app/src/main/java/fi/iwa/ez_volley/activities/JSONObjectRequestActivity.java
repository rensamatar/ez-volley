package fi.iwa.ez_volley.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import fi.iwa.ez_volley.R;
import fi.iwa.ez_volley.config.Endpoints;
import fi.iwa.ez_volley.listener.VolleyResponseListener;
import fi.iwa.ez_volley.network.VolleyRequest;

public class JSONObjectRequestActivity extends AppCompatActivity {

    private static final String TAG = JSONObjectRequestActivity.class.getSimpleName();

    private Button btnRequest;
    private TextView responseMessage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_object_request);

        initComponent();
    }

    private void initComponent() {
        btnRequest = (Button) findViewById(R.id.btn_request);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestJsonObject();
            }
        });

        responseMessage = (TextView) findViewById(R.id.response_message_text);
    }

    // This is an example for request json object.
    private void requestJsonObject() {
        VolleyRequest.getObjectRequest(Endpoints.GET_JSON_OBJECT_URL, null, new VolleyResponseListener() {
            @Override
            public void onError(final VolleyError error) {
                // Check error here
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "_error response " + error.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Object response) {
                if (response instanceof JSONObject) {
                    JSONObject jsonObject = (JSONObject) response;

                    // Parse your json response here.
                    responseMessage.setText(jsonObject.toString());
                }
            }

            @Override
            public void onNetworkResponse(final NetworkResponse response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "_network response code " + response.statusCode);
                    }
                });
            }
        });
    }
}
