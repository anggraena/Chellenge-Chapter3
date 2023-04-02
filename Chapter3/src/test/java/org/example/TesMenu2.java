package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesMenu2 {
    private static final String CSV_FILE = "C://temp/direktori/data_sekolah.csv";
    private static final String TXT_FILE = "C://temp/direktori/Average_Median.txt";

    private Menu2 menu2;

    @BeforeEach
    public void setUp(){ menu2 = new Menu2(CSV_FILE, TXT_FILE);}

    @Test
    public void tesReadCsv() throws IOException{
        menu2.readCsv();

        List<List<String>> expectedData = new ArrayList<>();
        expectedData.add(Arrays.asList("1", "2", "3"));
        expectedData.add(Arrays.asList("4", "5", "6"));

        Assertions.assertEquals(expectedData, menu2.getData());
    }

    @Test
    public void tesCalculateMode() throws IOException{
        List<List<String>> testData = new ArrayList<>();
        testData.add(Arrays.asList("1", "2", "2"));
        testData.add(Arrays.asList("3", "4", "5"));

        menu2.setData(testData);

        Assertions.assertEquals("2", menu2.calculateMode());
    }

    @Test
    public void tesCalculateAverage() throws IOException{
        List<List<String>> testData = new ArrayList<>();
        testData.add(Arrays.asList("1", "2", "3"));
        testData.add(Arrays.asList("4", "5", "6"));

        menu2.setData(testData);

        Assertions.assertEquals(3.5, menu2.calculateAverage(), 0.001);
    }

    @Test
    public void tesCalculateMedian() throws IOException{
        List<List<String>> testData = new ArrayList<>();
        testData.add(Arrays.asList("1", "2", "3"));
        testData.add(Arrays.asList("4", "5", "6"));

        menu2.setData(testData);

        Assertions.assertEquals(3.5, menu2.calculateMedian(), 0.001);
    }

    @Test
    public void tesWriteResultFile() throws IOException{
        List<List<String>> testData = new ArrayList<>();
        testData.add(Arrays.asList("1", "2", "2"));
        testData.add(Arrays.asList("3", "4", "5"));

        menu2.setData(testData);
        menu2.writeResultToFile();
    }

    @Test
    public void tesCall() throws IOException{
        boolean hasil = menu2.call();
        Assertions.assertTrue(hasil);
    }
}
