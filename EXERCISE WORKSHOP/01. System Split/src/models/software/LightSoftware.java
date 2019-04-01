package models.software;

public class LightSoftware extends Software {
    public LightSoftware(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    public void setCapacity(int capacity) {
        int percent = (int)(capacity * 0.50);

        super.setCapacity(capacity + percent);
    }

    @Override
    public void setMemory(int memory) {
        int percent = (int)(memory * 0.50);

        super.setMemory(memory - percent);
    }
}
