public class MyPair {
    private Object key;
    private Object value;

    public MyPair(){}
    public MyPair(Object aKey, Object aValue) {
        key   = aKey;
        value = aValue;
    }

    public Object key()   { return key; }
    public Object value() { return value; }
    //public Object key()   { return key; }
    public void ReValue(Object v) { value=v; }

    @Override
    public String toString() {
        return "("+key+": "+value+")";

    }
}
