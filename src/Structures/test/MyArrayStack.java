package Structures.test;

public class MyArrayStack {
    int[] stack ;
    int top = -1;
    int capacity = 10;
    MyArrayStack(){
        stack = new int[capacity];
    }

    MyArrayStack(int capacity){

        this.capacity = capacity;
        stack = new int[capacity];
    }
    void push(int val){
        if(top+1 == capacity){
            return;
        }
        top++;
        stack[top] = val;
    }
    void pop(){
        if(top == -1){
            return ;
        }
        top--;
    }
    int peek(){
        return stack[top];
    }
    boolean isFull(){
        if(top+1 == capacity){
            return true;
        }
        return false;
    }
    boolean isEmpty(){
        if(top==-1){
            return true;
        }else {return false;}
    }





}
