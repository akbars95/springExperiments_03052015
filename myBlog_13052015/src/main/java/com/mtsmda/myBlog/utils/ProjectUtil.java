package com.mtsmda.myBlog.utils;

import com.mtsmda.myBlog.utils.constants.SimpleDateFormatPattern;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by c-DMITMINZ on 6/23/2015.
 */
public class ProjectUtil {

    public static String dateFormatNormalRUMD(GregorianCalendar gregorianCalendar){
        DateFormat dateFormat = SimpleDateFormatPattern.SDF_FORMAT_RU_MD_DEFAULT;
        return dateFormat.format(gregorianCalendar.getTime());
    }

    public static String dateFormatNormalAny(GregorianCalendar gregorianCalendar, String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(gregorianCalendar.getTime());
    }

    public static GregorianCalendar getGregorianCalendarFromString(String inputDate) throws ParseException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = SimpleDateFormatPattern.SDF_FORMAT_RU_MD_DEFAULT;
        Date date = simpleDateFormat.parse(inputDate);
        gregorianCalendar.setTime(date);

        return gregorianCalendar;
    }

}