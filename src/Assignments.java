import java.util.ArrayList;

public class Assignments {
        public static void main(String[] args) {
            String [] types = {"Minor Assessment", "Major Assessment"};
            for (int i = 1; i <= types.length; i++) {
                System.out.println("INSERT INTO Assignment_Type ( Assignment_TypeID, Assignment_Type ) VALUES ( " + i + ", ' " + types[i-1] + "' );");
            }
            for (int i = 1; i <= types.length; i++) {
                System.out.println("INSERT INTO Assignments ( Assignment_ID, Assignment_Name, Class_ID, Assignment_TypeID) VALUES ( " + i + ", ' " + types[i-1] + "' );");
            }
    }
}
