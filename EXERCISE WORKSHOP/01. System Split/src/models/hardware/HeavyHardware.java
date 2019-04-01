package models.hardware;

public class HeavyHardware extends Hardware {
    public HeavyHardware(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    public void setCapacity(int capacity) {
        super.setCapacity(capacity * 2);
    }

    @Override
    public void setMemory(int memory) {
        int percent = (int)(memory * 0.25);
        super.setMemory(memory - percent);
    }

    @Override
    public String getType() {
        return "Heavy";
    }
}
