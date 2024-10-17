package MVC.Ablum.Manager;

import MVC.Ablum.Model.Song;
import MVC.Ablum.SavaData.ReadAndWriteSong;

import java.util.ArrayList;
import java.util.List;

public class songManager implements Imanager<Song> {
    List<Song> songList;
    ReadAndWriteSong readAndWriteSong = new ReadAndWriteSong();

    public songManager() {
        songList = readAndWriteSong.ReadSong();
    }

    @Override
    public void add(Song song) {
        songList.add(song);
        readAndWriteSong.WriterSong(songList);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        songList.remove(index);
        readAndWriteSong.WriterSong(songList);
    }

    @Override
    public void update(int id, Song song) {
        int index = findIndexById(id);
        songList.set(index, song);
        readAndWriteSong.WriterSong(songList);
    }

    @Override
    public List<Song> getAll() {
        return this.songList;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < this.songList.size(); i++) {
            if (this.songList.get(i).getSongID() == id) {
                return i;
            }
        }
        return -1;
    }

    public List<Song> searchName(String songName) {
        List<Song> result = new ArrayList<>();
        for (Song song : songList) {
            if (song.getSongName().toLowerCase().contains(songName.toLowerCase())) {
                result.add(song);
            }
        }
        return result;
    }
    public List<Song> searchGenre(String genre) {
        List<Song> result = new ArrayList<>();
        for (Song song : songList) {
            if (song.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                result.add(song);
            }
        }
        return result;
    }
}
