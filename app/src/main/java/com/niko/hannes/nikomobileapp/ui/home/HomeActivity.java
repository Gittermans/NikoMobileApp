package com.niko.hannes.nikomobileapp.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.niko.hannes.nikomobileapp.R;
import com.niko.hannes.nikomobileapp.framework.IListItemClickListener;
import com.niko.hannes.nikomobileapp.framework.Logger;
import com.niko.hannes.nikomobileapp.model.Avatar;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity implements IListItemClickListener {


    private Logger mLogger = new Logger(HomeActivity.class.getSimpleName());
    private Toolbar mToolbar;
    private RecyclerView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        bindListView();

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello Snackbar", Snackbar.LENGTH_LONG).show();
            }
        });

        setupToolbar();

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


    private void bindListView() {

        List<MenuItemVM> menuitems = new ArrayList<MenuItemVM>();
        menuitems.add(new MenuItemVM("Hannes", "Senior software developer", Avatar.ONE));
        menuitems.add(new MenuItemVM("Kenneth", "Senior software developer", Avatar.TWO));
        menuitems.add(new MenuItemVM("Bjorn", "Senior software developer", Avatar.THREE));
        menuitems.add(new MenuItemVM("Peter", "Senior software developer", Avatar.FOUR));
        menuitems.add(new MenuItemVM("Tony", "Software tester", Avatar.FIVE));
        menuitems.add(new MenuItemVM("Erik", "Software manager", Avatar.SIX));
        menuitems.add(new MenuItemVM("Koen", "SoftwareMaster Architect", Avatar.SEVEN));
        menuitems.add(new MenuItemVM("Christope", "Mobile Architect", Avatar.EIGHT));
        menuitems.add(new MenuItemVM("Joris", "Hardware Architect", Avatar.NINE));
        menuitems.add(new MenuItemVM("Luc", "Lead Designer", Avatar.TEN));
        menuitems.add(new MenuItemVM("Johan", "Customer support engineer", Avatar.ELEVEN));
        menuitems.add(new MenuItemVM("Niels", "Customer support engineer", Avatar.TWELVE));
        menuitems.add(new MenuItemVM("Blowser", "A chinese browser", Avatar.THIRTEEN));
        menuitems.add(new MenuItemVM("Toad", "Just a nice guy", Avatar.FOURTEEN));
        menuitems.add(new MenuItemVM("Wim", "Integration test expert", Avatar.FIFTEEN));
        menuitems.add(new MenuItemVM("Mario", "Super high jumper", Avatar.TWELVE));
        MenuListAdapter adapter = new MenuListAdapter(this, menuitems);
        adapter.setOnItemClickListener(this);

        mlistView = (RecyclerView) findViewById(R.id.home_menu_list);
        mlistView.setLayoutManager(new LinearLayoutManager(this));
        mlistView.setAdapter(adapter);
        //mlistView.setOnClickListener();
    }

    @Override
    public void onListItemClick(View v, int position) {
        Toast.makeText(this, "onListItemClick !: " + position, Toast.LENGTH_SHORT).show();
    }


    private void setupToolbar() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        // Show menu icon
        final ActionBar ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        //ab.setDisplayHomeAsUpEnabled(true);
    }


   /* private void setupCollapsingToolbarLayout() {
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolBarLayout);
        if (mCollapsingToolbarLayout != null) {
            mCollapsingToolbarLayout.setTitle(getResources().getString(R.string.app_name));
        }
    }*/

}
