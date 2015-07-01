package com.mtsmda.myBlog.model.dbConst;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.myBlog.model.dbConst.CommonConst.PARAM_IN;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface MailMessageDbConst {

    public interface MailMessageFieldName {

        public static final String MAIL_MESSAGE_ID = "mailMessage_id";
        public static final String MAIL_MESSAGE_MAILTO = "mailMessage_mailTo";
        public static final String MAIL_MESSAGE_MAILFROM = "mailMessage_mailFrom";
        public static final String MAIL_MESSAGE_MAILSUBJECT = "mailMessage_mailSubject";
        public static final String MAIL_MESSAGE_PERSONNAME = "mailMessage_personName";
        public static final String MAIL_MESSAGE_PHONENUMBER = "mailMessage_phoneNumber";
        public static final String MAIL_MESSAGE_MAILTEXT = "mailMessage_mailText";
        public static final String MAIL_MESSAGE_SENDDATEPERSON = "mailMessage_sendDatePerson";
        public static final String MAIL_MESSAGE_SENDDATESERVER = "mailMessage_sendDateServer";
        public static final String MAIL_MESSAGE_ERROROREXCEPTION = "mailMessage_errorOrException";

    }

    public interface MailMessageSPName {

        public static final String INSERT_MAILMESSAGE = "InsertMailMessage";

    }

    public interface MailMessageSPParamName {

        public static final SqlParameter SQL_PARAMETER_ID = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_MAIL_MESSAGE_MAILTO = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_MAILTO + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_MAIL_MESSAGE_MAILFROM = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_MAILFROM + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_MAIL_MESSAGE_MAILSUBJECT = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_MAILSUBJECT + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_MAIL_MESSAGE_PERSONNAME = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_PERSONNAME + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_MAIL_MESSAGE_PHONENUMBER = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_PHONENUMBER + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_MAIL_MESSAGE_MAILTEXT = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_MAILTEXT + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_MAIL_MESSAGE_SENDDATEPERSON = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_SENDDATEPERSON + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_MAIL_MESSAGE_SENDDATESERVER = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_SENDDATESERVER + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_MAIL_MESSAGE_ERROROREXCEPTION = new SqlParameter(MailMessageFieldName.MAIL_MESSAGE_ERROROREXCEPTION + PARAM_IN, Types.VARCHAR);
    }

}
