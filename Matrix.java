package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Matrix {
    Num_Real[] matrix;
    int capacity;
    Matrix(int c)
    {
        capacity = c;
        matrix = new Num_Real[c];
        for(int i = 0; i< c; i++)
        {
            matrix[i] = new Num_Real(c);
        }
    }
    Matrix(){}

    void Serialize(String fileName)
    {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(String.valueOf(capacity) + "\n");
            for(Num_Real col : matrix)
            {
                writer.write(col.toStringCode());
            }
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
            String cap = myReader.nextLine();
            capacity = Integer.parseInt(cap);
            matrix = new Num_Real[capacity];
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                matrix[i++] = new Num_Real(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void print()
    {
        for(int i = 0; i< capacity; i++)
        {
            matrix[i].print();
        }
    }

    //average, min, max
    float avarage()
    {
        float total = 0;
        for(int i = 0; i< capacity; i++)
        {
            total += matrix[i].avg();
        }
        return total/capacity;
    }

    float min()
    {
        float min = Float.MAX_VALUE;
        for(Num_Real x : matrix)
        {
            if (min > x.min())
            {
                min = x.min();
            }
        }
        return min;
    }

    float max()
    {
        float max = -Float.MAX_VALUE;
        for(Num_Real x : matrix)
        {
            if (max < x.max())
            {
                max = x.max();
            }
        }
        return max;
    }

    void SortByAvg()
    {
        for (int i = 0; i < capacity-1; i++)
            for (int j = 0; j < capacity-i-1; j++)
                if (matrix[j].avg() > matrix[j+1].avg())
                {
                    // swap arr[j+1] and arr[i]
                    Num_Real temp = matrix[j];
                    matrix[j] = matrix[j+1];
                    matrix[j+1] = temp;
                }
    }

    void SortByMin()
    {
        for (int i = 0; i < capacity-1; i++)
            for (int j = 0; j < capacity-i-1; j++)
                if (matrix[j].min() > matrix[j+1].min())
                {
                    // swap arr[j+1] and arr[i]
                    Num_Real temp = matrix[j];
                    matrix[j] = matrix[j+1];
                    matrix[j+1] = temp;
                }
    }

    void SortByMax()
    {
        for (int i = 0; i < capacity-1; i++)
            for (int j = 0; j < capacity-i-1; j++)
                if (matrix[j].max() > matrix[j+1].max())
                {
                    // swap arr[j+1] and arr[i]
                    Num_Real temp = matrix[j];
                    matrix[j] = matrix[j+1];
                    matrix[j+1] = temp;
                }
    }

}
