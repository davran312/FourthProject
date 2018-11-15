package com.example.sab_2017.fourthproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    View view ;
    TextView etDate ;
    Boolean firstInitialization = true;
    CalendarView calendarView;
    Button save;
    Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initButtons();

    }

    private void initViews() {
        view = findViewById(R.id.include_calendar);
        etDate = findViewById(R.id.birthday);
        btnRegistration = findViewById(R.id.btnRegistration);
    }

    private void initButtons() {
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTheNextActivity();
            }
        });
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstInitialization){
                    initializeView();
                }
                view.setVisibility(View.VISIBLE);

            }
        });

    }

    private void goToTheNextActivity() {
        Intent intent  = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    private void initializeView() {
         save = view.findViewById(R.id.btnSave);
         calendarView = view.findViewById(R.id.calendar);
         calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
             @Override
             public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                 String date = (month+1)+"/"+dayOfMonth+"/"+year;
                 etDate.setText(date);
             }
         });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setVisibility(View.GONE);
            }
        });
         firstInitialization = false;

    }
}
