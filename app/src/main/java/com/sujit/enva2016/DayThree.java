package com.sujit.enva2016;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class DayThree extends Fragment {





    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    ArrayList<EventClass> dataList;
    Resources resources;
    RecyclerEventAdapter recyclerEventAdapter;
    boolean gridLayout = false;
    LinearLayoutManager linearLayoutManager;

    String eventThree[];

    static int icon[];
    String dateThree[],fee[];


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);




        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_day_three, container, false);

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
        eventThree = resources.getStringArray(R.array.eventThree);


        //defining icon array
        icon = new int[]{R.drawable.greeky,R.drawable.amazingrace,R.drawable.rangoli,R.drawable.rajneeti,R.drawable.armwrestling,R.drawable.footpool
        ,R.drawable.tasviroshayri,R.drawable.openmic,R.drawable.rajyasabha,R.drawable.mindgrind,R.drawable.nukkadnatak};

        //taking date from resource
        dateThree = resources.getStringArray(R.array.dateThree);
        fee = resources.getStringArray(R.array.registrationFeeThree);


        //adding resources in eventClass object
        for(int i=0;i<eventThree.length;i++)
        {

            dataList.add(new EventClass(icon[i],eventThree[i],dateThree[i],fee[i]));

        }


        //setting view for fragment
        recyclerEventAdapter = new RecyclerEventAdapter(dataList,getActivity(),getActivity());
        //setting adapter
        mRecyclerView.setAdapter(recyclerEventAdapter);


    //    Log.d("frag", "oncreateview is called" + RecyclerEventAdapter.className);

        return v;
    } //end of daythree class

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
           MainActivity.className = 3;
        }


    }
}
