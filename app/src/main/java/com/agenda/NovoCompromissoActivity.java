package com.agenda;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class NovoCompromissoActivity extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_compromisso);

        mContext = getBaseContext();

        EditText dataHoraCompromisso = (EditText) findViewById(R.id.input_data_hora);
        dataHoraCompromisso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                Dialog dialog = new Dialog(mContext);

                dialog.setContentView(R.layout.adapter_picker_dialog);
                dialog.setTitle("Custom Dialog");
                dialog.show();*/

            }
        });
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            String year1 = String.valueOf(selectedYear);
            String month1 = String.valueOf(selectedMonth + 1);
            String day1 = String.valueOf(selectedDay);
            TextView tvDt = (TextView) findViewById(R.id.input_data_hora);
            tvDt.setText(day1 + "/" + month1 + "/" + year1);
        }
    };
}
