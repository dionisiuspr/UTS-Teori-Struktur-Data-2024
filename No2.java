/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTSTeori2024;

/**
 *
 * @author Dionisius
 */
public class No2 {

    public static int hitungJumlahUjian(int[][][] _arrayPesertaUjian, String _level, 
                                        String _umur, int _partisipanMinimal) {
        int count = 0;
        int levelIndex = -1;
        int ageGroupIndex = -1;

        // Menentukan indeks level dan kelompok usia berdasarkan input
        if (_level.equals("Pemula")) {
            levelIndex = 0;
        } else if (_level.equals("Lanjutan")) {
            levelIndex = 1;
        } else if (_level.equals("Mahir")) {
            levelIndex = 2;
        } else if (_level.equals("Professional")) {
            levelIndex = 3;
        }

        if (_umur.equals("Anak")) {
            ageGroupIndex = 0;
        } else if (_umur.equals("Remaja")) {
            ageGroupIndex = 1;
        } else if (_umur.equals("Dewasa")) {
            ageGroupIndex = 2;
        }

        // Menghitung jumlah mata ujian yang memenuhi syarat
        for (int i = 0; i < 4; i++) { // cek 4 ujian
            if (_arrayPesertaUjian[i][levelIndex][ageGroupIndex] >= _partisipanMinimal) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][][] participantsCount = {
            { // Ujian Piano
                {5, 2, 4}, // Pemula
                {1, 3, 2}, // Lanjutan
                {4, 4, 3}, // Mahir
                {1, 5, 0} // Professional
            },
            { // Ujian Violin
                {6, 4, 7}, // Pemula
                {0, 4, 5}, // Lanjutan
                {10, 0, 8}, // Mahir
                {1, 2, 4} // Professional
            },
            { // Ujian Organ
                {3, 3, 6}, // Pemula
                {2, 2, 4}, // Lanjutan
                {5, 1, 7}, // Mahir
                {0, 3, 2} // Professional
            },
            { // Ujian Singing
                {4, 5, 3}, // Pemula
                {3, 2, 5}, // Lanjutan
                {6, 0, 8}, // Mahir
                {2, 1, 6} // Professional
            }
        };

        // Menampilkan statistik jumlah peserta ujian
        displayStatistics(participantsCount);
    }

    public static void displayStatistics(int[][][] participantsCount) {
        // dimensi: participantsCount = new int[4][4][3]; 
        //          4 ujian x 4 tingkat kemampuan x 3 kelompok usia
        String[] namaUjian = {"Piano", "Violin", "Organ", "Singing"};
        String[] tingkatUjian = {"Pemula", "Lanjutan", "Mahir", "Professional"};
        String[] kelompokUmur = {"Anak", "Remaja", "Dewasa"};

        for (int i = 0; i < 4; i++) {
            System.out.println("Statistik Mata Ujian " + namaUjian[i] + ":");
            for (int j = 0; j < 4; j++) {
                System.out.println("Tingkat: " + tingkatUjian[j]);
                for (int k = 0; k < 3; k++) {
                    System.out.println("\tPeserta " + kelompokUmur[k] + ": " + participantsCount[i][j][k]);
                }
            }
            System.out.println("===============================");
        }

        int calonJumlahLomba = hitungJumlahUjian(participantsCount, "Lanjutan", "Remaja", 25);
        System.out.println("Jumlah mata ujian yang memenuhi syarat perlombaan: " + calonJumlahLomba);
    }
}
