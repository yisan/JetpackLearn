package com.bingo.databinding;

/**
 * Created by ing on 2021/9/9
 */
public class StarUtils {
    public static String getStar(int star) {
        switch (star) {
            case 1:
                return "一星";
            case 2:
                return "二星";
            case 3:
                return "三星";
            case 4:
                return "四星";
            case 5:
                return "五星";
        }
        return "";
    }
}
