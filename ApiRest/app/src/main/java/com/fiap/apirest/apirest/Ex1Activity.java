package com.fiap.apirest.apirest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ex1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);
    }

    public void executarGet(View view)
    {
        String url = "https://jsonplaceholder.typicode.com/todos/";

        EditText edtId = findViewById(R.id.edtIdGet);
        url += edtId.getText().toString();

        EditText edtTitle = (EditText) findViewById(R.id.edtTitleGet);
        EditText edtCompleted = (EditText) findViewById(R.id.edtCompletedGet);

        new Get(edtTitle,edtCompleted).execute(url);

    }
}
