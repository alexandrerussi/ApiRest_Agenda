package com.fiap.apirest.apirest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ex2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
    }

    public void executaPost(View view){

        TextView edtUserId = findViewById(R.id.edtIdPost);
        TextView edtTitle = findViewById(R.id.edtTitlePost);
        TextView edtBody = findViewById(R.id.edtBodyPost);
        TextView txtMensagem = findViewById(R.id.txtMensagem);

        String url = "https://jsonplaceholder.typicode.com/posts/";
        String json =
                "{\n"+
                        "    \"userid\": \""+edtUserId.getText().toString()+"\",\n" +
                        "    \"title\": \""+edtTitle.getText().toString()+"\"\n" +
                        "    \"body\":  \""+edtBody.getText().toString()+"\"\n" +
                        "}";

        new Post(txtMensagem).execute(url,json);
    }
}
