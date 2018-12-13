package com.example;

import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/15 10:40
 * @desc
 */
public class Tests {

    @Test
    public void test1(){
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
    }

    @Test
    public void test2(){
        String s = "^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$";
        Pattern compile = Pattern.compile(s);
//        String date = "2018-11-01 12:00:12";//false
//        String date = "2018-11-01";//true
//        String date = "2018/11/01";//true
        String date = "2018.11.01";//true
        boolean matches = compile.matcher(date).matches();
        System.out.println(matches);
    }

    @Test
    public void test3(){
        java.util.Date date = new java.util.Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2018, 8, 01);
//        java.util.Date time = calendar.getTime();
//        System.out.println(time);
//        System.out.println(monthsBetween(date,time));

        java.util.Date lastMonth = getLastMonth(date, 0, -3, 0);
        System.out.println(lastMonth);
    }

    public static int monthsBetween(java.util.Date start, java.util.Date end){
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(start);
        endDate.setTime(end);
        return Math.abs((endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR)) * 12 + endDate.get(Calendar.MONTH) - startDate.get(Calendar.MONTH));
    }
    public static java.util.Date getLastMonth(java.util.Date dateStr, int addYear, int addMonth, int addDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateStr);
        cal.add(Calendar.YEAR,addYear);
        cal.add(Calendar.MONTH, addMonth);
        cal.add(Calendar.DATE, addDate);

        return cal.getTime();
    }

    public static void main(String[] args){
        int count=100;
        int limit=100;
        int l = count%limit == 0 ? count/limit:count/limit+1;
        System.out.println(l);
    }

    @Test
    public void test4(){
        String bang_account = "0302 0704 1930 0088 707";
        String new_bang_account = bang_account.replace(" ", "");
        System.out.println("bang_account: " + bang_account);
        System.out.println("new_bang_account: " + new_bang_account);
    }
}
