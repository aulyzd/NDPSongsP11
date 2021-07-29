package sg.edu.rp.c346.id20014198.ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(Context context, int resource, ArrayList<Song>objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvtitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvyear = rowView.findViewById(R.id.textViewYear);
        RatingBar rating = rowView.findViewById(R.id.ratingBar2);
        TextView tvsinger = rowView.findViewById(R.id.textViewSinger);
        ImageView ivImage = rowView.findViewById(R.id.imageView);

        Song currentList = songList.get(position);



        tvtitle.setText(currentList.getTitle());
        rating.setRating(currentList.getStars());
        tvsinger.setText(currentList.getSingers());

        tvyear.setText(currentList.getYear()+"");
        if(currentList.getYear() >= 2019)
        {
            ivImage.setImageResource(R.drawable.newer);
        }
        else if (currentList.getYear() < 2019)
        {
            ivImage.setVisibility(View.INVISIBLE);
        }


        return rowView;

    }
}