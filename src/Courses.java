import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Courses {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<String> all_courses = new ArrayList<>();
        ArrayList<Integer> offers = offering();
        ArrayList<String> data = getFileData("src/courses");
        ArrayList<String> rooms = room();

        ArrayList<String> fileData = getFileData("src/courses");
        ArrayList<String> course = new ArrayList<>();
        for(int i = 0; i < fileData.size(); i ++){
            String name = fileData.get(i);
            course.add(name);
        }
        String [] types = {"AP", "Regents", "Elective"};
        for(int i = 1; i <= course.size(); i ++){
            if(course.get(i-1).contains("AP") && !course.get(i-1).contains("Pre-AP")){
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + course.get(i-1) + "', " + 1 + ");");
            }
            else if(course.get(i-1).contains("Regents")){
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + course.get(i-1) + "', " + 2 + ");");
            }
            else {
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + course.get(i-1) + "', " + 3 + ");");
            }
        }



        ArrayList<Integer> randoms = new ArrayList<>();
        while (randoms.size() != 94) {
            int num = rand.nextInt(1, 7201);
            if (!randoms.contains(num)) {
                randoms.add(num);
            }
        }

        for (int o = 0; o < randoms.size(); o++) {
            String adder = rooms.get(randoms.get(o));
            data.set(o, data.get(o) + " " + adder);
        }

        for (int i = 0; i < 94; i++) {
            for (int j = 0; j < offers.get(i); j++) {
                all_courses.add(data.get(i));
            }
        }
        System.out.println(all_courses);
    }

    public static ArrayList<Integer> offering() {
        ArrayList<Integer> offering = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 94; i++) {
            offering.add(rand.nextInt(1,5));
        }
        return offering;
    }

    public static void schedule(ArrayList<Integer> x){
        ArrayList<String> fileData = getFileData("src/text");
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int random = rand.nextInt(93);
                System.out.println(fileData.get(random));
            }
            System.out.println();
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> list1 = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    list1.add(line);
            }
            return list1;
        } catch (FileNotFoundException e) {
            list1.add("not found");
            return list1;
        }
    }

    public static ArrayList<String> room(){
        ArrayList<String> room = new ArrayList<>();
        String[] floors = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
        String[] wing = {"N", "S", "E", "W"};
        //rooms
        for (int k = 0; k < 9; k++) {
            for (int w = 0; w < 4; w++) {
                for (int i = 1; i <= 20; i++) {
                    for (int j = 1; j < 11; j++) {
                        room.add(floors[k] + wing[w] + i);
                    }
                }
            }
        }
        return room;
    }
}