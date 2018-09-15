package com.fiap.nac.requisicoes_persistencia_dados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ex1Activity extends AppCompatActivity {

    private Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        btnGet = (Button) findViewById(R.id.btnGet);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executaConsulta();
            }
        });
    }

    public void executaConsulta(){

        String response;
        String url = "https://reqres.in/api/users/";

        EditText txtConsulta = findViewById(R.id.edtIdGet);
        url += txtConsulta.getText().toString();

        TextView txtNome = findViewById(R.id.txtTitleGet);
        TextView txtSobrenome = findViewById(R.id.txtCompletedGet);
        TextView txtMensagem = findViewById(R.id.txtMsg);

        //NetworkToolkit.getJSONFromAPI(url);

        new DataGetter(txtNome,txtSobrenome,txtMensagem).execute(url);

    }
}
