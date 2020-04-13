package Graphics;

import Interactions.Intractable;

abstract public class Graphics {

    private Intractable intractable;
    private Graphics successor;

    public Intractable getIntractable() {
        return intractable;
    }

    public void setIntractable(Intractable intractable) {
        this.intractable = intractable;
    }

    public void handle(Intractable intractable) {

    }
}
