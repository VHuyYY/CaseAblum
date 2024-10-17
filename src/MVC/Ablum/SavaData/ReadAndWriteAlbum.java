package MVC.Ablum.SavaData;

import MVC.Ablum.Model.Album;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteAlbum {
    private File file = new File("C:\\Module_2\\CaseStudy\\src\\MVC\\Ablum\\Database\\AlbumData.csv");

    public void WriteAlbum(List<Album> albums) {
        try {
            String data = "";
            for (Album album : albums) {
                data += album.getId() + "," + album.getTitle() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Album> ReadAlbum() {
        List<Album> albums = new ArrayList<Album>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String title = data[1];
                Album album = new Album(id, title);
                albums.add(album);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return albums;
    }
}
