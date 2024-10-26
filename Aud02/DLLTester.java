package Aud02;

public class DLLTester {

    public static void main(String[] args) {
        DLL<Integer> lista = new DLL<Integer>();

        lista.insertLast(5);
        System.out.print("The list after inserting 5 as the last element: ");
        System.out.println(lista.toString()+" and reversed "+lista.toStringR());


        lista.insertFirst(3);
        System.out.print("The list after inserting 3 as the first element: ");
        System.out.println(lista.toString()+" and reversed "+lista.toStringR());


        lista.insertLast(1);
        System.out.print("The list after inserting 1 as the last element: ");
        System.out.println(lista.toString()+" and reversed "+lista.toStringR());


        lista.deleteFirst();
        System.out.print("The list after deleting the first element: ");
        System.out.println(lista.toString()+" and reversed "+lista.toStringR());

        DLLNode<Integer> node = lista.find(5);
        lista.insertBefore(2,node);
        System.out.print("The list after inserting 2 before the element 5: ");
        System.out.println(lista.toString()+" and reversed "+lista.toStringR());


        node = lista.find(1);
        lista.insertAfter(3, node);
        System.out.print("The list after inserting the element 3 after the element 1: ");
        System.out.println(lista.toString()+" and reversed "+lista.toStringR());


        lista.insertAfter(6,node);
        System.out.print("The list after inserting the element 6 after the element 1: ");
        System.out.println(lista.toString()+" and reversed "+lista.toStringR());

        node = lista.find(3);
        lista.delete(node);
        System.out.print("The list after deleting the element 3: ");
        System.out.println(lista.toString()+" and reversed "+lista.toStringR());

        System.out.println("List size: "+ lista.getSize());


        lista.deleteList();
        System.out.print("The list after deleting the list: ");
        System.out.println(lista.toString()+" and reversed "+lista.toStringR());
        System.out.println("List size: " + lista.getSize());


    }

}

