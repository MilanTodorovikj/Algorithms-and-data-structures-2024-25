package Aud01;

public class ArrayTester {

    public static void main(String[] args) {
        Array<Integer> niza = new Array<Integer>(1);

        niza.insertLast(4);
        niza.insertLast(5);
        System.out.print("The Array after inserting 4 as the last element: ");
        System.out.println(niza.toString());

        niza.insertLast(7);
        niza.insertLast(13);
        System.out.print("The Array after inserting 7 and 13 as elements: ");
        System.out.println(niza.toString());

        niza.insert(1,3);
        System.out.print("The Array after inserting element 3 at the position 1: ");
        System.out.println(niza.toString());

        niza.set(2,6);
        System.out.print("The Array after setting the element at position 2 to be 6: ");
        System.out.println(niza.toString());

        niza.delete(0);
        System.out.print("The Array after deleting the element at position 0 (first element): ");
        System.out.println(niza.toString());

        System.out.print("At the position 2 the current element is: ");
        System.out.println(niza.get(2));

        System.out.print("The element 3 currently is at position: ");
        System.out.println(niza.find(3));

        System.out.print("At the end of the program the size of the Array is: ");
        System.out.println(niza.getSize());

    }
}
