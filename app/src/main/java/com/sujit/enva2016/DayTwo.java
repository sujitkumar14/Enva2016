package com.sujit.enva2016;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import android.content.res.Resources;

public class DayTwo extends Fragment {




    SimpleDateFormat dateFormat;
    private RecyclerView mRecyclerView;
    ArrayList<EventClass> dataList;
    RecyclerEventAdapter recyclerEventAdapter;
    LinearLayoutManager linearLayoutManager;
    CardView eventCard;
    TextView onlineEventName,onlineEventDate;
    ImageView onlineIcon;
    Resources resources;
    String onlineEvent[],onlineDate[],fee[];
    int icon[];



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)  {

        View v = inflater.inflate(R.layout.fragment_day_two, container, false);
        //initializing RecyclerView object;
        mRecyclerView = (RecyclerView) v.findViewById(R.id.events);
        //setting recyclerview size
        mRecyclerView.setHasFixedSize(true);

        //initializing linearLayoutManager reference variable.

        linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //  mStaggeredLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        // mRecyclerView.setLayoutManager(mStaggeredLayoutManager);






        //array list of objects of eventsClass
        dataList = new ArrayList<EventClass>();


        //intialzing resource
        resources = getResources();


        //initializing  event array
        //taking event name and description from resources
       onlineEvent = resources.getStringArray(R.array.onlineEvent);


        //defining icon array
        icon = new int[]{R.drawable.naturethroghlense};

        //taking date from resource
       onlineDate = resources.getStringArray(R.array.onlineEventDate);
        fee = resources.getStringArray(R.array.onlineRegistrationFee);


        //adding resources in eventClass object
        for(int i=0;i<onlineEvent.length;i++)
        {

            dataList.add(new EventClass(icon[i],onlineEvent[i],onlineDate[i],fee[i]));

        }


        //setting view for fragment
        recyclerEventAdapter = new RecyclerEventAdapter(dataList,getActivity(),getActivity());
        //setting adapter
        mRecyclerView.setAdapter(recyclerEventAdapter);




        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser)
        {
            MainActivity.className =2;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);

        //Toast.makeText(getActivity().getApplicationContext(),"menu create",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {

            case R.id.register:
                Intent i = new Intent(getActivity().getApplicationContext(), Registration.class);
                startActivity(i);
                return true;
            case R.id.aboutEnva:
                Intent k = new Intent(getActivity().getApplicationContext(), aboutEnva.class);
                startActivity(k);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }


    }
}
