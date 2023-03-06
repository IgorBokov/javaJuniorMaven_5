package lesson24;

class MyClass<T> {           // типизированный класс "Т"
    private T val;

    public MyClass() {
    }

    public MyClass(T val) {
        this.val = val;
    }
    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "val=" + val +
                '}';
    }
}
