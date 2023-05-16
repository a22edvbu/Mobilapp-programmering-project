package com.example.mobilapp_programmering_project;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener{
    private final String jsonURL = "https://mobprog.webug.se/json-api?login=a22edvbu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(jsonURL);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        ArrayList<RecycleItems> items = new ArrayList<>();

        Gson gson = new Gson();
        Type type = new TypeToken<List<Wonder>>() {}.getType();
        List<Wonder> WonderList = gson.fromJson(json, type);

        for (Wonder m: WonderList) {
            items.add(new RecycleItems(m.getName()));
        }
        RecycleAdapter adapter = new RecycleAdapter(this, items, new RecycleAdapter.OnClickListener() {
            @Override
            public void onClick(RecycleItems items) {
                Toast.makeText(MainActivity.this, items.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerView view = findViewById(R.id.mainRecycleView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }
}