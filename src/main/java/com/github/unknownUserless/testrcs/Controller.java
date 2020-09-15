package com.github.unknownUserless.testrcs;

import com.github.unknownUserless.testrcs.db.PivotTableService;
import com.github.unknownUserless.testrcs.db.ResObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PivotTableService service;

    @GetMapping("/")
    public List<ResObject> pivotTable(
            @RequestParam("row") String row,
            @RequestParam("col") String col){

        return service.getJsonPivotTable(row, col);
    }

}
