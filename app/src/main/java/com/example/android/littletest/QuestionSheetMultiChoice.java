package com.example.android.littletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class QuestionSheetMultiChoice extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int correctCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_multi);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_multi);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        String[][] myDataset = {
                {getString(R.string.Q, "1", "Who are the teachers of this course?"),
                        getString(R.string.A, "1", "Katherine"), getString(R.string.A, "2", "Lyla"),
                        getString(R.string.A, "3", "Tom")}
        };

        mAdapter = new MyAdapterMultiChoice(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
    public int getAnswer(int positon)
    {
        View v = mRecyclerView.getLayoutManager().findViewByPosition(positon);
        CheckBox b1 = (CheckBox)v.findViewById(R.id.a1_multi);
        CheckBox b2 = (CheckBox)v.findViewById(R.id.a2_multi);
        CheckBox b3 = (CheckBox)v.findViewById(R.id.a3_multi);
        if(!b1.isChecked()) return 0;
        else if(!b2.isChecked()) return 0;
        else if(b3.isChecked()) return 0;
        else return 1;
    }

    public void checkAnswers()
    {
        correctCount=0;
        if(getAnswer(0)==1) correctCount+=1;
    }
    public void clickFinish(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Finish", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        String name = getIntent().getStringExtra("name");
        int score = getIntent().getIntExtra("score",0);
        checkAnswers();
        String text = String.format("Hello %s\nYou get %d out of 1 correct",name,correctCount);
        toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        text = String.format("Finally, You get %d out of 6 correct",correctCount+score);
        toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
