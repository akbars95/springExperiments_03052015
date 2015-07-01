package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.SP.BlogStoredProcedure;
import com.mtsmda.myBlog.dao.MailMessageDAO;
import com.mtsmda.myBlog.model.Captcha;
import com.mtsmda.myBlog.model.MailMessage;
import com.mtsmda.myBlog.model.dbConst.CaptchaDbConst;
import com.mtsmda.myBlog.model.dbConst.MailMessageDbConst;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mtsmda.myBlog.model.dbConst.CaptchaDbConst.CaptchaSPName.SELECT_CAPTCHA;

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
            if (mailMessage.getIdMailMessage() == null) {
//insert
                logger.info(this.getClass().getCanonicalName() + ".saveOrUpdateMailMessage(MailMessage mailMessage) - insert");

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

                if (contact.getId() != null && contact.getId() > 0) {
                    sqlParameters.add(SQL_PARAMETER_ID);
                    spContact = new SPContactImpl(dataSource, UPDATE_CONTACT, sqlParameters);
                    Map<String, Object> contactsMap = spContact.execute(contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone(), contact.getId());
                    System.out.println(resultIUD(contactsMap));



            } else {
                //update
                    spContact = new SPContactImpl(dataSource, INSERT_CONTACT, sqlParameters);
                    Map<String, Object> contactsMap = spContact.execute(contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone());
                    System.out.println(resultIUD(contactsMap));
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
}
