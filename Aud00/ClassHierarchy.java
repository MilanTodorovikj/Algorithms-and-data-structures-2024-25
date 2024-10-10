package Aud00;

/*
Create a class hierarchy with the following rules:
- Create a class Bicicle which will store the gear and speed of the bicycle,
as well as have methods for changing a gear, applying break and speeding up.
Add a toString method.

- Create a class MountainBike which will inherit from the class Bicycle
and will store additional information about the seat height.
Add a method for changing the seat height and override the toString method.

*/

class Bicycle {
    public int gear;
    public int speed;

    public Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public void changeGear(int newGear) {
        gear = newGear;
    }

    public void applyBreak(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    public String toString() {
        return "Gear: " + gear + "\n" + "Speed:" + speed;
    }
}

class MountainBike extends Bicycle {
    public int seatHeight;

    public MountainBike(int seatHeight, int gear, int speed) {
        super(gear, speed);
        this.seatHeight = seatHeight;
    }

    public void setSeatHeight(int newSeatHeight) {
        seatHeight = newSeatHeight;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSeat Height:" + seatHeight;
    }
}

public class ClassHierarchy {
    public static void main(String[] args) {
        Bicycle b = new Bicycle(1, 25);
        System.out.println(b.toString());
        System.out.println();
        MountainBike m = new MountainBike(2, 5, 10);
        System.out.println(m);
    }
}
