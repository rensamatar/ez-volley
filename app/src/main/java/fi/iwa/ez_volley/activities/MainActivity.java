package fi.iwa.ez_volley.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fi.iwa.ez_volley.R;

public class MainActivity extends AppCompatActivity {

    private Button btnGetJsonArray, btnGetJsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    private void initComponent() {
        btnGetJsonArray = (Button) findViewById(R.id.btn_json_array);
        btnGetJsonArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonArrayRequest();
            }
        });
        btnGetJsonObject = (Button) findViewById(R.id.btn_json_object);
        btnGetJsonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObjectRequest();
            }
        });
    }

    // Intent to json array request activity class.
    private void makeJsonArrayRequest() {
        Intent intent = new Intent(this, JSONArrayRequestActivity.class);
        startActivity(intent);
    }

    // Intent to json object request activity class.
    private void makeJsonObjectRequest() {
        Intent intent = new Intent(this, JSONObjectRequestActivity.class);
        startActivity(intent);
    }
}
