package com.example.administrator.esexplorer;

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
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/9 0009.
 */

public class MyAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private Bitmap folder,file,back,home;

    private ArrayList<String> names = null;

    private ArrayList<String> paths = null;

    public MyAdapter(Context context,ArrayList<String> na,ArrayList<String> pa){
        names = na;
        paths = pa;
        home = BitmapFactory.decodeResource(context.getResources(),R.drawable.home);
        back = BitmapFactory.decodeResource(context.getResources(),R.drawable.back_button);
        folder = BitmapFactory.decodeResource(context.getResources(), R.drawable.folder);
        file = BitmapFactory.decodeResource(context.getResources(), R.drawable.un_know);
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if (null == convertView){
            convertView = inflater.inflate(R.layout.file, null);
            holder = new ViewHolder();
            holder.text = (TextView)convertView.findViewById(R.id.textView);
            holder.image = (ImageView)convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        File f = new File(paths.get(position).toString());
        if (names.get(position).equals("@1")){
            holder.text.setText(R.string.get_background);
            holder.image.setImageBitmap(home);
        }
        else if (names.get(position).equals("@2")){
            holder.text.setText(R.string.get_back);
            holder.image.setImageBitmap(back);
        }
        else{
            holder.text.setText(f.getName());
            if (f.isDirectory()){
                holder.image.setImageBitmap(folder);
            }
            else if (f.isFile()){
                holder.image.setImageBitmap(file);
            }
            else{
                System.out.println(f.getName());
            }
        }
        return convertView;
    }
    private class ViewHolder{
        private TextView text;
        private ImageView image;
    }

}
