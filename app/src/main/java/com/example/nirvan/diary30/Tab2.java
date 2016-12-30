package com.example.nirvan.diary30;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Tab2 extends Fragment
{
    static EditText text;
    static Button saveButton;
    static DatabaseHandler db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        setRetainInstance(false);
        final View rootView;
        rootView= inflater.inflate(R.layout.fragment_tab2, container, false);
        text=(EditText) rootView.findViewById(R.id.text);
        saveButton=(Button) rootView.findViewById(R.id.saveButton);
        db = new DatabaseHandler(rootView.getContext());




        /*    //display saved content
        if(db.isPresent(MainActivity.itemPosition) == false)
            text.setText("Blank ");
        else
            text.setText((db.getContact(MainActivity.itemPosition)).name);   */

        /*//save Button
        View.OnClickListener saveButtonClickListener=new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
              if(db.isPresent(MainActivity.itemPosition) == false)
              {
               Contact temp=new Contact(MainActivity.itemPosition, text.getText().toString());
               db.addContact(temp);
              }
              else
              {
                  Contact temp=new Contact(MainActivity.itemPosition, text.getText().toString());
                  db.updateContact(temp);
              }
            }
        };

        saveButton.setOnClickListener(saveButtonClickListener);   */


        return rootView;
    }




}
