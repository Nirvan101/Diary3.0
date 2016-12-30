package com.example.nirvan.diary30;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Tab1 extends Fragment
{




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        final View rootView;
        rootView=inflater.inflate(R.layout.fragment_tab1, container, false);

        //listView
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        String[] values=new String[]{
                "First",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View",
                "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View",
                "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Last"
        };
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(rootView.getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {

                // ListView Clicked item index
                 MainActivity.itemPosition     = position;

                // ListView Clicked item value
               // String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                //Toast.makeText(rootView.getContext().getApplicationContext(), " d ").show();

            }

        });

        return rootView;
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    } */

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    { /*
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.item1:
                Toast.makeText(this, "Item1 selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.item2:
                Toast.makeText(this, "Item2", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }*/

        return true;
    }


}
