package com.example.projectaac;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class GridSymbolAdapter extends BaseAdapter {
    ArrayList<SymbolListItem> items = new ArrayList<SymbolListItem>();
    Context context;

    public void addItem(SymbolListItem item){
        items.add(item);
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        SymbolListItem listItem = items.get(position);

        if(convertView ==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_symbol, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.symbolImage);
        TextView nameView = convertView.findViewById(R.id.symbolName);

        Bitmap imgBitmap = BitmapFactory.decodeFile(listItem.getImagePath());
        imageView.setImageBitmap(imgBitmap);
        nameView.setText(listItem.getName());

        return convertView;
    }

}
