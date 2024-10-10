package Aud00;

//Create a Box class that has the ability to store a generic type T

class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

public class GenericBox {
    public static void main(String[] args) {
        Box<Integer> box = new Box<Integer>();
        box.set(5);
        System.out.println(box.get());
    }
}
