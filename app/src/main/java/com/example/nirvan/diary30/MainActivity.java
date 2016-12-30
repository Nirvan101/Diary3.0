package com.example.nirvan.diary30;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    public static int itemPosition;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private  List<Fragment> mFragmentLists = new ArrayList<>();

    @Override
    protected void onStart()
    {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(0);

        //
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {   //NOTE:The problem lies in addContact, getContact

                //testing to see whats wrong, remove this later
                 //Contact temp=new Contact(3, Tab2.text.getText().toString());
                 //This is the problem--->>>> Tab2.db.addContact(temp);
                // Tab2.text.setText(Tab2.db.isPresent(MainActivity.itemPosition)   ?  "true"  : "false");
                //thus, problem lies in isPresemt() or getContact




                //display saved content

                if(Tab2.db.isPresent(MainActivity.itemPosition) == false)
                   Tab2.text.setText("Blank ");
                else Tab2.text.setText((Tab2.db.getContact(MainActivity.itemPosition)).name);



                //
                //save Button

                View.OnClickListener saveButtonClickListener=new View.OnClickListener()
                {
                    @Override

                    public void onClick(View view)
                    {
                        if(Tab2.db.isPresent(MainActivity.itemPosition) == false)
                        {
                            Contact temp=new Contact(MainActivity.itemPosition, Tab2.text.getText().toString());
                            Tab2.db.addContact(temp);
                        }
                        else
                        {
                            Contact temp=new Contact(MainActivity.itemPosition, Tab2.text.getText().toString());
                            Tab2.db.updateContact(temp);
                        }
                    }
                };

                Tab2.saveButton.setOnClickListener(saveButtonClickListener);

                //


            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
        //


    }

    private void setupViewPager(ViewPager viewPager)
    {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1(), "ONE");
        adapter.addFragment(new Tab2(), "TWO");
        viewPager.setAdapter(adapter);
        mFragmentLists = adapter.getFragements();
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        public List<Fragment> getFragements()
        {
            return mFragmentList;
        }


        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
