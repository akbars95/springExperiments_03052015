package com.mtsmda.myBlog.model;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public class Captcha {

    private Integer idCaptcha;
    private String pathToImage;
    private String valueCaptcha;

    public Captcha() {

    }

    public Integer getIdCaptcha() {
        return idCaptcha;
    }

    public void setIdCaptcha(Integer idCaptcha) {
        this.idCaptcha = idCaptcha;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public String getValueCaptcha() {
        return valueCaptcha;
    }

    public void setValueCaptcha(String valueCaptcha) {
        this.valueCaptcha = valueCaptcha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Captcha captcha = (Captcha) o;

        if (!idCaptcha.equals(captcha.idCaptcha)) return false;
        if (!pathToImage.equals(captcha.pathToImage)) return false;
        return valueCaptcha.equals(captcha.valueCaptcha);

    }

    @Override
    public int hashCode() {
        int result = idCaptcha.hashCode();
        result = 31 * result + pathToImage.hashCode();
        result = 31 * result + valueCaptcha.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Captcha{" +
                "idCaptcha=" + idCaptcha +
                ", pathToImage='" + pathToImage + '\'' +
                ", valueCaptcha='" + valueCaptcha + '\'' +
                '}';
    }
}
