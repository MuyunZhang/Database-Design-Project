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
        ArrayList<String> teacher = new ArrayList<>();
        ArrayList<String> department = new ArrayList<>();
        for(int i = 0; i < fileData.size(); i ++){
            int len = fileData.size();
            String[] list = fileData.get(i).split("\\|");
            String teacher_name = list[0];
            teacher.add(teacher_name);
        }
        for(int i = 0; i < fileData.size(); i ++){
            int len = fileData.size();
            String[] list = fileData.get(i).split("\\|");
            String Department = list[1];
            department.add(Department);
        }
        for(int i = 0; i < department.size(); i ++){
            System.out.println(teacher.get(i) + i);
        }
        for(int i = 1; i <= teacher.size(); i ++){
            if(department.get(i-1).contains("Biology")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 1 + " );");
            }
            if(department.get(i-1).contains("Chemistry")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 2 + " );");
            }
            if(department.get(i-1).contains("CTE, Computer Science & Engineering")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 3 + " );");
            }
            if(department.get(i-1).contains("English")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 4 + " );");
            }
            if(department.get(i-1).contains("Health & PE")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 4 + " );");
            }
            if(department.get(i-1).contains("Mathematics")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 5 + " );");
            }
            if(department.get(i-1).contains("Physics")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 6 + " );");
            }
            if(department.get(i-1).contains("Social Studies")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 7 + " );");
            }
            if(department.get(i-1).contains("Visual & Performing Arts")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 8 + " );");
            }
            if(department.get(i-1).contains("World Languages & ENL")){
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i-1) + "'" + ", " + 9 + " );");
            }
        }
    }

    int teacherid;

    int departmentid;

    String name;

    public Teachers(int teacherid, String name, int departmentid){
        this.name = name;
        this.teacherid = teacherid;
        this.departmentid = departmentid;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setTeacherid(int id){
        teacherid = id;
    }

    public int getTeacherid(){
        return teacherid;
    }

    public void setDepartmentid(int id){
        departmentid = id;
    }

    public int getDepartmentid(){
        return departmentid;
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