package com.github.unknownUserless.testrcs;

import com.github.unknownUserless.testrcs.db.PivotTableService;
import com.github.unknownUserless.testrcs.db.ResObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Value("#{'${allowableValues}'.split(',')}")
    private List<String> allowableValues;

    @Autowired
    private Validator validator;

    @Autowired
    private PivotTableService service;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object pivotTable(
            @RequestParam("row") String row,
            @RequestParam("col") String col){
        if (!this.validator.validate(row)
                || !this.validator.validate(col))  return ResponseEntity.
                badRequest().body("\"error\":\"Allowable values for col and row requests are: " +
                allowableValues.toString() + "\"");

        return service.getJsonPivotTable(row, col);
    }

}
