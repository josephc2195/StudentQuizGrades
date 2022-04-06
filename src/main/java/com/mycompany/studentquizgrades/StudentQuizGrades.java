/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
​
/**
 *
 * @author chica
 */
public class StudentQuizGrades {
​
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> grades = new HashMap<>();
        Map<String, Double> avg = new HashMap<>();
​
        UserIO io = new UserIOConsoleImpl();
        int numOfQuizzes = io.readInt("Please enter the amount of quizzes taken:", 0, 10);
        int numOfStudents = io.readInt("How many students are you inputing?", 0, 10);
        int high = 0, low = 0, quizTotal=0;
        String nameLow = null, nameHigh = null;
        for (int i = 0; i < numOfStudents; i++) {
            String name = io.readString("Enter name of student: ");
            ArrayList<Integer> stud = new ArrayList<>();
            int studentQuizTotal = 0;
            for (int j = 0; j < numOfQuizzes; j++) {
                stud.add(io.readInt("Enter grade for test " + (j + 1), 0, 100));
                grades.put(name, stud);
            }
            for (int g : stud) {
                quizTotal += g;
                studentQuizTotal += g;
                if (low == 0 || low > g) {
                    low = g;
                    nameLow = name;
                }
                if (high == 0 || high < g) {
                    high = g;
                    nameHigh = name;
                }
            }
​
            avg.put(name, Double.valueOf(studentQuizTotal / (numOfQuizzes * numOfStudents)));
        }
        double classAvg = quizTotal / (numOfStudents * numOfQuizzes);
        io.print("Class average: " + classAvg);
        io.print("High grade of: " + high + " by " + nameHigh);
        io.print("Low grade of: " + low + " by " + nameLow);
​
    }
​
}