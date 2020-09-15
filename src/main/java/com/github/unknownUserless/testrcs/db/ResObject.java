package com.github.unknownUserless.testrcs.db;

import lombok.Data;

@Data
public class ResObject {
    private String row;
    private String col;
    private int val;

    public ResObject(String row, String col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
