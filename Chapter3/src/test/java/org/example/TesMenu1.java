package org.example;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TesMenu1 {
    private final String csvFileName = "C://temp/direktori/data_sekolah.csv";
    private final String txtFileName = "C://temp/direktori/output_mode.txt";


    @Test
        void tesReadCsv() throws IOException{
            Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
            csvProcessor.readCsv();
            List<List<String>> data = csvProcessor.readCsv();
            assertNotNull(data);
            assertEquals(10, data.size());
            assertEquals(Arrays.asList("60", "95", "80", "70", "90"), data.get(0));
            assertEquals(Arrays.asList("40", "75", "90", "80", "60"), data.get(1));
        }

        @Test
        void tesCalculate() throws IOException{
            Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
            csvProcessor.readCsv();
            Map<String, Integer> calculateMap = csvProcessor.calculateFrequency();
            assertNotNull(calculateMap);
            assertEquals(10,calculateMap.size());
            assertEquals(3, calculateMap.get("90   "));
            assertEquals(2, calculateMap.get("70   "));
            assertEquals(1, calculateMap.get("60   "));

        }

        @Test
        void tesSortDataFrequency() throws IOException{
            Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
            csvProcessor.readCsv();
            csvProcessor.sortData();
            List<List<String>> sortedData = csvProcessor.readCsv();
            assertNotNull(sortedData);
            assertEquals(10, sortedData.size());
            assertEquals(Arrays.asList("60", "95", "80", "70", "90"), sortedData.get(0));
            assertEquals(Arrays.asList("30", "60", "90", "70", "80"), sortedData.get(1));
            assertEquals(Arrays.asList("40", "75", "90", "80", "60"), sortedData.get(2));
        }

        @Test
        void tesCalculateMode() throws IOException{
            Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
            csvProcessor.readCsv();
            String mode = csvProcessor.calculateMode();
            assertNotNull(mode);
            assertEquals("90", mode);
        }

        @Test
        void tesWriteToFile() throws IOException{
            Menu1 csvProcessor = new Menu1(csvFileName, txtFileName);
            csvProcessor.readCsv();
            csvProcessor.calculateFrequency();
            csvProcessor.writeModeToFile();
        }



}
