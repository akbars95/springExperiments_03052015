package com.mtsmda.myBlog.model;

import java.util.GregorianCalendar;

/**
 * Created by c-DMITMINZ on 5/26/2015.
 * mailMessage
 */
public class MailMessage {

    private Integer idMailMessage;
    private String mailTo;
    private String mailFrom;
    private String mailSubject;
    private String personName;
    private String phoneNumber;
    private String mailText;
    private GregorianCalendar sendDatePerson;
    private GregorianCalendar sendDateServer;
    private String errorOrException;

    public MailMessage() {

    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        if (mailTo.length() > 50) {
            this.mailTo = mailTo.substring(0, 51);
        } else {
            this.mailTo = mailTo;
        }
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        if(mailFrom.length() > 50){
            this.mailFrom = mailFrom.substring(0, 51);
        }
        this.mailFrom = mailFrom;
    }

    public String getMailText() {
        return mailText;
    }

    public void setMailText(String mailText) {
        if(mailText.length() > 255){
            this.mailText = mailText.substring(0, 256);
        }
        this.mailText = mailText;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        if(mailSubject.length() > 50){
            this.mailSubject = mailSubject.substring(0, 51);
        }
        this.mailSubject = mailSubject;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        if(personName.length() > 50){
            this.personName = personName.substring(0, 51);
        }
        this.personName = personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() > 25){
            this.phoneNumber = phoneNumber.substring(0, 26);
        }
        this.phoneNumber = phoneNumber;
    }

    public GregorianCalendar getSendDatePerson() {
        return sendDatePerson;
    }

    public void setSendDatePerson(GregorianCalendar sendDatePerson) {
        this.sendDatePerson = sendDatePerson;
    }

    public GregorianCalendar getSendDateServer() {
        return sendDateServer;
    }

    public void setSendDateServer(GregorianCalendar sendDateServer) {
        this.sendDateServer = sendDateServer;
    }

    public Integer getIdMailMessage() {
        return idMailMessage;
    }

    public void setIdMailMessage(Integer idMailMessage) {
        this.idMailMessage = idMailMessage;
    }

    public String getErrorOrException() {
        return errorOrException;
    }

    public void setErrorOrException(String errorOrException) {
        if(errorOrException.length() > 255){
            this.errorOrException = errorOrException.substring(0, 256);
        }
        this.errorOrException = errorOrException;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailMessage that = (MailMessage) o;

        if (!idMailMessage.equals(that.idMailMessage)) return false;
        if (!mailTo.equals(that.mailTo)) return false;
        if (!mailFrom.equals(that.mailFrom)) return false;
        if (!mailSubject.equals(that.mailSubject)) return false;
        if (!personName.equals(that.personName)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (!mailText.equals(that.mailText)) return false;
        if (sendDatePerson != null ? !sendDatePerson.equals(that.sendDatePerson) : that.sendDatePerson != null)
            return false;
        return !(sendDateServer != null ? !sendDateServer.equals(that.sendDateServer) : that.sendDateServer != null);

    }

    @Override
    public int hashCode() {
        int result = idMailMessage.hashCode();
        result = 31 * result + mailTo.hashCode();
        result = 31 * result + mailFrom.hashCode();
        result = 31 * result + mailSubject.hashCode();
        result = 31 * result + personName.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + mailText.hashCode();
        result = 31 * result + (sendDatePerson != null ? sendDatePerson.hashCode() : 0);
        result = 31 * result + (sendDateServer != null ? sendDateServer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MailMessage{" +
                "idMailMessage=" + idMailMessage +
                ", mailTo='" + mailTo + '\'' +
                ", mailFrom='" + mailFrom + '\'' +
                ", mailSubject='" + mailSubject + '\'' +
                ", personName='" + personName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mailText='" + mailText + '\'' +
                ", sendDatePerson=" + sendDatePerson +
                ", sendDateServer=" + sendDateServer +
                '}';
    }
}