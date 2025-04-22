import java.util.ArrayList;

public class Rooms {
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
    }

    private String room;

    private int roomID;

    public Rooms(String name, int id){
        room = name;
        roomID = id;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom(){
        return room;
    }

    public int getRoomID() {
        return roomID;
    }
}
