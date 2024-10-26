package Aud02;

public class ListMirrorTest {

    public static void main(String[] args) {
        DLL<String> lista = new DLL<String>();
        lista.insertLast("this");
        lista.insertLast("list");
        lista.insertLast("will");
        lista.insertLast("be");
        lista.insertLast("mirrored");

        System.out.println("The list before being mirrored");
        System.out.println(lista.toString());

        lista.mirror();

        System.out.println("The list after being mirrored");
        System.out.println(lista.toString());
    }
}

