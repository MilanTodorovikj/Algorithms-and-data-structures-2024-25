package Aud01;

public class SLLTester {

    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<Integer>();

        lista.insertLast(5);
        System.out.print("List after inserting element 5 as last element: ");
        System.out.println(lista.toString());


        lista.insertFirst(3);
        System.out.print("List after inserting element 3 as first element: ");
        System.out.println(lista.toString());

        lista.insertLast(1);
        System.out.print("List after inserting element 1 as last element: ");
        System.out.println(lista.toString());

        lista.deleteFirst();
        System.out.print("List after deleting first element: ");
        System.out.println(lista.toString());

        SLLNode<Integer> element = lista.find(5);
        lista.insertBefore(2, element);
        System.out.print("List after inserting the element 2 before the element 5: ");
        System.out.println(lista.toString());

        element = lista.find(1);
        lista.insertAfter(3, element);
        System.out.print("List after inserting element 3 after element 1: ");
        System.out.println(lista.toString());


        System.out.println("List size: " + lista.size());

        System.out.print("List after reversing: ");
        lista.mirror();
        System.out.println(lista.toString());

        element = lista.find(2);
        lista.delete(element);
        System.out.print("List after deleting element 2: ");
        System.out.println(lista.toString());

        System.out.println("List size: " + lista.size());

        lista.deleteList();
        System.out.print("List after deleting the whole list: ");
        System.out.println(lista.toString());
        System.out.println("List size: " + lista.size());

    }

}
