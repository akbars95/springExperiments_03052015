package com.mtsmda.model.helper;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

/**
 * Created by c-DMITMINZ on 6/9/2015.
 */
public class ContactHelper {

    public interface ContactFieldName {

        public static final String CONTACT_ID = "contact_id";
        public static final String CONTACT_NAME = "contact_name";
        public static final String CONTACT_EMAIL = "contact_email";
        public static final String CONTACT_ADDRESS = "contact_address";
        public static final String CONTACT_TELEPHONE = "contact_telephone";

    }

    public interface ContactSPName {

        public static final String INSERT_CONTACT = "InsertContact";
        public static final String UPDATE_CONTACT = "UpdateContact";
        public static final String DELETE_CONTACT = "DeleteContact";
        public static final String SELECT_ALL_CONTACTS = "SelectAllContacts";
        public static final String SELECT_CONTACT = "SelectContact";

    }

    public interface ContactSPParamName {

        public static final String PARAM_IN = "In";
        public static final String PARAM_OUT = "Out";
        public static final String PARAM_INOUT = PARAM_IN + PARAM_OUT;

        public static final SqlParameter SQL_PARAMETER_ID = new SqlParameter(ContactFieldName.CONTACT_ID + PARAM_IN, Types.INTEGER);
        public static final SqlParameter SQL_PARAMETER_NAME = new SqlParameter(ContactFieldName.CONTACT_NAME + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_EMAIL = new SqlParameter(ContactFieldName.CONTACT_EMAIL + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_ADDRESS = new SqlParameter(ContactFieldName.CONTACT_ADDRESS + PARAM_IN, Types.VARCHAR);
        public static final SqlParameter SQL_PARAMETER_TELEPHONE = new SqlParameter(ContactFieldName.CONTACT_TELEPHONE + PARAM_IN, Types.VARCHAR);

    }


}
