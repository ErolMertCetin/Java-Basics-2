package com.company;
import java.lang.Math;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files



public class Num_Real {
    private float[] numbers;
    int capacity;
    Float Avg, Min, Max;

    Num_Real(int n){
        capacity = n;
        numbers = new float[n];
        for(int i = 0; i< n; i++)
        {
            numbers[i] = (float)Math.random();
        }
    }
    Num_Real(){}

    Num_Real(String code){
        String[] nos = code.split(",");
        capacity = Integer.parseInt(nos[0]);
        numbers = new float[capacity];
        for(int i = 0; i< capacity; i++)
        {
            numbers[i] = Float.parseFloat(nos[i+1]);
        }
    }

    float avg()
    {
        if(Avg != null)
            return Avg;
        float total = 0;
        for(float x : numbers)
        {
            total += x;
        }
        return total/capacity;
    }

    float min()
    {
        if(Min != null)
            return Min;

        float min = Float.MAX_VALUE;
        for(float x : numbers)
        {
            if(x < min)
            {
                min = x;
            }
        }
        Min = min;
        return min;
    }

    float max()
    {
        if(Max != null)
            return Max;
        float max = -Float.MAX_VALUE;
        for(float x : numbers)
        {
            if(x > max)
            {
                max = x;
            }
        }
        Max = max;
        return max;
    }

    float median()
    {
        float[] x = new float[capacity];
        for(int i = 0; i< capacity; i++)
        {
            x[i] = numbers[i];
        }
        Arrays.sort(x);
        float median;
        if (x.length % 2 == 0)
            return (x[x.length/2] + x[x.length/2 - 1])/2;
        else
            return x[x.length/2];
    }

    void sort()
    {
        Arrays.sort(numbers);
    }

    void print()
    {
        for(float x : numbers)
        {
            System.out.print(String.valueOf(x) + ", ");
        }
        System.out.println("");
    }

    String toStringCode()
    {
        String code = new String();
        code += String.valueOf(capacity) + ",";

        for(float x : numbers)
        {
            code += String.valueOf(x) + ",";
        }
        code += "\n";
        return code;
    }

    void Serialize(String fileName)
    {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(toStringCode());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void Deserialize(String fileName)
    {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] nos = data.split(",");
                capacity = Integer.parseInt(nos[0]);
                numbers = new float[capacity];
                for(int i = 0; i< capacity; i++)
                {
                    numbers[i] = Float.parseFloat(nos[i+1]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Avg = null; Min = null; Max = null;
    }

}
