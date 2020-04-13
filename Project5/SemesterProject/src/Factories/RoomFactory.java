package Factories;

public class RoomFactory {

    //References to specific room type factories
    private EnemyFactory EnemyFactory;
    private ItemFactory ItemFactory;
    private PuzzleFactory PuzzleFactory;
    private RoomFactory factory;

    public RoomFactory(RoomFactory factory){
        this.factory = factory;
    }

}
