package com.mtsmda.myBlog.utils;

import com.mtsmda.myBlog.utils.constants.SimpleDateFormatPattern;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by c-DMITMINZ on 6/23/2015.
 */
public class ProjectUtil {

    public static String dateFormatNormalRUMD(GregorianCalendar gregorianCalendar){
        DateFormat dateFormat = new SimpleDateFormat(SimpleDateFormatPattern.FORMAT_RU_MD_DEFAULT);
        return dateFormat.format(gregorianCalendar.getTime());
    }

    public static String dateFormatNormalAny(GregorianCalendar gregorianCalendar, String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(gregorianCalendar.getTime());
    }

}