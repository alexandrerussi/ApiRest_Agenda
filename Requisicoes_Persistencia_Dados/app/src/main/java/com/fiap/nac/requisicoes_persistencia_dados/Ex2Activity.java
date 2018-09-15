package com.fiap.nac.requisicoes_persistencia_dados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ex2Activity extends AppCompatActivity {

    private EditText edtIdPost, edtTitlePost, edtBodyPost;
    private TextView txtMensagem;

    private Button btnSubmeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);

        btnSubmeter = (Button) findViewById(R.id.btnSubmeter);

        btnSubmeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executaPost();
            }
        });
    }

    public void executaPost(){

        edtIdPost = (EditText) findViewById(R.id.edtIdPost);
        edtTitlePost = (EditText) findViewById(R.id.edtTitlePost);
        edtBodyPost = (EditText) findViewById(R.id.edtBodyPost);

        txtMensagem = (TextView) findViewById(R.id.txtMensagem);

        String url = "https://reqres.in/api/users/";
        String parameter =  "{\n" +
                "    \"id\": \""+edtIdPost.getText().toString()+"\",\n" +
                "    \"title\": \""+edtTitlePost.getText().toString()+"\",\n" +
                "    \"body\": \""+edtBodyPost.getText().toString()+"\",\n" +
                "}";

        new DataGetterPost(txtMensagem).execute(url,parameter);

    }
}
