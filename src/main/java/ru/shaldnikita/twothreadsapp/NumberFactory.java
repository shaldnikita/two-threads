/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.shaldnikita.twothreadsapp;

import java.util.*;

/**
 * @author shald
 */
public class NumberFactory {

    private Map<String, Integer> values =  new HashMap<>();;

    public NumberFactory() {
        initValuesMap();
    }

    private void initValuesMap() {
        values.put("one", 1);
        values.put("two", 2);
        values.put("three", 3);
        values.put("four", 4);
        values.put("five", 5);
        values.put("six", 6);
        values.put("seven", 7);
        values.put("eight", 8);
        values.put("nine", 9);
        values.put("ten", 10);
        values.put("eleven", 11);
        values.put("twelve", 12);
        values.put("thirteen", 13);
        values.put("fourteen", 14);
        values.put("fifteen", 15);
        values.put("sixteen", 16);
        values.put("seventeen", 17);
        values.put("eighteen", 18);
        values.put("nineteen", 19);
        values.put("twenty", 20);
        values.put("thirty", 30);
        values.put("forty", 40);
        values.put("fifty", 50);
        values.put("sixty", 60);
        values.put("seventy", 70);
        values.put("eighty", 80);
        values.put("ninety", 90);
        values.put("hundred", 100);
        values.put("thousand", 1000);
    }

    public Integer createNumber(String[] num) {
        int numSize = num.length;
        switch (numSize) {
            case 1:
                return createOneDigitNumber(num);
            case 2:
                return createTwoDigitNumber(num);
            case 3:
                return createThreeDigitNumber(num);
            case 4:
                return createFourDigitNumber(num);
            case 5:
                return createFiveDigitNumber(num);
            case 6:
                return createSixDigitNumber(num);
            default:
                //should not come here
                return -1;
        }
    }

    private Integer createOneDigitNumber(String[] num) {
        return values.get(num[0]);
    }

    private Integer createTwoDigitNumber(String[] num) {
        switch (num[1]) {
            case "hundred":
                return values.get(num[0]) * values.get(num[1]);
            case "thousand":
                return values.get(num[0]) * values.get(num[1]);
            default:
                return values.get(num[0]) + values.get(num[1]);
        }
    }

    private Integer createThreeDigitNumber(String[] num) {
        return values.get(num[0]) * values.get(num[1]) + values.get(num[2]);
    }

    private Integer createFourDigitNumber(String[] num) {
        return values.get(num[0]) * values.get(num[1])
                + (num[3].equals("hundred") ? values.get(num[3]) * values.get(num[2]) : values.get(num[3]) + values.get(num[2]));
    }

    private Integer createFiveDigitNumber(String[] num) {
        //9999 9
        //9999 19
        return values.get(num[0]) * values.get(num[1]) + values.get(num[2]) * values.get(num[3]) + values.get(num[4]);
    }

    private Integer createSixDigitNumber(String[] num) {
        //999999
        return values.get(num[0]) * values.get(num[1]) + values.get(num[2]) * values.get(num[3]) + values.get(num[4])
                * values.get(num[5]);
    }
}
