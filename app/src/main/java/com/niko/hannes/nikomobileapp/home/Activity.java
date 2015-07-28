package com.niko.hannes.nikomobileapp.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.niko.hannes.nikomobileapp.R;
import com.niko.hannes.nikomobileapp.framework.Logger;


public class Activity extends android.app.Activity implements MenuFragment.OnFragmentInteractionListener {


    private Logger mLogger = new Logger(Activity.class.getSimpleName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar_main);
        setActionBar(toolBar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        mLogger.Debug("onCreateOptionsMenu");

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        mLogger.Debug("onOptionsItemSelected");

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
