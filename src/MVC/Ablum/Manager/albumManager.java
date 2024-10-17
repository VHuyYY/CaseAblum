package MVC.Ablum.Manager;

import MVC.Ablum.Model.Album;

import java.util.ArrayList;
import java.util.List;

public class albumManager implements Imanager<Album>{
    List<Album> albumList;

    @Override
    public void add(Album album) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Album album) {

    }

    @Override
    public List<Album> getAll() {
        return List.of();
    }

    @Override
    public int findIndexById(int id) {
        return 0;
    }
}
