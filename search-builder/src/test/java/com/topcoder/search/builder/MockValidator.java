/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.search.builder;

import com.topcoder.util.datavalidator.ObjectValidator;


/**
 * <p>This is the Mock for test.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.3
 */
public class MockValidator implements ObjectValidator {
    /**
     * <p> Default Cosntructor.</p>
     *
     */
    public MockValidator() {
    }

    /**
     * <p> Always returns null, since this validator considers any object to be valid. </p>
     *
     * @return null always.
     * @param obj The object to validate (this parameter is ignored)
     */
    public String getMessage(Object obj) {
        return null;
    }

    @Override
    public String[] getMessages(Object object) {
        return new String[0];
    }

    @Override
    public String[] getAllMessages(Object object) {
        return new String[0];
    }

    @Override
    public String[] getAllMessages(Object object, int messageLimit) {
        return new String[0];
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    /**
     * <p>Always returns true, since this validator considers any object to be valid.</p>
     *
     * @return True always.
     * @param obj The object to validate (this parameter is ignored)
     */
    public boolean valid(Object obj) {
        return true;
    }
}
