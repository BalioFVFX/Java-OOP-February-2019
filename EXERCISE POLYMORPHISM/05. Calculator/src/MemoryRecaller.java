public class MemoryRecaller implements Operation{
    private Memory memory;

    public MemoryRecaller() {
        this.memory = new Memory();
    }

    @Override
    public void addOperand(int operand) {
        this.memory.addOperand(operand);
    }

    @Override
    public int getResult() {
        return this.memory.getResult();
    }

    @Override
    public boolean isCompleted() {
        return this.memory.isCompleted();
    }
}
