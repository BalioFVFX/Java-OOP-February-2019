public class Light {
    private Signal signal;

    public Light(Signal signal) {
        this.signal = signal;
    }

    public void changeSignal(){
        if(this.signal.name().equals("RED")){
            this.signal = Signal.GREEN;
        }
        else if(this.signal.name().equals("YELLOW")){
            this.signal = Signal.RED;
        }
        else if(this.signal.name().equals("GREEN")){
            this.signal = Signal.YELLOW;
        }
    }

    @Override
    public String toString() {
        return this.signal.name();
    }
}
