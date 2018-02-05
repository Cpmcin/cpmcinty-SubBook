package com.example.cameronmcintyre.cpmcinty_subapp;

/**
 * Created by cameronmcintyre on 2018-02-04.
 */


import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SubCustomAdapter extends ArrayAdapter<Subscription>{
    Context context;
    int layoutResourceId;
    ArrayList<Subscription> subData = new ArrayList<Subscription>();
    public SubCustomAdapter(Context context, int layoutResourceId,
                             ArrayList<Subscription> subData) {
        super(context, layoutResourceId, subData);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.subData = subData;
    } public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SubCustomAdapter.SubHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new SubCustomAdapter.SubHolder();
            holder.textName = (TextView) row.findViewById(R.id.textView1);
            holder.textDate = (TextView) row.findViewById(R.id.textView2);
            holder.textCharge = (TextView) row.findViewById(R.id.textView3);
            holder.btnEdit = (Button) row.findViewById(R.id.button1);
            holder.btnDelete = (Button) row.findViewById(R.id.button2);
            row.setTag(holder);
        } else {
            holder = (SubHolder) row.getTag();
        }
        Subscription subscription = subData.get(position);
        holder.textName.setText(subscription.getName());
        holder.textDate.setText((subscription.getDate()).toString());
        holder.textCharge.setText((subscription.getCharge()).toString());
        holder.btnEdit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("Edit Button Clicked", "**********");
                Toast.makeText(context, "Edit button Clicked",
                        Toast.LENGTH_LONG).show();
            }
        });
        holder.btnDelete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("Delete Button Clicked", "**********");
                Toast.makeText(context, "Delete button Clicked",
                        Toast.LENGTH_LONG).show();
            }
        });
        return row;

    }

    static class SubHolder {
        TextView textName;
        TextView textDate;
        TextView textCharge;
        Button btnEdit;
        Button btnDelete;
    }








}
