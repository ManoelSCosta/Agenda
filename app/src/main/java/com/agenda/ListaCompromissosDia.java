package com.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ListaCompromissosDia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compromissos_dia);

        Bundle extras = getIntent().getExtras();
        String dia = "";

        if (extras != null) {
            dia = extras.getString("data");
        }

        ArrayList<Compromisso> compromissosDia = new ArrayList<Compromisso>();

        for(int i = 0; i < AgendaUtil.compromissos.size(); i++){

            if(!dia.equals("") && dia.equals(AgendaUtil.compromissos.get(i).getData())){

                compromissosDia.add(AgendaUtil.compromissos.get(i));
            }
        }

    }
}
