package Aud02.Exercise2;

public class MainTest {

    public static void main(String[] args) {

        DLL<Integer> lista = new DLL<Integer>();
        lista.insertLast(1);
        lista.insertLast(2);
        lista.insertLast(1);
        lista.insertLast(5);
        lista.insertLast(1);
        lista.insertLast(2);
        lista.insertLast(3);
        lista.insertLast(5);
        lista.insertLast(4);
        lista.insertLast(1);

        System.out.println("The list before deleting and counting duplicates:");
        System.out.println(lista.toString());
        lista.deleteAndCountDuplicates();
//        lista.izvadiDupliIPrebroj();

        System.out.println("The list after deleting and counting duplicates:");
        System.out.println(lista.toString());
    }
}
