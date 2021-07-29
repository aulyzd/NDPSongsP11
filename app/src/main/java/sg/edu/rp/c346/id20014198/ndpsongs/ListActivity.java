package sg.edu.rp.c346.id20014198.ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    Button btnshowstars;
    Spinner spyear;
    ListView lv;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    ArrayList<String> years;
    ArrayAdapter<String> ab;
    CustomAdapter Adapter;

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Song> al2;
        DBHelper db = new DBHelper(this);
        al2 = db.getAllSongs();
        al.clear();
        al.addAll(al2);
        Adapter.notifyDataSetChanged();
        years.clear();
        years.addAll(db.getYears());
        ab.notifyDataSetChanged();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnshowstars = findViewById(R.id.btnshowstars);
        spyear = findViewById(R.id.spYear);
        lv = findViewById(R.id.lv);




        DBHelper dbh = new DBHelper(this);
        al = dbh.getAllSongs();
        years = dbh.getYears();

        dbh.close();


        Adapter = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(Adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListActivity.this, UpdateActivity.class);
                i.putExtra("data", al.get(position));
                startActivity(i);
            }
        });

        btnshowstars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ListActivity.this);
                al.clear();
                al.addAll(dbh.getAllSongsByStars(5));
                Adapter.notifyDataSetChanged();
            }
        });


        ab = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, years);
        spyear.setAdapter(ab);

        spyear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DBHelper dbh = new DBHelper(ListActivity.this);
                al.clear();
                al.addAll(dbh.getAllSongsByYear(Integer.valueOf(years.get(position))));
                Adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }



}