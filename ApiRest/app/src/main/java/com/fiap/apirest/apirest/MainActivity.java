package com.fiap.apirest.apirest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnEx1, btnEx2, btnEx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEx1 = (Button) findViewById(R.id.btnEx1);
        btnEx2 = (Button) findViewById(R.id.btnEx2);
        btnEx3 = (Button) findViewById(R.id.btnEx3);

        btnEx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex1Activity.class);
                startActivity(intent);
            }
        });

        btnEx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex2Activity.class);
                startActivity(intent);
            }
        });

        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex3Activity.class);
                startActivity(intent);
            }
        });
    }
}
