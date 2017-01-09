package com.example.android.littletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserEntrance extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_user_entrance);
    }
    public void clickReadyGo(View v)
    {
        EditText name = (EditText)findViewById(R.id.EditName);
        Toast toast=Toast.makeText(getApplicationContext(),"Ready",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        toast=Toast.makeText(getApplicationContext(),"Go",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        Intent act = new Intent(this, QuestionSheetSingleChoice.class);
        act.putExtra("name",name.getText().toString());
        startActivity(act);
    }

}
