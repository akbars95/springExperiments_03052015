package com.mtsmda.myBlog.SP;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public class CaptchaSP extends StoredProcedure {

    public CaptchaSP(DataSource dataSource, String nameSP, List<SqlParameter> sqlParameters) {
        super(dataSource, nameSP);
        if(sqlParameters != null && !sqlParameters.isEmpty()){
            for(SqlParameter sqlParameter : sqlParameters){
                declareParameter(sqlParameter);
            }
        }
        compile();
    }

    @Override
    public Map<String, Object> execute(Object ... o) throws DataAccessException {
        Map<String, Object> results = super.execute(o);
        return results;
    }

}
