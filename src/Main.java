import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        direct("Games");
        direct("Games/src");
        direct("Games/res");
        direct("Games/savegames");
        direct("Games/temp");
        direct("Games/src/main");
        direct("Games/src/test");
        file("Games/src/main/Main.java");
        file("Games/src/main/Utils.java");
        direct("Games/res/drawables");
        direct("Games/res/vectors");
        direct("Games/res/icons");
        file("Games/temp/temp.txt");
        try (FileWriter fw = new FileWriter("Games/temp/temp.txt")) {
            fw.write(sb.toString());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void direct(String name) {
        if (new File(name).mkdir()) {
            sb.append("Создана директория ").append(name).append('\n');
        } else {
            sb.append("Создание неуспешно \n");
        }
    }

    public static void file(String name) {
        try {
            if (new File(name).createNewFile()) {
                sb.append("Создана директория ").append(name).append('\n');
            } else {
                sb.append("Создание неуспешно \n");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}