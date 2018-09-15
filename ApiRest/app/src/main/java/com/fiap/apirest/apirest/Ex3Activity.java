package com.fiap.apirest.apirest;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex3Activity extends AppCompatActivity {

    public final String chave = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
    }

    public void gravaDadosArquivo(String nomearquivo, String conteudo){
        try
        {
            FileOutputStream fs;
            fs = openFileOutput(nomearquivo, Context.MODE_PRIVATE);
            fs.write(conteudo.getBytes());
            fs.close();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("MENSAGEM");
            alertDialogBuilder.setMessage("Inserido com sucesso.");
            alertDialogBuilder.setCancelable(true);
            alertDialogBuilder.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String recuperaDadosArquivo(String nomearquivo)
    {
        try{
            int conteudo;
            StringBuilder output = new StringBuilder();

            FileInputStream fi = openFileInput(nomearquivo);
            conteudo = fi.read();

            while (conteudo != -1)
            {
                output.append((char)conteudo);
                conteudo = fi.read();
            }

            return output.toString();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public void gravar(View view)
    {
        EditText ed = findViewById(R.id.edtTarefa);
        gravaDadosArquivo(ed.getText().toString().substring(0,3), ed.getText().toString());
    }

    public void recuperar(View view)
    {
        EditText ed = findViewById(R.id.edtRecupera);
        ed.setText(recuperaDadosArquivo(ed.getText().toString().substring(0,3)));
    }
}
