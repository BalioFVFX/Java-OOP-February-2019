public enum CardSuits {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int ordinalValue;

    CardSuits(int ordinalValue) {
        this.ordinalValue = ordinalValue;
    }


    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s",
                this.ordinalValue, this.name());
    }
}
