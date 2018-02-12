package com.sujit.enva2016;

import android.app.Activity;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Rajkumar on 01-12-2016.
 */
public class RecyclerEventAdapter extends RecyclerView.Adapter<RecyclerEventAdapter.EventViewHolder> {

    ArrayList<EventClass> list = new ArrayList<>();

    static Context context;
    Activity activity;
    RecyclerEventAdapter(ArrayList<EventClass> list,Context context,Activity activity)
    {
        this.list = list;
        this.context =context;
        this.activity = activity;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_layout,parent,false);
        EventViewHolder eventViewHolder = new EventViewHolder(v);
       return eventViewHolder;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, final int position) {


        holder.event.setText(list.get(position).getEventName());
        holder.date.setText(list.get(position).getDate());
        holder.fee.setText(list.get(position).getFee());

        new IconAsyncTask(holder.icon).execute(list.get(position).getIcon());



        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context.getApplicationContext(),DescriptionClass.class);
                i.putExtra("position", position);
                context.startActivity(i);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class EventViewHolder extends RecyclerView.ViewHolder
    {
        CardView cardHolder;
        ImageView icon;
        TextView event;
        TextView date,fee;

        public EventViewHolder(View itemView) {
            super(itemView);

            cardHolder = (CardView) itemView.findViewById(R.id.eventCard);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            event  = (TextView) itemView.findViewById(R.id.eventName);
            date = (TextView) itemView.findViewById(R.id.date);
            fee = (TextView) itemView.findViewById(R.id.fee);
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/Cantarell-BoldOblique.ttf");

            event.setTypeface(typeface);




        }
    }
}

class IconAsyncTask extends AsyncTask<Integer,Void,Integer>
{
    ImageView imageView;

    IconAsyncTask(ImageView imageView)
    {
        this.imageView = imageView;
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        publishProgress();
        return params[0];
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        imageView.setImageResource(R.drawable.prakriti);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        imageView.setImageResource(integer);
    }
}