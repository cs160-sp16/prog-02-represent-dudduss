package com.example.sampathduddu.eagleeye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by sampathduddu on 2/29/16.
 */
public class CongressCell extends ArrayAdapter {

    private ArrayList list = new ArrayList();

    public CongressCell(Context context, int resource) {
        super(context, resource);
    }


    public void add(Congressmen object) {
        list.add(object);
        super.add(object);
    }

    static  class imgHolder
    {
        ImageView img;
        ImageView twitterLogo;
        TextView name;
        TextView party;
        TextView email;
        TextView website;
        TextView tweet;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row = convertView;
        imgHolder holder;

        if(convertView == null) {


            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.congress_row, parent, false);

            holder = new imgHolder();
            holder.img = (ImageView) row.findViewById(R.id.congressman_img);
            holder.name = (TextView) row.findViewById(R.id.congressman_name);
            holder.party = (TextView) row.findViewById(R.id.party);
            holder.email = (TextView) row.findViewById(R.id.email);
            holder.website = (TextView) row.findViewById(R.id.website);
            holder.tweet = (TextView) row.findViewById(R.id.tweet);
            holder.twitterLogo = (ImageView) row.findViewById(R.id.twitter_logo);

            row.setTag(holder);

        } else {
            holder = (imgHolder) row.getTag();


        }

        Congressmen cg = (Congressmen) getItem(position);
        holder.img.setImageResource(cg.image_resource);

        holder.name.setText(cg.name);
        holder.party.setText(cg.party);
        holder.tweet.setText("\"" + cg.tweet + "\"");

        holder.email.setText("Email: " + cg.email);
        holder.website.setText("Website: " + cg.website);
        holder.twitterLogo.setImageResource(R.drawable.twitter_logo);

        return row;
    }


}
