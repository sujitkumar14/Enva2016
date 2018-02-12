package com.sujit.enva2016;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    static int className  = 3;
    ListView list;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    EventAdapter eventAdapter;
    ArrayList<EventClass> dataList;
    Resources resources;
    RecyclerEventAdapter recyclerEventAdapter;
   MenuItem menuItem;
    LinearLayoutManager linearLayoutManager;
    boolean gridLayout = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       MainActivity.className =3;


        setContentView(R.layout.activity_main);






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        toolbar.setTitle("Enva 2016");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        DatePagerAdapter datePagerAdapter = new DatePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(datePagerAdapter);
        viewPager.setCurrentItem(1);



        PagerTabStrip tabStrip = (PagerTabStrip) findViewById(R.id.title);





    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    public void menuItemClick(MenuItem item)
    {
        if(item.getItemId()==R.id.register) {
            Intent i = new Intent(getApplicationContext(), Registration.class);
            startActivity(i);
        }
        else
            if(item.getItemId()==R.id.aboutEnva)
            {
                Intent i = new Intent(getApplicationContext(),aboutEnva.class);
                startActivity(i);
            }





    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }
}
