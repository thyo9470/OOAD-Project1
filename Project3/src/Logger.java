/**
 * Class -> Logger
 */

public class Logger implements Observer {

    private Store store;
    private Simulator simulator;

    public Logger(Simulator simulator){
        this.simulator = simulator;
    }

    public void startObserving(Store store){
        this.store = store;
        this.store.registerObserver(this);
    }

    public void finishObserving(){
        this.store.removeObserver(this);
        this.store = null;
    }

    // TODO: implement simulator and check for which log to do: daily or final
    @Override
    public void update() {
        throw new UnsupportedOperationException("Implement Simulator");
    }

    private void dailyLog(){
        if(this.store != null && !this.store.isOpen()){
            if(this.simulator != null){
            }
        }
        throw new UnsupportedOperationException("Add output stuff");
    }

    private void finalLog(){
        if(this.store != null && !this.store.isOpen()){
            if(this.simulator != null){
            }
        }
        throw new UnsupportedOperationException("Add output stuff");
    }
}
