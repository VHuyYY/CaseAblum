package MVC.Ablum.Model;

public class Song {
    private int songID;
    private String songName;
    private String writter;
    private int year;
    private String genre;

    public Song(int songID, String songName, String writter, int year, String genre) {
        this.songID = songID;
        this.songName = songName;
        this.writter = writter;
        this.year = year;
        this.genre = genre;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "songModel{" +
                "songID=" + songID +
                ", songName='" + songName + '\'' +
                ", writter='" + writter + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
