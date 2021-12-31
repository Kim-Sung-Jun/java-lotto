package domain;

public class SameValueCount {

    public static final int DEFAULT_VALUE = 0;
    private static final int COUNT = 1;

    private int valueCount;

    public SameValueCount() {
        this(DEFAULT_VALUE);
    }

    public SameValueCount(int valueCount) {
        this.valueCount = valueCount;
    }

    public void plus() {
        this.valueCount += COUNT;
    }

    public int getValueCount() {
        return valueCount;
    }

}
