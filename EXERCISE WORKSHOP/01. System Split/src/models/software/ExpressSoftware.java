package models.software;

public class ExpressSoftware extends Software {
    public ExpressSoftware(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    public void setMemory(int memory) {
        super.setMemory(memory * 2);
    }

}
