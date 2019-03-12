package com.example;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.util.Arrays;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    @Test
    public void test5(){
        String result = "NC50ZZ201812130001-传入的资金调拨单来源单据编码已存在,NJ0256CX201812130001,SZ30ZZ201812130001-传入的资金调拨单来源单据编码已存在,TJ1202CX201812130001-传入的资金调拨单来源单据编码已存在,TJ1202CX201812130002-传入的资金调拨单来源单据编码已存在,NJ0256CX201812130001,";
        List<String> errorMsg = Arrays.asList(result.split(","));
        System.out.println(errorMsg);
        //update by yanzt 218/11/02   eas返回错误信息格式  0440701f-de6d-11e8-ba6d-005056a15bad-传入的资金调拨单来源单据编码已存在
        List<String> errorNos = errorMsg.stream().map(s -> {
            int i = s.lastIndexOf("-");
            if(i<0){
                return s;
            }
            return s.substring(0, i);
        }).collect(Collectors.toList());
        System.out.println(errorNos);
    }


    @Test
    public void test6(){
        String result = "NC50ZZ201812130001-传入的资金调拨单来源单据编码已存在,TJ1202CX201812130001-传入的资金调拨单来源单据编码已存在,TJ1202CX201812130002-传入的资金调拨单来源单据编码已存在,NJ0256CX201812130001,SZ30ZZ201812130001-传入的资金调拨单来源单据编码已存在,TJS26ZZ201812130001-传入的资金调拨单来源单据编码已存在,QF2018121300002-传入的资金调拨单来源单据编码已存在,QF2018121300004-传入的资金调拨单来源单据编码已存在,QF2018121300011-传入的资金调拨单来源单据编码已存在,QF2018121300014-传入的资金调拨单来源单据编码已存在,QF2018121300015-传入的资金调拨单来源单据编码已存在,QF2018121300018-传入的资金调拨单来源单据编码已存在,QF2018121300025-传入的资金调拨单来源单据编码已存在,QF2018121300028-传入的资金调拨单来源单据编码已存在,QF2018121300029-传入的资金调拨单来源单据编码已存在,QF2018121300031-传入的资金调拨单来源单据编码已存在,QF2018121300037-传入的资金调拨单来源单据编码已存在,QF2018121300040-传入的资金调拨单来源单据编码已存在,QF2018121300044-传入的资金调拨单来源单据编码已存在,QF2018121300049-传入的资金调拨单来源单据编码已存在,QF2018121300051-传入的资金调拨单来源单据编码已存在,QF2018121300055-传入的资金调拨单来源单据编码已存在,QF2018121300061-传入的资金调拨单来源单据编码已存在,QF2018121300062-传入的资金调拨单来源单据编码已存在,QF2018121300063-传入的资金调拨单来源单据编码已存在,QF2018121300072-传入的资金调拨单来源单据编码已存在,QF2018121300075-传入的资金调拨单来源单据编码已存在,QF2018121300080-传入的资金调拨单来源单据编码已存在,QF2018121300081-传入的资金调拨单来源单据编码已存在,QF2018121300084-传入的资金调拨单来源单据编码已存在,QF2018121300091-传入的资金调拨单来源单据编码已存在,QF2018121300092-传入的资金调拨单来源单据编码已存在,QF2018121300093-传入的资金调拨单来源单据编码已存在,QF2018121300096-传入的资金调拨单来源单据编码已存在,QF2018121300101-传入的资金调拨单来源单据编码已存在,QF2018121300102-传入的资金调拨单来源单据编码已存在,QF2018121300103-传入的资金调拨单来源单据编码已存在,QF2018121300109-传入的资金调拨单来源单据编码已存在,QF2018121300112-传入的资金调拨单来源单据编码已存在,QF2018121300115-传入的资金调拨单来源单据编码已存在,QF2018121300117-传入的资金调拨单来源单据编码已存在,QF2018121300118-传入的资金调拨单来源单据编码已存在,QF2018121300122-传入的资金调拨单来源单据编码已存在,QF2018121300128-传入的资金调拨单来源单据编码已存在,QF2018121300129-传入的资金调拨单来源单据编码已存在,QF2018121300131-传入的资金调拨单来源单据编码已存在,QF2018121300132-传入的资金调拨单来源单据编码已存在,QF2018121300138-传入的资金调拨单来源单据编码已存在,QF2018121300142-传入的资金调拨单来源单据编码已存在,QF2018121300148-传入的资金调拨单来源单据编码已存在,QF2018121300149-传入的资金调拨单来源单据编码已存在,QF2018121300155-传入的资金调拨单来源单据编码已存在,QF2018121300156-传入的资金调拨单来源单据编码已存在,QF2018121300157-传入的资金调拨单来源单据编码已存在,QF2018121300159-传入的资金调拨单来源单据编码已存在,QF2018121300163-传入的资金调拨单来源单据编码已存在,QF2018121300164-传入的资金调拨单来源单据编码已存在,QF2018121300165-传入的资金调拨单来源单据编码已存在,QF2018121300168-传入的资金调拨单来源单据编码已存在,QF2018121300169-传入的资金调拨单来源单据编码已存在,QF2018121300170-传入的资金调拨单来源单据编码已存在,QF2018121300172-传入的资金调拨单来源单据编码已存在,QF2018121300173-传入的资金调拨单来源单据编码已存在,QF2018121300175-传入的资金调拨单来源单据编码已存在,QF2018121300176-传入的资金调拨单来源单据编码已存在,QF2018121300178-传入的资金调拨单来源单据编码已存在,QF2018121300181-传入的资金调拨单来源单据编码已存在,QF2018121300182-传入的资金调拨单来源单据编码已存在,QF2018121300184-传入的资金调拨单来源单据编码已存在,QF2018121300186-传入的资金调拨单来源单据编码已存在,QF2018121300192-传入的资金调拨单来源单据编码已存在,QF2018121300194-传入的资金调拨单来源单据编码已存在,QF2018121300197-传入的资金调拨单来源单据编码已存在,QF2018121300198-传入的资金调拨单来源单据编码已存在,QF2018121300200-传入的资金调拨单来源单据编码已存在,QF2018121300205-传入的资金调拨单来源单据编码已存在,QF2018121300207-传入的资金调拨单来源单据编码已存在,QF2018121300208-传入的资金调拨单来源单据编码已存在,QF2018121300211-传入的资金调拨单来源单据编码已存在,QF2018121300213-传入的资金调拨单来源单据编码已存在,QF2018121300219-传入的资金调拨单来源单据编码已存在,QF2018121300221-传入的资金调拨单来源单据编码已存在,QF2018121300222-传入的资金调拨单来源单据编码已存在,QF2018121300226-传入的资金调拨单来源单据编码已存在,QF2018121300227-传入的资金调拨单来源单据编码已存在,QF2018121300229-传入的资金调拨单来源单据编码已存在,QF2018121300232-传入的资金调拨单来源单据编码已存在,QF2018121300236-传入的资金调拨单来源单据编码已存在,QF2018121300237-传入的资金调拨单来源单据编码已存在,QF2018121300240-传入的资金调拨单来源单据编码已存在,QF2018121300242-传入的资金调拨单来源单据编码已存在,QF2018121300243-传入的资金调拨单来源单据编码已存在,QF2018121300245-传入的资金调拨单来源单据编码已存在,QF2018121300249-传入的资金调拨单来源单据编码已存在,QF2018121300250-传入的资金调拨单来源单据编码已存在,QF2018121300252-传入的资金调拨单来源单据编码已存在,QF2018121300253-传入的资金调拨单来源单据编码已存在,QF2018121300258-传入的资金调拨单来源单据编码已存在,QF2018121300260-传入的资金调拨单来源单据编码已存在,QF2018121300261-传入的资金调拨单来源单据编码已存在,";
        List<String> errorMsg = Arrays.asList(result.split(","));
        System.out.println(errorMsg);
        //update by yanzt 218/11/02   eas返回错误信息格式  0440701f-de6d-11e8-ba6d-005056a15bad-传入的资金调拨单来源单据编码已存在
        List<String> errorNos = errorMsg.stream().map(s -> {
            int i = s.lastIndexOf("-");
            if(i<0){
                return s;
            }
            return s.substring(0, i);
        }).collect(Collectors.toList());
        System.out.println(errorNos);
    }

    @Test
    public void test7(){
        String result = "NC50ZZ201812130001-传入的资金调拨单来源单据编码已存在,TJ1202CX201812130001-传入的资金调拨单来源单据编码已存在,TJ1202CX201812130002-传入的资金调拨单来源单据编码已存在,NJ0256CX201812130001,SZ30ZZ201812130001-传入的资金调拨单来源单据编码已存在,TJS26ZZ201812130001-传入的资金调拨单来源单据编码已存在,QF2018121300002-传入的资金调拨单来源单据编码已存在,QF2018121300004-传入的资金调拨单来源单据编码已存在,QF2018121300011-传入的资金调拨单来源单据编码已存在,QF2018121300014-传入的资金调拨单来源单据编码已存在,QF2018121300015-传入的资金调拨单来源单据编码已存在,QF2018121300018-传入的资金调拨单来源单据编码已存在,QF2018121300025-传入的资金调拨单来源单据编码已存在,QF2018121300028-传入的资金调拨单来源单据编码已存在,QF2018121300029-传入的资金调拨单来源单据编码已存在,QF2018121300031-传入的资金调拨单来源单据编码已存在,QF2018121300037-传入的资金调拨单来源单据编码已存在,QF2018121300040-传入的资金调拨单来源单据编码已存在,QF2018121300044-传入的资金调拨单来源单据编码已存在,QF2018121300049-传入的资金调拨单来源单据编码已存在,QF2018121300051-传入的资金调拨单来源单据编码已存在,QF2018121300055-传入的资金调拨单来源单据编码已存在,QF2018121300061-传入的资金调拨单来源单据编码已存在,QF2018121300062-传入的资金调拨单来源单据编码已存在,QF2018121300063-传入的资金调拨单来源单据编码已存在,QF2018121300072-传入的资金调拨单来源单据编码已存在,QF2018121300075-传入的资金调拨单来源单据编码已存在,QF2018121300080-传入的资金调拨单来源单据编码已存在,QF2018121300081-传入的资金调拨单来源单据编码已存在,QF2018121300084-传入的资金调拨单来源单据编码已存在,QF2018121300091-传入的资金调拨单来源单据编码已存在,QF2018121300092-传入的资金调拨单来源单据编码已存在,QF2018121300093-传入的资金调拨单来源单据编码已存在,QF2018121300096-传入的资金调拨单来源单据编码已存在,QF2018121300101-传入的资金调拨单来源单据编码已存在,QF2018121300102-传入的资金调拨单来源单据编码已存在,QF2018121300103-传入的资金调拨单来源单据编码已存在,QF2018121300109-传入的资金调拨单来源单据编码已存在,QF2018121300112-传入的资金调拨单来源单据编码已存在,QF2018121300115-传入的资金调拨单来源单据编码已存在,QF2018121300117-传入的资金调拨单来源单据编码已存在,QF2018121300118-传入的资金调拨单来源单据编码已存在,QF2018121300122-传入的资金调拨单来源单据编码已存在,QF2018121300128-传入的资金调拨单来源单据编码已存在,QF2018121300129-传入的资金调拨单来源单据编码已存在,QF2018121300131-传入的资金调拨单来源单据编码已存在,QF2018121300132-传入的资金调拨单来源单据编码已存在,QF2018121300138-传入的资金调拨单来源单据编码已存在,QF2018121300142-传入的资金调拨单来源单据编码已存在,QF2018121300148-传入的资金调拨单来源单据编码已存在,QF2018121300149-传入的资金调拨单来源单据编码已存在,QF2018121300155-传入的资金调拨单来源单据编码已存在,QF2018121300156-传入的资金调拨单来源单据编码已存在,QF2018121300157-传入的资金调拨单来源单据编码已存在,QF2018121300159-传入的资金调拨单来源单据编码已存在,QF2018121300163-传入的资金调拨单来源单据编码已存在,QF2018121300164-传入的资金调拨单来源单据编码已存在,QF2018121300165-传入的资金调拨单来源单据编码已存在,QF2018121300168-传入的资金调拨单来源单据编码已存在,QF2018121300169-传入的资金调拨单来源单据编码已存在,QF2018121300170-传入的资金调拨单来源单据编码已存在,QF2018121300172-传入的资金调拨单来源单据编码已存在,QF2018121300173-传入的资金调拨单来源单据编码已存在,QF2018121300175-传入的资金调拨单来源单据编码已存在,QF2018121300176-传入的资金调拨单来源单据编码已存在,QF2018121300178-传入的资金调拨单来源单据编码已存在,QF2018121300181-传入的资金调拨单来源单据编码已存在,QF2018121300182-传入的资金调拨单来源单据编码已存在,QF2018121300184-传入的资金调拨单来源单据编码已存在,QF2018121300186-传入的资金调拨单来源单据编码已存在,QF2018121300192-传入的资金调拨单来源单据编码已存在,QF2018121300194-传入的资金调拨单来源单据编码已存在,QF2018121300197-传入的资金调拨单来源单据编码已存在,QF2018121300198-传入的资金调拨单来源单据编码已存在,QF2018121300200-传入的资金调拨单来源单据编码已存在,QF2018121300205-传入的资金调拨单来源单据编码已存在,QF2018121300207-传入的资金调拨单来源单据编码已存在,QF2018121300208-传入的资金调拨单来源单据编码已存在,QF2018121300211-传入的资金调拨单来源单据编码已存在,QF2018121300213-传入的资金调拨单来源单据编码已存在,QF2018121300219-传入的资金调拨单来源单据编码已存在,QF2018121300221-传入的资金调拨单来源单据编码已存在,QF2018121300222-传入的资金调拨单来源单据编码已存在,QF2018121300226-传入的资金调拨单来源单据编码已存在,QF2018121300227-传入的资金调拨单来源单据编码已存在,QF2018121300229-传入的资金调拨单来源单据编码已存在,QF2018121300232-传入的资金调拨单来源单据编码已存在,QF2018121300236-传入的资金调拨单来源单据编码已存在,QF2018121300237-传入的资金调拨单来源单据编码已存在,QF2018121300240-传入的资金调拨单来源单据编码已存在,QF2018121300242-传入的资金调拨单来源单据编码已存在,QF2018121300243-传入的资金调拨单来源单据编码已存在,QF2018121300245-传入的资金调拨单来源单据编码已存在,QF2018121300249-传入的资金调拨单来源单据编码已存在,QF2018121300250-传入的资金调拨单来源单据编码已存在,QF2018121300252-传入的资金调拨单来源单据编码已存在,QF2018121300253-传入的资金调拨单来源单据编码已存在,QF2018121300258-传入的资金调拨单来源单据编码已存在,QF2018121300260-传入的资金调拨单来源单据编码已存在,QF2018121300261-传入的资金调拨单来源单据编码已存在,";
        List<String> errorMsg = Arrays.asList(result.split(","));
        System.out.println(errorMsg);
        errorMsg.forEach(s -> {
            int i = s.lastIndexOf("-");
            String no = i<0?s:s.substring(0,i);
            String msg = i<0?"":s.substring(i+1);
            System.out.println("no: " + no + ",msg: " + msg);
        });
    }

    @Test
    public void test8() throws ParseException {
        SimpleDateFormat yyyymmdDhhmmss = new SimpleDateFormat("yyyyMMddHHmmss");
        java.util.Date parse = yyyymmdDhhmmss.parse("20181204140100");
        System.out.println(parse);
        String format = yyyymmdDhhmmss.format(parse);
        System.out.println(format);
        System.out.println("2017"+"1204");
    }

    @Test
    public void test9(){
        String s = "asd_bvnhj_123123";
        String substring = s.substring(s.lastIndexOf("_")+1);
        String substring2 = s.substring(0,s.lastIndexOf("_"));
        System.out.println(substring);
        System.out.println(substring2);
        String ss = " as d ";
        String trim = ss.trim();
        System.out.println(ss);
        System.out.println(trim);
    }

    @Test
    public void test10(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String s = "$2a$10$V1VtKl.2hhczpRY.6n205.KTTxbrgONIBdDbu7C05.lgx.TgVYS7u";
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
        boolean matches = bCryptPasswordEncoder.matches("123", s);
        System.out.println(matches);
    }
}
