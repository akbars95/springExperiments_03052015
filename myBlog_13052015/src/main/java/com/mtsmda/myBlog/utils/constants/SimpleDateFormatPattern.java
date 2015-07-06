package com.mtsmda.myBlog.utils.constants;

import java.text.SimpleDateFormat;

/**
 * Created by c-DMITMINZ on 6/25/2015.
 */
public interface SimpleDateFormatPattern {

    public static final String FORMAT_RU_MD_DEFAULT = "dd.MM.yyyy HH:mm:ss";
    public static final String FORMAT_EN = "dd/MM/yyyy HH:mm:ss";
    public static final String FORMAT_EN_SEPARATOR_DASH = "dd-MM-yyyy HH:mm:ss";

    public static final SimpleDateFormat SDF_FORMAT_EN_SEPARATOR_DASH = new SimpleDateFormat(FORMAT_EN_SEPARATOR_DASH);
    public static final SimpleDateFormat SDF_FORMAT_RU_MD_DEFAULT = new SimpleDateFormat(SimpleDateFormatPattern.FORMAT_RU_MD_DEFAULT);

}