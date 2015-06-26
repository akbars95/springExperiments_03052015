package com.mtsmda.myBlog.utils;

/**
 * Created by c-DMITMINZ on 6/19/2015.
 */
public class ErrorExceptionUtil {

    private boolean errorOrException;
    private String errorOrExceptionDescription;

    public ErrorExceptionUtil() {

    }

    public ErrorExceptionUtil(boolean errorOrException, String errorOrExceptionDescription) {
        this.errorOrException = errorOrException;
        this.errorOrExceptionDescription = errorOrExceptionDescription;
    }

    public void setErrorOrExceptionAndDescription(boolean errorOrException, String errorOrExceptionDescription){
        setErrorOrException(errorOrException);
        setErrorOrExceptionDescription(errorOrExceptionDescription);
    }

    public boolean isErrorOrException() {
        return errorOrException;
    }

    public void setErrorOrException(boolean errorOrException) {
        this.errorOrException = errorOrException;
    }

    public String getErrorOrExceptionDescription() {
        return errorOrExceptionDescription;
    }

    public void setErrorOrExceptionDescription(String errorOrExceptionDescription) {
        this.errorOrExceptionDescription = errorOrExceptionDescription;
    }
}