package com.sujit.enva2016;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class DayFour extends Fragment {

    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    boolean gridLayout = false;
    ArrayList<EventClass> dataList;
    Resources resources;
    RecyclerEventAdapter recyclerEventAdapter;

    LinearLayoutManager linearLayoutManager;

    String eventFour[],fee[];

    static int icon[];
    String dateFour[];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_day_four, container, false);

        //initializing RecyclerView object;
        mRecyclerView = (RecyclerView) v.findViewById(R.id.events);
        //setting recyclerview size
        mRecyclerView.setHasFixedSize(true);
        //initializing linearLayoutManager reference variable.
        linearLayoutManager = new LinearLayoutManager(getActivity());
        //setting layoutManager
        mRecyclerView.setLayoutManager(linearLayoutManager);


        //array list of objects of eventsClass
        dataList = new ArrayList<EventClass>();


        //intialzing resource
        resources = getResources();


        //initializing  event array
        //taking event name and description from resources
        eventFour = resources.getStringArray(R.array.eventsFour);

        //defining icon array
        icon = new int[]{R.drawable.greenovation,R.drawable.tattoomaking,R.drawable.mysteryrooms,R.drawable.streetdance,R.drawable.gothnpunk
        ,R.drawable.mindgrind,R.drawable.creativewriting};

        //taking date from resource
        dateFour = resources.getStringArray(R.array.dateFour);
        fee = resources.getStringArray(R.array.registrationFeeFour);

        //adding resources in eventClass object
        for(int i=0;i<eventFour.length;i++)
        {

            dataList.add(new EventClass(icon[i],eventFour[i],dateFour[i],fee[i]));

        }


        //setting view for fragment
        recyclerEventAdapter = new RecyclerEventAdapter(dataList,getActivity(),getActivity());
        //setting adapter
        mRecyclerView.setAdapter(recyclerEventAdapter);




        return v;
    } //end of daythree class

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);

       // Toast.makeText(getActivity().getApplicationContext(), "menu create", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.gridLayout:
                if(gridLayout ==false)
                {
                    mStaggeredLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                    mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
                    gridLayout = true;
                    item.setIcon(R.drawable.view_day);
                }
                else
                {
                    linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                    mRecyclerView.setLayoutManager(linearLayoutManager);
                    gridLayout = false;
                    item.setIcon(R.drawable.view_grid);
                }
                return true;
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
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser)
        {
           MainActivity.className = 4;
        }


    }


}
