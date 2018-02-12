package com.sujit.enva2016;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
/**
 * Created by Rajkumar on 01-10-2016.
 */
public class DescriptionClass extends AppCompatActivity {

    TextView envaFirst,envaSecond; //first and second para of description
    Resources resources;
    Toolbar toolbar;
   String description[]; //first para of description
    String descriptionSecond[]; //second para;
    String eventName[]; //used to display title name in the toolbar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.description_layout);

        overridePendingTransition(R.anim.left_in, R.anim.left_out);


        toolbar = (Toolbar) findViewById(R.id.descriptionToolbar);

        int position = getIntent().getIntExtra("position",0);
        resources = getResources();

        //setting className for data retrieval
        if(MainActivity.className==2)
        {
            eventName = resources.getStringArray(R.array.onlineEvent);
        }

        else if(MainActivity.className==3)
            eventName = resources.getStringArray(R.array.eventThree);
        else
            eventName = resources.getStringArray(R.array.eventsFour);

        envaFirst = (TextView) findViewById(R.id.envaFirst);
        envaSecond = (TextView) findViewById(R.id.envaSecond);




        toolbar.setTitle(eventName[position]);
        toolbar.setNavigationIcon(R.drawable.arrow_left);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new Toolbar.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);

            }
        });

        if(MainActivity.className==2)
        {
            description = resources.getStringArray(R.array.onlineDescriptionOne);
            descriptionSecond = resources.getStringArray(R.array.onlineDescriptionTwo);

        }

        else if(MainActivity.className ==3) {
            description = resources.getStringArray(R.array.descriptionThree);
            descriptionSecond = resources.getStringArray(R.array.description2Threee);
        }
        else
        {
            description  = resources.getStringArray(R.array.descriptionFour);
            descriptionSecond = resources.getStringArray(R.array.description2Four);
        }


        envaFirst.setText(description[position]);
        envaSecond.setText(descriptionSecond[position]);
        if(eventName[position].equals("Nature Through Lens"))
        {
           envaSecond.setPaintFlags(envaSecond.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            envaSecond.setText(descriptionSecond[position]);

                    envaSecond.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "https://www.facebook.com/msitprakriti/";
                    Intent i  = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_description,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public void descriptionMenuItemClick(MenuItem item)
    {
        Intent i = new Intent(getApplicationContext(),Registration.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.right_in,R.anim.right_out);
    }
}
