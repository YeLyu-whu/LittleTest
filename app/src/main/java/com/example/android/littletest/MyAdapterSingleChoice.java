package com.example.android.littletest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

public class MyAdapterSingleChoice extends RecyclerView.Adapter<MyAdapterSingleChoice.ViewHolder> {
    private String[][] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapterSingleChoice(String[][] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapterSingleChoice.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_single_choice, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView Q = (TextView)holder.mView.findViewById(R.id.question_text);
        RadioButton A1 = (RadioButton)holder.mView.findViewById(R.id.a1);
        RadioButton A2 = (RadioButton)holder.mView.findViewById(R.id.a2);
        RadioButton A3 = (RadioButton)holder.mView.findViewById(R.id.a3);
        Q.setText(mDataset[position][0]);
        A1.setText(mDataset[position][1]);
        A2.setText(mDataset[position][2]);
        A3.setText(mDataset[position][3]);
        //holder.mView.setText(mDataset[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}