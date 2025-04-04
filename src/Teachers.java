import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Teachers {
    public static void main(String[] args) {
        int total = 0;
        int score = 0;
        ArrayList<String> fileData = getFileData("src/teachers");
        //String[] splitSample = sample.split(" ");
        ArrayList<String> leftt = new ArrayList<>();
        ArrayList<String> rightt = new ArrayList<>();
        for(int i = 0; i < fileData.size(); i ++){
            int len = fileData.size();
            String[] list = fileData.get(i).split("\\|");
            String teacher_name = list[0];
            leftt.add(teacher_name);
        }
        for(int i = 0; i < fileData.size(); i ++){
            int len = fileData.size();
            String[] list = fileData.get(i).split("\\|");
            String Department = list[1];
            rightt.add(Department);
        }
        for(int i = 0; i < fileData.size(); i ++){
            System.out.println(rightt.get(i));
            System.out.println(leftt.get(i));
        }
    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}