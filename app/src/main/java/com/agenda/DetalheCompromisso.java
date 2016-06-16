package com.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetalheCompromisso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_compromisso);

        Bundle extras = getIntent().getExtras();
        Compromisso compromisso = new Compromisso();

        if (extras != null) {
            compromisso = (Compromisso) extras.getSerializable("compromisso");
        }

        int x = 1;
    }
}
