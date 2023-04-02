package org.example;

import  java.util.Scanner;
import java.io.IOException;
import java.io.File;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class TesMain {
    private Scanner scanner;
    private String pathCsv;
    private String pathMenu1;
    private String pathMenu2;
    private File csvFile;
    private File fileMenu1;
    private File fileMenu2;

    @BeforeEach
    public void before() throws Exception {
        Scanner scanner = new Scanner(System.in);
        pathCsv = "C://temp/direktori/data_sekolah.csv";
        pathMenu1 = "C://temp/direktori/output_mode.txt";
        pathMenu2 = "C://temp/direktori/Average_Median.txt";
        csvFile = new File(pathCsv);
        fileMenu1 = new File(pathMenu1);
        fileMenu2 = new File(pathMenu2);
    }


    @AfterEach
    public void after() throws Exception {
        csvFile.delete();
        fileMenu1.delete();
        fileMenu2.delete();
    }

    @Test
    public void tesMenu1() throws IOException{
        when(scanner.nextInt()).thenReturn(1, 0);
        Main.main(new String[] {});
        assertTrue(fileMenu1.exists());
        assertFalse(fileMenu2.exists());
    }

    @Test
    public void tesMenu2() throws IOException{
        when(scanner.nextInt()).thenReturn(2,0);
        Main.main(new String[] {});
        assertFalse(fileMenu1.exists());
        assertTrue(fileMenu2.exists());
    }

    @Test
    public void tesMenu3() throws IOException{
        when(scanner.nextInt()).thenReturn(3,0);
        Main.main(new String[] {});
        assertTrue(fileMenu1.exists());
        assertTrue(fileMenu2.exists());
    }

    @Test
    public void tesMenu() throws IOException{
        when(scanner.nextInt()).thenReturn(0);
        Main.main(new String[] {});
    }

    @Test
    public void tesInvalid() throws IOException{
        when(scanner.nextInt()).thenReturn(4, 1, 0);
        Main.main(new String[] {});
    }

    @Test
    public void testNotFound() throws IOException{
        when(scanner.nextInt()).thenReturn(1, 0);
        Main.main(new String[] {});
        assertFalse(fileMenu1.exists());
        assertFalse(fileMenu2.exists());
    }



}
