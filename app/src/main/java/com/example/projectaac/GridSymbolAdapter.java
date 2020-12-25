package com.example.projectaac;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class GridSymbolAdapter extends BaseAdapter {
    ArrayList<SymbolListItem> items = new ArrayList<SymbolListItem>();
    Context context;

    private int checkedItem;
    private boolean isAdapterChecked = false;


    public boolean isAdapterChecked() {return isAdapterChecked;}
    public void setAdapterChecked(boolean adapterChecked) {isAdapterChecked = adapterChecked; }

    public int getCheckedItem() { return checkedItem;}
    public void setCheckedItem(int position) {this.checkedItem = position;}

    public void addItem(SymbolListItem item){
        items.add(item);
    }
    public void addItem(SymbolListItem item, int position){items.add(position,item);}
    public void clear() {items.clear();}


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
        return items.get(position).ID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        SymbolListItem listItem = items.get(position);

        if(convertView ==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_symbol, parent, false);
        }
        LinearLayout layout = convertView.findViewById(R.id.symbolLayout);
        ImageView imageView = convertView.findViewById(R.id.symbolImage);
        TextView nameView = convertView.findViewById(R.id.symbolName);

        //Bitmap imgBitmap = BitmapFactory.decodeFile(listItem.getImagePath());
        //imageView.setImageBitmap(imgBitmap);
        //nameView.setText(listItem.getName());
        Glide.with(context).load(listItem.getImagePath()).into(imageView);

        //adapter의 원소를 클릭하면 배경색깔 초록색으로, 초록색을 다시 클릭하면 흰색으로,
        // 다른 원소를 클릭하면 기존원소는 흰색, 클릭한 원소는 초록색
        if(isAdapterChecked){
            if(position == checkedItem) {
                layout.setBackgroundColor(Color.GREEN);
            }else{
                layout.setBackgroundColor(Color.WHITE);
            }
        }else{
            layout.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }

}
