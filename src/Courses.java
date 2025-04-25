import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Courses {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<String> all_courses = new ArrayList<>();
        ArrayList<String> data = getFileData("src/courses");

        ArrayList<String> fileData = getFileData("src/courses");
        ArrayList<String> course = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            String name = fileData.get(i);
            course.add(name);
        }
        String[] types = {"AP", "Regents", "Elective"};
        for (int i = 1; i <= course.size(); i++) {
            if (course.get(i - 1).contains("AP") && !course.get(i - 1).contains("Pre-AP")) {
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + course.get(i - 1) + "', " + 1 + ");");
            } else if (course.get(i - 1).contains("Regents")) {
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + course.get(i - 1) + "', " + 2 + ");");
            } else {
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + course.get(i - 1) + "', " + 3 + ");");
            }
        }
    }
    int typeid;
    int courseid;

    String name;
    public Courses(int courseid, String name, int typeid){
        this.name = name;
        this.courseid = courseid;
        this.typeid = typeid;
    }

    public int getCourseid() {
        return courseid;
    }

    public int getTypeid() {
        return typeid;
    }

    public String getName() {
        return name;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
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
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}