package sg.edu.rp.c346.id20014198.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle, tvSinger, tvYear, tvStar;
    EditText etTitle, etSinger, etYear;
    Button btninsert, btnshow;
    RatingBar rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvSinger = findViewById(R.id.tvSingers);
        tvYear = findViewById(R.id.tvYear);
        tvStar = findViewById(R.id.tvStars);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        btninsert = findViewById(R.id.btnInsert);
        btnshow = findViewById(R.id.btnShow);
        rb = (RatingBar) findViewById(R.id.ratingBar);



        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                String stryear = etYear.getText().toString();
                int year = Integer.valueOf(stryear);
                float stars = getStars();

                DBHelper dbh = new DBHelper(MainActivity.this);
                etTitle.setText("");
                etSinger.setText("");
                etYear.setText("");
                dbh.insertSong(title, singer, year, stars);

            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });



    }
    private float getStars() {
        float stars = (int) rb.getRating();
        return stars;


    }
}