package com.example.galgeleg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HighScoreAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private int mResource;

    //Override constructor
    public HighScoreAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    //Override getview, which is called every time a new list element is created
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Inflate the desired layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        //Input string is formatted like "10, Mike", therefor they are split before inserted
        String line = getItem(position);
        String[] tokens = line.split(", ");

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView points = (TextView) convertView.findViewById(R.id.points);

        name.setText(tokens[1]);
        points.setText(tokens[0]);

        return convertView;
    }
}
