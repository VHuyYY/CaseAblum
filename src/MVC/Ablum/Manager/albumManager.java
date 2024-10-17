package MVC.Ablum.Manager;

import MVC.Ablum.Model.Album;
import MVC.Ablum.SavaData.ReadAndWriteAlbum;

import java.util.ArrayList;
import java.util.List;

public class albumManager implements Imanager<Album> {
    List<Album> albumList;
    ReadAndWriteAlbum readAndWriteAlbum = new ReadAndWriteAlbum();

    public albumManager() {
        albumList = readAndWriteAlbum.ReadAlbum();
    }

    @Override
    public void add(Album album) {
        albumList.add(album);
        readAndWriteAlbum.WriteAlbum(albumList);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        albumList.remove(index);
        readAndWriteAlbum.WriteAlbum(albumList);
    }

    @Override
    public void update(int id, Album album) {
        int index = findIndexById(id);
        albumList.set(index, album);
        readAndWriteAlbum.WriteAlbum(albumList);
    }

    @Override
    public List<Album> getAll() {
        return this.albumList;
    }


    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < albumList.size(); i++) {
            if (albumList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
