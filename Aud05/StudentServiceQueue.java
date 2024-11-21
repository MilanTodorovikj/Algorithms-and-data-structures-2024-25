package Aud05;
import java.util.Scanner;

class Student {
    String index;
    int minutes;

    Student(String index, int minutes) {
        this.index = index;
        this.minutes = minutes;
    }
}

public class StudentServiceQueue {

    static Student iterateStudentsQueue(ArrayQueue<Student> studentsQueue) {
        int minutes = 180;
        Student tempStudent = studentsQueue.peek();
        while (tempStudent != null) {
            if (minutes < tempStudent.minutes) {
                break;
            } else {
                minutes -= tempStudent.minutes;
                studentsQueue.dequeue();
            }
            tempStudent = studentsQueue.peek();
        }
        return tempStudent;
    }

    static int minutesNeededForStudents(ArrayQueue<Student> studentsQueue) {
        int minutes = 0;
        Student tempStudent = studentsQueue.peek();
        while (tempStudent != null) {
            minutes += tempStudent.minutes;
            studentsQueue.dequeue();
            tempStudent = studentsQueue.peek();
        }
        return minutes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vnesi broj na studenti");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayQueue<Student> studentsQueue = new ArrayQueue<Student>(n);
        for (int i = 0; i < n; i++) {
            System.out.println("Vnesi index na studentot");
            String index = scanner.nextLine();
            System.out.println("Vnesi minuti potrebni za opsluzuvanje na studentot");
            int minutes = Integer.parseInt(scanner.nextLine());
            Student student = new Student(index, minutes);
            studentsQueue.enqueue(student);
        }

        Student student = iterateStudentsQueue(studentsQueue);
        if (studentsQueue.isEmpty()) {
            System.out.println("Opsluzeni se site studenti");
        } else {
            System.out.println("Prviot student sto nema da e opsluzen e: " + student.index);
            System.out.println("Broj na studenti koi ne se opsluzeni za deneska: " + studentsQueue.length);
//            System.out.println("Vkupno minuti potrebni za studentite koi ne se opsluzeni: "+ minutesNeededForStudents(studentsQueue));
            System.out.println("Minutes needed: " + minutesNeededForStudents(studentsQueue));
        }
    }
}
