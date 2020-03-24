package com.example.android.sellchometz;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.sellchometz.data.Check;

import java.util.ArrayList;

/**
 * Created by Home on 5/8/2017.
 */

public class PlaceAdapter extends ArrayAdapter<Check> {

    public PlaceAdapter(Activity context, ArrayList<Check>places){
        super(context,0,places);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.check_style, parent, false);
        }
        Check currentWord = getItem(position);
        TextView names = (TextView) listItemView.findViewById(R.id.check);
        names.setText((CharSequence) currentWord.getRabbi());
        TextView text = (TextView) listItemView.findViewById(R.id.text);
        text.setText(currentWord.getEmail());
        return listItemView;
    }}
