package LabPO_ASOU;

import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * Created by Дмитрий on 13.02.2015.
 */
public class Lab6_1 {

    public static void main(String[] args) {

        System.out.println("Введите количество углов многоугольников (минимум 3):");
        Scanner in = new Scanner(System.in);
        int guess;
        while (true) {
            guess = in.nextInt();
            if (guess < 3)
                System.out.println("Не вверный ввод");
            else
                break;
        }
        Point[] myPoint = new Point[guess];
        for(int i = 0; i < guess; i++){
            System.out.println("Введите координаты точки X: " + i);
            int x = in.nextInt();
            System.out.println("Введите координаты точки Y: " + i);
            int y = in.nextInt();
            myPoint[i] = new Point(x, y);
        }
        System.out.println(perimeter(myPoint));
    }

    public static double perimeter(Point[] points){
        double perimetr = 0;
        for (int i = 0; i < points.length - 1; i++){
            perimetr += distance(points, i + 1, i);
        }
        return perimetr += distance(points, points.length - 1, 0);
    }

    public static double distance (Point[] points, int indexA, int indexB){

        return Math.sqrt((points[indexA].x - points[indexB].x) * (points[indexA].x - points[indexB].x)
                           + (points[indexA].y - points[indexB].y) * (points[indexA].y - points[indexB].y));
    }
}

class Point {
    public Point(int setX, int setY){
        x = setX;
        y = setY;
    }
    protected int x;
    protected int y;
}
