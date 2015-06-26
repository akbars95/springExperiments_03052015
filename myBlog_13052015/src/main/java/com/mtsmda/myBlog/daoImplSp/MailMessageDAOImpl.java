package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.SP.BlogStoredProcedure;
import com.mtsmda.myBlog.dao.MailMessageDAO;
import com.mtsmda.myBlog.model.MailMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

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

            } else {
                //update
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
