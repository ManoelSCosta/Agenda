package com.agenda;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class AgendaCompromissosActivity extends AppCompatActivity {

    private CalendarioAdapter adapter;
    private Handler handler;
    private Calendar month;
    private ArrayList<String> itens;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_compromissos);

        mContext = getBaseContext();
        month = Calendar.getInstance();
        onNewIntent(getIntent());

        itens = new ArrayList<String>();

        adapter = new CalendarioAdapter(this, month);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        handler = new Handler();
        handler.post(calendarUpdater);

        TextView title  = (TextView) findViewById(R.id.title);
        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));

        TextView previous  = (TextView) findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(month.get(Calendar.MONTH)== month.getActualMinimum(Calendar.MONTH)) {
                    month.set((month.get(Calendar.YEAR)-1),month.getActualMaximum(Calendar.MONTH),1);
                } else {
                    month.set(Calendar.MONTH,month.get(Calendar.MONTH)-1);
                }
                refreshCalendar();
            }
        });

        TextView next  = (TextView) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(month.get(Calendar.MONTH)== month.getActualMaximum(Calendar.MONTH)) {
                    month.set((month.get(Calendar.YEAR)+1),month.getActualMinimum(Calendar.MONTH),1);
                } else {
                    month.set(Calendar.MONTH,month.get(Calendar.MONTH)+1);
                }
                refreshCalendar();

            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                TextView date = (TextView)v.findViewById(R.id.date);
                if(date instanceof TextView && !date.getText().equals("")) {

                    Intent intent = new Intent();
                    String day = date.getText().toString();
                    if(day.length()==1) {
                        day = "0"+day;
                    }

                    intent.putExtra("date", android.text.format.DateFormat.format("yyyy-MM", month)+"-"+day);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });

        Button btnNovoCompromisso = (Button) findViewById(R.id.btn_novo_compromisso);
        btnNovoCompromisso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoCompromisso = new Intent(mContext, NovoCompromissoActivity.class);
                startActivity(novoCompromisso);
            }
        });
    }

    public void refreshCalendar() {
        TextView title  = (TextView) findViewById(R.id.title);

        adapter.refreshDays();
        adapter.notifyDataSetChanged();
        handler.post(calendarUpdater);

        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
    }

    public void onNewIntent(Intent intent) {

        String date = AgendaUtil.todayString();
        String[] dateArr = date.split("-");
        month.set(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2]));
    }

    public Runnable calendarUpdater = new Runnable() {

        @Override
        public void run() {
            itens.clear();

            for(int i=0;i<31;i++) {
                Random r = new Random();

                if(r.nextInt(10)>6)
                {
                    itens.add(Integer.toString(i));
                }
            }

            adapter.setItens(itens);
            adapter.notifyDataSetChanged();
        }
    };
}
