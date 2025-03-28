public class Students {
    public static void main(String[] args) {

        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT INTO Students ( Student_ID, Student_name ) VALUES ( " + i + ", 'Student" + i + "' );");
        }
    }
}
