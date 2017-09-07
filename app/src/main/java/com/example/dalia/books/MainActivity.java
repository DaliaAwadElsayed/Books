package com.example.dalia.books;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dalia.books.BooksDataModel.Books;
import com.example.dalia.books.BooksDataModel.Item;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    Adapter bookAdapter;
    List<Item> itemsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tag = "", message = "";
        Log.d(tag, message);
        listview = (ListView) findViewById(R.id.ls);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.googleapis.com/books/v1/volumes?q=android";
        final Gson gson = new Gson();
/*// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonobject=new JSONObject(response);
                            JSONArray jsonarray=jsonobject.getJSONArray("results");
                            itemdatamodel=gson.fromJson(jsonarray.toString(),Item[].class);
                            bookadapter =new Adapter(getApplicationContext(),itemdatamodel);
                            listview.setAdapter(bookadapter);
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // mTextView.setText("That didn't work!");
                Toast.makeText(MainActivity.this, " Error please check ur internet connection :) ", Toast.LENGTH_LONG).show();
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);*/
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Toast.makeText(MainActivity.this, latitude+longitude, Toast.LENGTH_SHORT).show();
                        Books books = gson.fromJson(response, Books.class);
                        itemsArrayList = books.getItems();
                        bookAdapter = new Adapter(MainActivity.this, (ArrayList<Item>) itemsArrayList);
                        listview.setAdapter(bookAdapter);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
