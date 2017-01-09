package com.example.android.littletest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyAdapterMultiChoice extends RecyclerView.Adapter<MyAdapterMultiChoice.ViewHolder_multi> {
    private String[][] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder_multi extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ViewHolder_multi(View v) {
            super(v);
            mView = v;
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapterMultiChoice(String[][] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapterMultiChoice.ViewHolder_multi onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_multi_choice, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder_multi vh = new ViewHolder_multi(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder_multi holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView Q = (TextView)holder.mView.findViewById(R.id.question_multi_text);
        CheckBox A1 = (CheckBox)holder.mView.findViewById(R.id.a1_multi);
        CheckBox A2 = (CheckBox)holder.mView.findViewById(R.id.a2_multi);
        CheckBox A3 = (CheckBox)holder.mView.findViewById(R.id.a3_multi);
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