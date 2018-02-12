package com.sujit.enva2016;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Rajkumar on 01-14-2016.
 */
public class aboutEnva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.about_enva);

        overridePendingTransition(R.anim.up_in,R.anim.up_out);

        Toolbar toolbar = (Toolbar) findViewById(R.id.envaToolbar);
        toolbar.setTitle("About Enva");
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.down_in,R.anim.down_out);
    }
}
