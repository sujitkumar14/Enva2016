package com.sujit.enva2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rajkumar on 01-10-2016.
 */
public class EventAdapter extends ArrayAdapter {

    LayoutInflater inflater;
    ArrayList<EventClass> dataList = new ArrayList<EventClass>();
    public EventAdapter(Context context, int resource, ArrayList<EventClass> dataList) {
        super(context, resource, dataList);

        inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.dataList = dataList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(v==null)
        {
            v  = inflater.inflate(R.layout.single_layout,parent,false);


        }

        TextView event =(TextView) v.findViewById(R.id.eventName);
        ImageView icon= (ImageView) v.findViewById(R.id.icon);
        event.setText(dataList.get(position).getEventName());
        icon.setImageResource(dataList.get(position).getIcon());

        return v;
    }
}
