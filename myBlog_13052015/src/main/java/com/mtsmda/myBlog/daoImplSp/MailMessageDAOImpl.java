package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.SP.BlogStoredProcedure;
import com.mtsmda.myBlog.dao.MailMessageDAO;
import com.mtsmda.myBlog.model.Captcha;
import com.mtsmda.myBlog.model.MailMessage;
import com.mtsmda.myBlog.model.dbConst.CaptchaDbConst;
import com.mtsmda.myBlog.model.dbConst.MailMessageDbConst;
import com.mtsmda.myBlog.utils.ProjectUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by c-DMITMINZ on 6/16/2015.
 */
public class MailMessageDAOImpl implements MailMessageDAO {

    private static final Logger logger = Logger.getLogger(MailMessageDAOImpl.class);

    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    private BlogStoredProcedure blogStoredProcedure;

    @Autowired
    public MailMessageDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public boolean saveOrUpdateMailMessage(MailMessage mailMessage) {
        if (mailMessage != null) {
            List<SqlParameter> sqlParameters = new ArrayList<SqlParameter>();
            sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_MAIL_MESSAGE_MAILTO);
            sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_MAIL_MESSAGE_MAILFROM);
            sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_MAIL_MESSAGE_MAILSUBJECT);
            sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_MAIL_MESSAGE_PERSONNAME);
            sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_MAIL_MESSAGE_PHONENUMBER);
            sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_MAIL_MESSAGE_MAILTEXT);
            sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_MAIL_MESSAGE_SENDDATEPERSON);
            sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_MAIL_MESSAGE_SENDDATESERVER);
            sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_MAIL_MESSAGE_ERROROREXCEPTION);
            if (mailMessage.getIdMailMessage() == null) {
                //insert
                logger.info(this.getClass().getCanonicalName() + ".saveOrUpdateMailMessage(MailMessage mailMessage) - insert");

                blogStoredProcedure = new BlogStoredProcedure(dataSource, MailMessageDbConst.MailMessageSPName.INSERT_MAILMESSAGE, sqlParameters);
                Map<String, Object> contactsMap = blogStoredProcedure.execute(mailMessage.getMailTo(), mailMessage.getMailFrom(), mailMessage.getMailSubject(),
                        mailMessage.getPersonName(), mailMessage.getPhoneNumber(), mailMessage.getMailText(), ProjectUtil.dateFormatNormalRUMD(mailMessage.getSendDatePerson()),
                        ProjectUtil.dateFormatNormalRUMD(mailMessage.getSendDateServer()), mailMessage.getErrorOrException());
                return resultIUD(contactsMap);
            } else {
                //update
                /*sqlParameters.add(MailMessageDbConst.MailMessageSPParamName.SQL_PARAMETER_ID);
                spContact = new SPContactImpl(dataSource, INSERT_CONTACT, sqlParameters);
                Map<String, Object> contactsMap = spContact.execute(contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone());*/
            }
        }
        return false;
    }

    @Override
    public boolean deleteMailMessage(Integer mailMessageId) {
        return true;
    }

    @Override
    public MailMessage getMailMessage(Integer mailMessageId) {
        return null;
    }

    @Override
    public List<MailMessage> getAllMailMessage() {
        return null;
    }

    /**
     * resultIUD
     * I - Insert
     * U - Update
     * D - Delete
     */
    private boolean resultIUD(Map<String, Object> contactsMap) {
        if (!contactsMap.isEmpty()) {
            int i = 0;
            for (String key : contactsMap.keySet()) {
                i++;
                if (key != null && contactsMap.get(key) != null && contactsMap.get(key) instanceof Integer) {
                    if (((Integer) contactsMap.get(key)).equals(1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
