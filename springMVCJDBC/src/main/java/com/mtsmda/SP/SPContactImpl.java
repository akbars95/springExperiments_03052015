package com.mtsmda.SP;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ParameterMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by c-DMITMINZ on 6/8/2015.
 */
public class SPContactImpl  extends StoredProcedure {

    public SPContactImpl(DataSource dataSource, String nameSP) {
        super(dataSource, nameSP);
        compile();
    }

    @Override
    public Map<String, Object> execute(Object ... o) throws DataAccessException {
        Map<String, Object> results = super.execute();
        return results;
    }
}
