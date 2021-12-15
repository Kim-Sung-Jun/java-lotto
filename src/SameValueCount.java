public class SameValueCount {

    private static final int DEFAULT_VALUE = 0;
    private static final int COUNT = 1;

    private final int valueCount;

    public SameValueCount() {
        this(DEFAULT_VALUE);
    }

    public SameValueCount(int valueCount) {
        this.valueCount = valueCount;
    }

    public SameValueCount plus() {
        return new SameValueCount(valueCount + COUNT);
    }

    public int getValueCount() {
        return valueCount;
    }

}
