package Rooms;

import Entities.Entity;
import Interactions.Interactable;

public abstract class Room {

    /**
     * private variables
     */
    private boolean visited;
    private boolean floorEnd;

    /**
     * **public functions**
     *
     * hasBeenVisited
     * @return bool
     * if room has already been visited
     */

    public boolean hasBeenVisited(){
        return visited;
    }

    public void visit() {
        this.visited = true;
    }

    /**
     *isFloorEnd
     * @return bool
     * is the current room the end of the floor
     */
    public boolean isFloorEnd(){
        return floorEnd;
    }

    public void setFloorEnd(){
        this.floorEnd = true;
    }


    /**
     * Used to interact with a specific room and it's objects
     * @param entity
     */

    public void enterRoom(Entity entity) {

        Room selfRef = this;
        Runnable run = new Runnable() {
            @Override
            public void run() {
                selfRef.interact(entity);
            }
        };
        Thread test = new Thread(run);
        test.setName("room-thread");
        test.start();

    }

    abstract public void interact(Entity entity);


}
