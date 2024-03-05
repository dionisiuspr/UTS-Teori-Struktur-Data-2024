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
public class No5 {
    public static void main(String[] args) {
        int jumlahKelinci = 6; 
        int totalEars = countBunnyEars(jumlahKelinci);
        System.out.println("Jumlah telinga semua kelinci: " + totalEars);
    }

    public static int countBunnyEars(int _kelinci) {
        if (_kelinci == 0) {
            return 0;
        } else {
            int ears;
            if (_kelinci % 2 == 0) { // nomor kelinci genap
                ears = 3;
            } else { // nomor kelinci ganjil
                ears = 2;
            }
            return ears + countBunnyEars(_kelinci - 1);
        }
    }
}
