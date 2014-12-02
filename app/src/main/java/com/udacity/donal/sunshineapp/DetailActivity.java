package com.udacity.donal.sunshineapp;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;


public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailFragment detailFragment = new DetailFragment();
        Bundle fragmentBundle = new Bundle();
        Intent intent = getIntent();
        String weatherReport = intent.getStringExtra("weather");
        fragmentBundle.putString("weatherData", weatherReport);
        detailFragment.setArguments(fragmentBundle);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, detailFragment)
                    .commit();
        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class DetailFragment extends Fragment {

        public DetailFragment() {
        }
        private String weatherReport;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle = this.getArguments();
            if (bundle != null){
                this.weatherReport = bundle.getString("weatherData");
            };

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            /*
            instead of the global variable and passing the data to the fragment from the activity
             you can get the intent by doing the following.
            Intent intent = getActivity().getIntent();
            then check if intent is null or has data

            if (intent != null && intent.hasExtra("weather")){
                String weatherReport = intent.getStringExtra("weather");
                etc
            };
            */
            TextView weatherReport = (TextView) rootView.findViewById(R.id.weatherReport_textView);
            weatherReport.setText(this.weatherReport);
            return rootView;
        }
    }
}
