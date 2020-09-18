package com.github.unknownUserless.testrcs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ValidatorImpl implements Validator {

    @Value("#{'${allowableValues}'.split(',')}")
    private List<String> allowableValues;

    @Override
    public boolean validate(String param) {
        return allowableValues.contains(param);
    }
}
