package Aud05;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aleksandar
 */
// Java Program to check if a queue  
// of first n natural number can 
// be sorted using a stack 

import java.util.NoSuchElementException;
import java.util.Scanner;

class SortedQueue
{ 
    static ArrayQueue<Integer> q =  
                    new ArrayQueue<Integer>(1000); 
      
    // Function to check if given  
    // queue element can be sorted  
    // into another queue using a stack. 
    static boolean checkSorted(int n) 
    { 
//        Stack<Integer> st = new Stack<Integer>();
        LinkedStack<Integer> st = new LinkedStack<Integer>();
//        ArrayStack<Integer> st = new ArrayStack<Integer>(100);
        int expected = 1; 
        int fnt; 
      
        // while given Queue 
        // is not empty. 
        while (q.size() != 0)  
        { 
            fnt = q.peek(); 
            q.dequeue(); 
      
            // if front element is  
            // the expected element 
            if (fnt == expected) 
                expected++; 
      
            else
            { 
                // if stack is empty,  
                // push the element 
                if (st.size() == 0)  
                { 
                    st.push(fnt); 
                } 
      
                // if top element is less than  
                // element which need to be  
                // pushed, then return fasle. 
                else if (st.size() != 0 && st.peek() < fnt)
                { 
                    return false; 
                } 
      
                // else push into the stack. 
                else
                    st.push(fnt); 
            } 
      
            // while expected element are 
            // coming from stack, pop them out. 
            while (st.size() != 0 &&  
                   st.peek() == expected)  
            { 
                st.pop(); 
                expected++; 
            } 
        } 
          
        // if the final expected element  
        // value is equal to initial Queue 
        // size and the stack is empty. 
        if (st.size() == 0)
            return true; 
      
        return false; 
    }

    static boolean isSorted(int n)
    {
//        Stack<Integer> st = new Stack<Integer>();
        LinkedStack<Integer> st = new LinkedStack<Integer>();
//        ArrayStack<Integer> st = new ArrayStack<Integer>(100);
        if (q.size()==0) return true;
        int current = q.dequeue();
        int fnt;

        // while given Queue
        // is not empty.
        while (q.size() != 0)
        {
            fnt = q.dequeue();
            if (fnt<=current) return false;
        }
        return true;
    }

    // Driver Code 
    public static void main(String args[]) 
    { 
       // q.add(5); 
        //q.add(1); 
        //q.add(2); 
        //q.add(3); 
    	
    	
    	Scanner s=new Scanner (System.in);
    	int n=s.nextInt();
    	
    	for(int i=0;i<n;i++)
            q.enqueue(s.nextInt());
      
      //  int n = q.size(); 
  
//        if (checkSorted(n))
        if (isSorted(n))
            System.out.print("Da"); 
        else
            System.out.print("Ne"); 
    } 
} 
  
