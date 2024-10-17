package MVC.Ablum.Manager;

import java.util.List;

public interface Imanager<T>{
    void add(T t);

    void delete(int id);

    void update(int id, T t);

    List<T> getAll();

    int findIndexById(int id);
}
