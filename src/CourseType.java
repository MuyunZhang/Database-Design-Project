public class CourseType {
    public static void main(String[] args) {
        String [] types = {"AP", "Regents", "Elective"};
        for (int i = 1; i <= types.length; i++) {
            System.out.println("INSERT INTO Course_Type ( Course_TypeID, Course_Type ) VALUES ( " + i + ", ' " + types[i-1] + "' );");
        }
    }
}
