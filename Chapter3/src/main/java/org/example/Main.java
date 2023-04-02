package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            int userChoice;
            boolean loop = true;
            // Alocation Path File
            String pathCsv = "C://temp/direktori/data_sekolah.csv";
            String pathMenu1 = "C://temp/direktori/output_mode.txt";
            String pathMenu2 = "C://temp/direktori/Average_Median.txt";

            // while to loop main menu
            while (loop) {
                menu();
                System.out.print("\nInput Anda : ");
                userChoice = scanner.nextInt();

                // switch case to provide choices for user to select the specific menu
                switch (userChoice) {
                    case 1:
                        if (new File(pathCsv).isFile()) {
                            messageSuccess();
                            Menu1 obj = new Menu1(pathCsv, pathMenu1);
                            obj.call();
                        } else {
                            messageFailed();
                        }
                        loop = again();
                        break;
                    case 2:
                        if (new File(pathCsv).isFile()) {
                            messageSuccess();
                            Menu2 menu2 = new Menu2(pathCsv, pathMenu2);
                            menu2.call();
                        } else {
                            messageFailed();
                        }
                        loop = again();
                        break;
                    case 3:
                        if (new File(pathCsv).isFile()) {
                            messageSuccess();
                            Menu1 obj = new Menu1(pathCsv, pathMenu1);
                            Menu2 menu2 = new Menu2(pathCsv, pathMenu2);
                            obj.call();
                            menu2.call();
                        } else {
                            messageFailed();
                        }
                        loop = again();
                        break;
                    case 0:
                        System.out.println("\n==================================================\n");
                        System.out.println("Thanks for using this program..");
                        System.out.println("\n==================================================");
                        System.exit(0); // close program
                        break;
                    default:
                        System.out.println("==================================================");
                        System.out.println("\nInput tidak ditemukan, pilih antara [1/2/3/0]");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menu() {
        System.out.println("\n=================================================");
        System.out.println("        Aplikasi Pengolah Nilai Siswa       ");
        System.out.println("=================================================");
        System.out.println("*Letakkan file csv dengan nama file data_sekolah");
        System.out.println(" di direktori berikut : D://temp/direktori");
        System.out.println("\nPilihan Menu :");
        System.out.println("1. Generate txt untuk menampilkan modus");
        System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
        System.out.println("3. Generate kedua file");
        System.out.println("0. Exit");
    }

    public static boolean again(){
        int loopAgain = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukan pilihan : ");
        int choice = scanner.nextInt();

        return choice == loopAgain;
    }

    // method to print if the specific menu has operating well and asking user to continue leave
    public static void messageSuccess(){
        System.out.println("\n==================================================");
        System.out.println("        Aplikasi Pengolah Nilai Siswa");
        System.out.println("==================================================");
        System.out.println("File telah di generate di C://temp/direktori\nSilakan di cek..\n");
        System.out.println("0 Exit");
        System.out.println("1 Kembali ke menu utama");
    }

    // method to print if the specific menu has operating well and asking user to continue leave
    public static void messageFailed(){
        System.out.println("\n==================================================");
        System.out.println("        Aplikasi Pengolah Nilai Siswa");
        System.out.println("==================================================");
        System.out.println("File tidak ditemukan..\n");
        System.out.println("0 Exit");
        System.out.println("1 Kembali ke menu utama");
    }
}