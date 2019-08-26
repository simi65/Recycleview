package com.miss.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdapterMovie adapterMovie;

    RecyclerView recyclerView;
    Toolbar toolbar;
    ArrayList<ModelMovie> arrayList;

    private String[] judul = {"Seribu satu orang hebat", "temukan jati dari di sani ", "Siapa saya ini"};
    private String[] subjudl = {"orang Hebat", "Pejuang dakwah", "petani kode"};
    private int[] gambar = {R.drawable.dzizkir, R.drawable.ic_search_black_24dp, R.drawable.ic_search_black_24dp};
    private int[] logo = {R.drawable.dzizkir, R.drawable.ic_search_black_24dp, R.drawable.ic_search_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);
        arrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.rvMain);
        setData();
        adapterMovie = new AdapterMovie(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterMovie);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView  searchView = (SearchView) menuItem.getActionView();
        search(searchView);
        return super.onCreateOptionsMenu(menu);
    }

    private void search (SearchView searchView){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (adapterMovie!=null) adapterMovie.getFilter().filter(s);
                return  true;

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

    private void setData() {
        int count = 0;
        for (String id : judul) {
            arrayList.add(new ModelMovie(id, subjudl[count], gambar[count], logo[count]));
            count++;
        }
    }
}
