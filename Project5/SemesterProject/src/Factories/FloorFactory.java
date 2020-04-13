package Factories;

public class FloorFactory {

    private RoomFactory RoomFactory;
    private FloorFactory factory;

    public FloorFactory(FloorFactory factory){
        this.factory = factory;
    }

    public RoomFactory makeRoomFactory(RoomFactory room){

        return room;
    }
}
