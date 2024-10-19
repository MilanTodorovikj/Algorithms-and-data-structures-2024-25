package Aud01;

public class MirrorListMain {

    public static void main(String[] args) {
        SLL<String> lista = new SLL<String>();
        lista.insertLast("this");
        lista.insertLast("list");
        lista.insertLast("will");
        lista.insertLast("be");
        lista.insertLast("mirrored");
        System.out.println("The list before being mirrored: " + lista.toString());
        lista.mirror();
        System.out.println("The listt after being mirrored: " + lista.toString());
    }
}

