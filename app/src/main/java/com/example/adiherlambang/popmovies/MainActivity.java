package com.example.adiherlambang.popmovies;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //View container = (View) findViewById(R.id.container);
        //RecyclerView list_movies = (RecyclerView)findViewById(R.id.list_movies);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        PlaceholderFragment fragment = new PlaceholderFragment();
        ft.add(R.id.listItem,fragment);
        ft.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public static class PlaceholderFragment extends Fragment {

            ArrayAdapter mforecast;

            public PlaceholderFragment(){
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                    Bundle savedInstanceState){

                View rootView = inflater.inflate(R.layout.fragment_main,container,false);

                String[] data = {
                        "Mon 6/23 - Sunny - 31/17",
                        "Tue 6/24 - Foggy - 21/8",
                        "Wed 6/25 - Cloudy - 22/17",
                        "Thurs 6/26 - Rainy - 18/11",
                        "Fri 6/27 - Foggy - 21/10",
                        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
                        "Sun 6/29 - Sunny - 20/7"
                };
                List <String> Forecast = new ArrayList <> (Arrays.asList(data));

                mforecast = new ArrayAdapter<>(
                        getActivity(),
                        R.layout.list_item_movies,
                        R.id.list_item_movies_textview,
                        Forecast);

                ListView listView = (ListView) rootView.findViewById(R.id.listItem);
                listView.setAdapter(mforecast);

                //return (inflater.inflate(R.layout.activity_main,container,false));

                return rootView;
            }

    }

    /*class Movies{
        String title;
        String genre;
        int photo;

        Movies(String title,String genre,int photo){
            this.title=title;
            this.genre=genre;
            this.photo=photo;
        }

    }
    private List<Movies> movies_list;

    private void initializeData(){
        movies_list = new ArrayList<>();
        movies_list.add(new Movies("The Avanger Return", "Action", R.drawable.theavengers));
        movies_list.add(new Movies("Love", "Romantic", R.drawable.love));
        movies_list.add(new Movies("Destiny", "Fantasy", R.drawable.destiny));
    }
*/

}