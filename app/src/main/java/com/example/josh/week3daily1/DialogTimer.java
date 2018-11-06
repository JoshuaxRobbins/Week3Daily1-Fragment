package com.example.josh.week3daily1;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.TextView;

import com.example.josh.week3daily1.fragments.MyDialogFragment;

public class DialogTimer extends AsyncTask<String,Integer,String> {
    public static final String TAG = "_TAG";
    MyDialogFragment myDialogFragment;
    FragmentManager fragmentManager;

    public DialogTimer(MyDialogFragment myDialogFragment, FragmentManager fragmentManager) {
        this.myDialogFragment = myDialogFragment;
        this.fragmentManager = fragmentManager;
    }


    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground: " + TAG);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentManager.beginTransaction().remove(myDialogFragment);
        fragmentManager.popBackStack();

        return "Closed Dialog";
    }
}
