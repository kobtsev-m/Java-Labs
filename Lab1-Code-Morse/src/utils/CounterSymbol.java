package utils;

public class CounterSymbol implements Comparable<CounterSymbol> {

    private Character value;
    private int occurrence;

    public CounterSymbol(Character value) {
        this.value = value;
        this.occurrence = 1;
    }
    public String getValue() {
        return value.toString();
    }
    public int getOccurrence() {
        return occurrence;
    }
    public void increaseOccurrence() {
        occurrence++;
    }
    @Override
    public int compareTo(CounterSymbol other) {
        return Integer.compare(occurrence, other.occurrence);
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CounterSymbol)) {
            return false;
        }
        CounterSymbol otherSymbol = (CounterSymbol) other;
        if (value == otherSymbol.value) {
            otherSymbol.increaseOccurrence();
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return (int)value;
    }
}
