package com.fiap.nac.requisicoes_persistencia_dados;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ex3Activity extends AppCompatActivity {

    public final String PreferenceKey = "PREF";

    private EditText edtChaveGravar, edtTarefa, edtChavePesquisa;
    private Button btnGravar, btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);

        btnGravar = (Button) findViewById(R.id.btnGravar);
        btnRecuperar = (Button) findViewById(R.id.btnRecuperar);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravaPreferencia();
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperaPreferencia();
            }
        });
    }

    public void gravaPreferencia(){
        EditText edtChaveGravar = findViewById(R.id.edtChaveGravar);
        EditText txtPref = findViewById(R.id.edtTarefa);

        addPreference(edtChaveGravar.getText().toString(),txtPref.getText().toString());
    }

    public void recuperaPreferencia(){
        EditText edtChavePesquisa = findViewById(R.id.edtChavePesquisa);
        TextView txtMensagem = findViewById(R.id.txtResposta);
        txtMensagem.setText(getPreference(edtChavePesquisa.getText().toString()));
    }

    public void addPreference(String chave,String valor){
        SharedPreferences sh = getSharedPreferences(PreferenceKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sh.edit();

        ed.putString(chave,valor);
        ed.apply();
    }

    public String getPreference(String chave){
        SharedPreferences sh = getSharedPreferences(PreferenceKey,Context.MODE_PRIVATE);
        return sh.getString(chave,"");
    }
}
