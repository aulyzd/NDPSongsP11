package sg.edu.rp.c346.id20014198.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private int _id;
    private String title;
    private String singers;
    private int year;
    private float stars;

    public Song(int _id, String title, String singers, int year, float stars) {
        this._id = _id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public Song( String title, String singers, int year, float stars) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSingers() {
        return singers;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getStars() {

        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {

        return "ID: " + _id + "\nTitle: "+ title + "\nSingers: " + singers+ "\nYear: " + year + "\nStars: " + stars;

    }
}
