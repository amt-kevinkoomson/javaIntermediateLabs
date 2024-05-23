package WeekOne.Generics;

import java.util.ArrayList;

public class GenericStack<T> {
//    Lab Exercise #4: Design a Generic Class for Stack Data Structure
//    Create a generic Stack class that can hold objects of any data type, utilizing generics for type safety.
    private ArrayList<T> elements;
    private int size;

    private GenericStack(){
        elements = new ArrayList<>();
        size = 0;
    }

    private void push(T value){
        elements.add(value);
    }

    private void pop(T value) {
        if(size>0) elements.remove(size-1);
    }
    private void print(){
        System.out.println(elements);
    }

    public static void main(String[] args) {
        GenericStack<Number> numStack = new GenericStack<>();
        numStack.push(49);
        numStack.push(11);
//        numStack.push("sting");
        numStack.print();

        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.print();
    }

}
