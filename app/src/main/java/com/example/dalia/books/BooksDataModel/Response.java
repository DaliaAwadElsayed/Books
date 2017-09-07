package com.example.dalia.books.BooksDataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dina on 9/6/2017.
 */


    public class Response {

        @SerializedName("venues")
        @Expose
        private List<Item> items = null;

        public List<Item> getVenues() {
            return items;
        }

        public void setVenues(List<Item> venues) {
            this.items = venues;
        }

    }


