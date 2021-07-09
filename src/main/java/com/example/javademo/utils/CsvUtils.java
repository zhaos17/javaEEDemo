package com.example.javademo.utils;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: zhaos
 * @date: 2021/6/23
 */
public class CsvUtils {

    public static void main(String[] args) {
        System.out.println(appendDate(1624291200000L, 1624377599999L));

//        readCsv("https://hkywuyinzifenxi.oss-cn-hangzhou.aliyuncs.com/yd_heat_result/20210623/new.csv");
    }

    public static List<String> appendDate (Long start,Long end) {
        List<String> dateList = new ArrayList<>();

        Date dateDate = new Date(start);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateDate);

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        while (cal.getTime().getTime() <= end) {
            dateList.add(format.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_YEAR,1);
        }
        return dateList;
    }

    public static void readCsv(String path) {
        int max = 1000;
        int radio = 8;
        int[][] xArr = new int[max][max];
        int[][] yArr = new int[max][max];
        int[][] valueArr = new int[max][max];
        try {
            URL url = new URL(path);
            InputStream inputStream = url.openStream();

            DataInputStream in = new DataInputStream(inputStream);
            // CSVReader csvReader = new CSVReader(new InputStreamReader(in,"GBK"));
            CSVReader csvReader = new CSVReader(new InputStreamReader(in, "GBK"), CSVParser.DEFAULT_SEPARATOR,
                    CSVParser.DEFAULT_QUOTE_CHARACTER, CSVParser.DEFAULT_ESCAPE_CHARACTER, 0);
            String[] strs;
            while ((strs = csvReader.readNext()) != null) {
                int x = Integer.parseInt(strs[0]) / radio;
                int y = Integer.parseInt(strs[1]) / radio;

                xArr[x][y] += Integer.parseInt(strs[0]) * Integer.parseInt(strs[2]);
                yArr[x][y] += Integer.parseInt(strs[1]) * Integer.parseInt(strs[2]);
                valueArr[x][y] += Integer.parseInt(strs[2]);
            }
            csvReader.close();

            List<String> resultList = new ArrayList<>();
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < max; j++) {
                    if (valueArr[i][j] > 0 && xArr[i][j] > 0 && yArr[i][j] > 0) {
                        String val = xArr[i][j] / valueArr[i][j] + "," + yArr[i][j] / valueArr[i][j] + "," + valueArr[i][j];
                        resultList.add(val);
                    }
                }
            }
            resultList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
