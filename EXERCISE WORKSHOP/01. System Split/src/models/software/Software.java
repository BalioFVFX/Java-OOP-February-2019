package models.software;

public abstract class Software {
    private String name;
    private int capacity;
    private int memory;

    public Software(String name, int capacity, int memory) {
        this.setName(name);
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
