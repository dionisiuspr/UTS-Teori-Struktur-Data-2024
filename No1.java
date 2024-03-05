/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTSTeori2024;

import java.util.Scanner;

/**
 *
 * @author Dionisius
 */
class Course {

    String courseCode, courseName;
    int capacity;
    int[][] participantsCount = new int[2][3]; // 2 = sex: L, P; 3 = usia: anak, remaja, dewasa

    // Method untuk menghitung jumlah partisipan usia dewasa dari sebuah kursus
    public int hitungPartisipanDewasa() {
        // Jumlah partisipan dewasa laki-laki + 
        // partisipan dewasa perempuan
        return participantsCount[0][2] + participantsCount[1][2];
    }

    public int hitungSisaKapasitas() {
        int totalParticipants = 
                participantsCount[0][0] + participantsCount[0][1] + participantsCount[0][2]
              + participantsCount[1][0] + participantsCount[1][1] + participantsCount[1][2];
        return capacity - totalParticipants;
    }

    public static String hitungSisaKuotaTerbanyak(Course[] courses) {
        String namaCourse = "";
        int maxRemainingCapacity = -1;

        for (int i = 0; i < 10; i++) {
            if (courses[i] != null) {
                int remainingCapacity = courses[i].hitungSisaKapasitas();
                if (remainingCapacity > maxRemainingCapacity) {
                    maxRemainingCapacity = remainingCapacity;
                    namaCourse = courses[i].courseName;
                }
            }
        }
        return namaCourse;
    }

//    // Metode statis untuk menghitung jumlah partisipan usia dewasa pada seluruh array kursus
//    public static int countAdultParticipantsInAllCourses(Course[] courses) {
//        int totalAdultParticipants = 0;
//        for (int i = 0; i < 10; i++) {
//            if (courses[i] != null) {
//                totalAdultParticipants += courses[i].countAdultParticipants();
//            }
//        }
//        return totalAdultParticipants;
//    }
}

class Main {

    public static void main(String[] args) {
        Course[] courses = new Course[10]; // ada 10 kursus di tempat ini
        for (int i = 0; i < 10; i++) {
            courses[i] = new Course();
        }
        // Contoh penggunaan method countAdultParticipants() per course
        int nomor = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nomor urut kursus (1-10): ");
        nomor = sc.nextInt();
        int totalAdultParticipants = courses[nomor-1].hitungPartisipanDewasa();
        System.out.println("Jumlah partisipan dewasa di kursus " + nomor + ": " + totalAdultParticipants);

        // kalau itung semua:
        // int adultParticipantsInAllCourses = Course.countAdultParticipantsInAllCourses(courses);
        // System.out.println("Total partisipan usia dewasa di semua kursus: " + adultParticipantsInAllCourses);
        
        // Course 1
        courses[0] = new Course();
        courses[0].courseName = "Course 1";
        courses[0].capacity = 100;
        courses[0].participantsCount[0][0] = 10; // Laki-laki anak
        courses[0].participantsCount[1][1] = 10; // Perempuan remaja
        
        // Course 2
        courses[1] = new Course();
        courses[1].courseName = "Course 2";
        courses[1].capacity = 50;
        courses[1].participantsCount[1][1] = 45; // Remaja perempuan

        // Course 3
        courses[2] = new Course();
        courses[2].courseName = "Course 3";
        courses[2].capacity = 100;
        courses[2].participantsCount[1][2] = 5; // Dewasa perempuan

        // Mengisi data kursus ke-2 dan ke-3 dengan cara yang sama
        String courseKuotaTerbanyak = Course.hitungSisaKuotaTerbanyak(courses);
        System.out.println("Nama kursus dengan sisa kuota paling banyak: " + courseKuotaTerbanyak);
    }
}
