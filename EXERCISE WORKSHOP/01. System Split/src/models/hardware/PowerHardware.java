package models.hardware;

public class PowerHardware extends Hardware{
    public PowerHardware(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    public void setCapacity(int capacity) {
        int percent = (int)(capacity * 0.75);
        super.setCapacity(capacity- percent);
    }

    @Override
    public void setMemory(int memory) {
        int percent = (int)(memory * 0.75);

        super.setMemory(memory + percent);
    }

    @Override
    public String getType() {
        return "Power";
    }
}
