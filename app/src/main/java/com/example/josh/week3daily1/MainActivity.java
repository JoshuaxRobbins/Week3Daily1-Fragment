package com.example.josh.week3daily1;

import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.josh.week3daily1.fragments.MyDialogFragment;
import com.example.josh.week3daily1.fragments.MyListFragment;
import com.example.josh.week3daily1.fragments.MyPreferenceFragment;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.OnFragmentInteractionListener {

    FrameLayout fragmentHolder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Test");
        ActionBar actionbar = getSupportActionBar();
        fragmentHolder1 = findViewById(R.id.fragmentHolder1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return true;
    }
    @Override
    public void onFragmentInteraction(String data) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String textSize;
        switch (item.getItemId()) {

            case R.id.action_Dialog:
                addDialogFragment();
                return true;
            case R.id.action_List:
                addToList();
                return true;

            case R.id.action_Preferences:
                showPreferences();
                return true;


        }
        return super.onOptionsItemSelected(item);

    }

    public void addToList() {
        MyListFragment myListFragment = (MyListFragment) getSupportFragmentManager().findFragmentByTag(MyListFragment.TAG);
        if (myListFragment == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentHolder1,new MyListFragment()).addToBackStack(MyListFragment.TAG).commit();
        }
    }

    public void addDialogFragment(){

        MyDialogFragment myDialogFragment = (MyDialogFragment) getSupportFragmentManager().findFragmentByTag(MyDialogFragment.TAG);
        if (myDialogFragment == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentHolder1,MyDialogFragment.newInstance("Dialog Fragment"))
                    .addToBackStack(MyDialogFragment.TAG).commit();
        }
        DialogTimer dialogTimer = new DialogTimer(myDialogFragment,getSupportFragmentManager());
        dialogTimer.execute("Start Timer");
    }

    public void showPreferences(){
        MyPreferenceFragment myPreferenceFragment = (MyPreferenceFragment) getSupportFragmentManager().findFragmentByTag(MyPreferenceFragment.TAG);
        if (myPreferenceFragment == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentHolder1, new MyPreferenceFragment()).addToBackStack(MyPreferenceFragment.TAG)
                    .commit();
        }
    }
}
