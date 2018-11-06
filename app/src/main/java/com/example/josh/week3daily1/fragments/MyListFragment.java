package com.example.josh.week3daily1.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.josh.week3daily1.ListViewAdapter;
import com.example.josh.week3daily1.R;
import com.example.josh.week3daily1.models.PersonGenerator;

public class MyListFragment extends ListFragment {

    public static final String TAG = MyListFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = new ListViewAdapter(getActivity().getApplicationContext(),R.layout.listview_items,PersonGenerator.generatePerson(getActivity()));
        setListAdapter(adapter);
    }

}
