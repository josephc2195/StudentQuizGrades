/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Program creates a map of grades by students from user input data. The highest and lowest grades are saved and shown to the user
 * @author chica
 */
public class StudentQuizGrades {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> grades = new HashMap<>();//holds the student name, and list of students grades

        //using userio class for any printing/getting input from user
        UserIO io = new UserIOConsoleImpl();
        int numOfQuizzes = io.readInt("Please enter the amount of quizzes taken:", 0, 10);//quizzes are between 1-10
        int numOfStudents = io.readInt("How many students are you inputing?", 0, 10);//students are between 1-10
        int high = 0, low = 0, quizTotal=0;
        String nameLow = null, nameHigh = null;
        for (int i = 0; i < numOfStudents; i++) {//looping for each student
            String name = io.readString("Enter name of student: ");
            ArrayList<Integer> stud = new ArrayList<>();//arraylist used to keep track of all students grades
            for (int j = 0; j < numOfQuizzes; j++) {
                stud.add(io.readInt("Enter grade for test " + (j + 1), 0, 100));//adding grades to arraylist declared previously
            }
            grades.put(name, stud);//adding student name and arraylist of grades to first hashmap
            //looping thru each student grade to find lowest and highest grades as well as recording which student did it. 
            for (int g : stud) {
                quizTotal += g;
                if (low == 0 || low > g) {
                    low = g;
                    nameLow = name;
                }
                if (high == 0 || high < g) {
                    high = g;
                    nameHigh = name;
                }
            }
        }
        double classAvg = quizTotal / (numOfStudents * numOfQuizzes); //getting the class average
       
        io.print("Class average: " + classAvg);
        io.print("High grade of: " + high + " by " + nameHigh);
        io.print("Low grade of: " + low + " by " + nameLow);
    }
}