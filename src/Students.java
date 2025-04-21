public class Students {
    public static void main(String[] args) {

        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT INTO Students ( Student_ID, Student_name ) VALUES ( " + i + ", 'Student" + i + "' );");
        }
    }

    int id = 0;
    String name;
    public Students(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public void setId(int idd){
        id = idd;
    }

    public void setName(String namee){
        name = namee;
    }
}
