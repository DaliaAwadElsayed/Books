package com.example.dalia.books;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dalia.books.BooksDataModel.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Item> {

    public Adapter(Context context, ArrayList<Item> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Item item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bookrow, parent, false);
        }

        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.booknameid);
        TextView writer = (TextView) convertView.findViewById(R.id.writerid);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageid);


        // Populate the data into the template view using the data object
        if (item.getVolumeInfo().getTitle() != null) {

            name.setText(item.getVolumeInfo().getTitle());}
        else {
            name.setText("title not Found!");
        }
        if (item.getVolumeInfo().getAuthors() != null) {

            writer.setText(item.getVolumeInfo().getPublisher());}
        else {
            writer.setText("descrption not Found!");
        }
        if (item.getVolumeInfo().getReadingModes().getImage() != null ) {
            Picasso.with(getContext()).load(item.getVolumeInfo().getImageLinks().getSmallThumbnail()+item.getVolumeInfo().getImageLinks().getThumbnail()).into(img);

        }


        return convertView;


    }}
