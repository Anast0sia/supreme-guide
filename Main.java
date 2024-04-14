import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        GameProgress gp = new GameProgress(10, 6, 22, 12);
        GameProgress gp1 = new GameProgress(2, 9, 7, 20);
        GameProgress gp2 = new GameProgress(40, 17, 31, 16);
        saveGame("C://Users/anast/IdeaProjects/untitled25/Games/savegames/save1.dat", gp);
        saveGame("C://Users/anast/IdeaProjects/untitled25/Games/savegames/save2.dat", gp1);
        saveGame("C://Users/anast/IdeaProjects/untitled25/Games/savegames/save3.dat", gp2);
        zipFiles("C://Users/anast/IdeaProjects/untitled25/Games/savegames/zip.zip", list);
    }

    public static void saveGame(String fileName, GameProgress gp) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(gp);
            list.add(fileName);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void zipFiles(String zipName, List<String> fileNames) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipName))) {
            for (String fileName : fileNames) {
                try (FileInputStream fis = new FileInputStream(fileName)) {
                    ZipEntry entry = new ZipEntry(fileName);
                    zos.putNextEntry(entry);
                    int i;
                    byte[] buffer = new byte[1024];
                    while ((i = fis.read()) != -1) {
                        zos.write(buffer, 0, i);
                    }
                    zos.closeEntry();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        for (String fileName : fileNames) {
            new File(fileName).delete();
        }
    }
}