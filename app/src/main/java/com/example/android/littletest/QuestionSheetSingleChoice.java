package com.example.android.littletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.littletest.R.string.Q;

public class QuestionSheetSingleChoice extends Activity
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int correctCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_single);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        String[][] myDataset={
                {getString(Q,"1","If you are at south pole,facing north,then you turn left,where are you facing?"),
                        getString(R.string.A,"1","North"),getString(R.string.A,"2","West"),getString(R.string.A,"3","East")},
                {getString(Q,"2","Is whale a fish?"),getString(R.string.A,"1","Yes"),getString(R.string.A,"2","No"),getString(R.string.A,"3","Do not know")},
                {getString(Q,"3","What programming language is this course using?"),getString(R.string.A,"1","C++")
                        ,getString(R.string.A,"2","Java"),getString(R.string.A,"3","Python")},
                {getString(Q,"4","How is this course?"),getString(R.string.A,"1","Awesome"),getString(R.string.A,"2","Bad"),getString(R.string.A,"3","Just so so")},
                {getString(Q,"5","123+321=?"),getString(R.string.A,"1"," 333"),getString(R.string.A,"2"," 222"),
                        getString(R.string.A,"3"," 444")}
        };

        mAdapter = new MyAdapterSingleChoice(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    public int getAnswer(int positon)
    {
        View v = mRecyclerView.getLayoutManager().findViewByPosition(positon);
        RadioButton b1 = (RadioButton)v.findViewById(R.id.a1);
        RadioButton b2 = (RadioButton)v.findViewById(R.id.a2);
        RadioButton b3 = (RadioButton)v.findViewById(R.id.a3);
        if(b1.isChecked()) return 1;
        else if(b2.isChecked()) return 2;
        else if(b3.isChecked()) return 3;
        else return 0;
    }

    public void checkAnswers()
    {
        correctCount=0;
        if(getAnswer(0)==1) correctCount+=1;
        if(getAnswer(1)==2) correctCount+=1;
        if(getAnswer(2)==2) correctCount+=1;
        if(getAnswer(3)==1) correctCount+=1;
        if(getAnswer(4)==3) correctCount+=1;
    }

    public void clickNext(View v)
    {
        String name = getIntent().getStringExtra("name");
        checkAnswers();
        String text = String.format("Hello %s\nYou get %d out of 5 correct",name,correctCount);
        Toast toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Intent act1 = new Intent(this,QuestionSheetMultiChoice.class);
        act1.putExtra("score",correctCount);
        act1.putExtra("name",name);
        startActivity(act1);
    }

}