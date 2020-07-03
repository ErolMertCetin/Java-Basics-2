package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("\tNumbers:");

        // Basic functionality test
	    Num_Real num = new Num_Real(10);
        System.out.println("Initial Array:");
        num.print();
        System.out.println("Avg: " + String.valueOf(num.avg()));
        System.out.println("Min: " + String.valueOf(num.min()));
        System.out.println("Max: " + String.valueOf(num.max()));
        System.out.println("Median: " + String.valueOf(num.median()));
        num.sort();
        System.out.println("After Sort:");
        num.print();

        // Serialize this object
        num.Serialize("objects.txt");
        Num_Real num2 = new Num_Real();
        System.out.println("\nSerialized and Deserialized:");
        num2.Deserialize("objects.txt");
        num2.print();


        System.out.println("\n\n");


        // Multinumber usage
        Matrix mult = new Matrix(4);
        mult.print();
        mult.Serialize("object2.txt");
        Matrix mult2 = new Matrix();
        mult2.Deserialize("object2.txt");
        System.out.println("Serialization -> Deserialization -> print()");
        mult2.print();

        // Multinumber sorts
        System.out.println("\n\nSorted by avg:");
        mult2.SortByAvg();
        mult2.print();
        System.out.println("\nSorted by min:");
        mult2.SortByMin();
        mult2.print();
        System.out.println("\nSorted by max:");
        mult2.SortByMax();
        mult2.print();




    }
}
