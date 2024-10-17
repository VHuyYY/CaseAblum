package MVC.Ablum.SavaData;

import MVC.Ablum.Model.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteSong {
    private File file = new File("C:\\Module_2\\CaseStudy\\src\\MVC\\Ablum\\Database\\SongData.csv");

    public void WriterSong(List<Song> songs) {
        try {
            String data = "";
            for (Song song : songs) {
                data += song.getSongID() + "," + song.getSongName() + "," + song.getWritter() + "," + song.getYear() + "," + song.getGenre() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Song> ReadSong() {
        List<Song> songs = new ArrayList<Song>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int songID = Integer.parseInt(data[0]);
                String songName = data[1];
                String writter = data[2];
                int year = Integer.parseInt(data[3]);
                String genre = data[4];
                Song song = new Song(songID, songName, writter, year, genre);
                songs.add(song);
            }
        } catch (IOException e) {
            System.out.println("e");
        }
        return songs;
    }
}
