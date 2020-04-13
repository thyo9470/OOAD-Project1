package Rooms;

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


    /**
     *isFloorEnd
     * @return bool
     * is the current room the end of the floor
     */
    public boolean isFloorEnd(){
        return floorEnd;
    }


    /**
     * interact
     * @param entity
     */

    public void interact(Entities.Entity entity){

    }



}
