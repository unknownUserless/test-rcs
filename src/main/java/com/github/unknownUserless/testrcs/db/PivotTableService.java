package com.github.unknownUserless.testrcs.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PivotTableService {

    @Autowired
    private JdbcTemplate template;

    public List<ResObject> getJsonPivotTable(String row, String col) {
        String query = "SELECT " + row + ", " + col + ", v" + " FROM source_data;";
        List<ResObject> res = new ArrayList<>();

        SqlRowSet rs = template.queryForRowSet(query);

        while (rs.next()) {
            String rowVal = rs.getString(row);
            String colVal = rs.getString(col);
            int val = rs.getInt("v");
            ResObject o = new ResObject(rowVal, colVal, val);
            res.add(o);
        }

        return res;
    }

}
