import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] floors = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
        String[] wing = {"N", "S", "E", "W"};
        //rooms
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int k = 0; k < 9; k ++) {
            for (int w = 0; w < 4; w ++) {
                for (int i = 1; i <= 20; i++) {
                    rooms.add(i);
                    System.out.println(floors[k] + wing[w] + i);
                }
            }
        }
        for(int i = 0; i < 10000; i ++){
            int offerings = (int) (Math.random() * (5-1+1)) + 1;
            System.out.println(offerings);
        }
        System.out.println();
    }
}