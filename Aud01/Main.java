package Aud01;

import java.util.Scanner;

//5
//4 5 6 7 9
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];

        for(int i=0;i<n;i++) {
            array[i] = sc.nextInt();
        }
        int brParni=0,brNeparni=0,suma=0;
        for(int a: array) {
            if(a%2==0) {
                brParni++;
            } else {
                brNeparni++;
            }
            suma+=a;
        }

        float prosek = (float) suma/n;

        System.out.println(brParni);
        System.out.println(brNeparni);
        System.out.println(prosek);
    }
}