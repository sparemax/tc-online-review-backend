/*
 * Copyright (C) 2012 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.management.reviewfeedback;

import com.topcoder.util.errorhandling.ExceptionData;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit tests for <code>ReviewFeedbackManagementConfigurationException</code> class.
 * </p>
 *
 * @author amazingpig
 * @version 1.0
 */
public class ReviewFeedbackManagementConfigurationExceptionTest extends TestCase {
    /**
     * <p>
     * Represents the error message.
     * </p>
     */
    private String message;
    /**
     * <p>
     * Represents the <code>Throwable</code> instance.
     * </p>
     */
    private Throwable cause;
    /**
     * <p>
     * Represents the <code>ExceptionData</code> instance.
     * </p>
     */
    private ExceptionData data;

    /**
     * <p>
     * Sets up the test environment.
     * </p>
     *
     * @throws Exception if any error occurs.
     */
    @Override
    protected void setUp() throws Exception {
        message = "test message";
        cause = new NullPointerException();
        data = new ExceptionData();
        data.setErrorCode("error code");
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     *
     * @throws Exception if any error occurs.
     */
    @Override
    protected void tearDown() throws Exception {
        cause = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ReviewFeedbackManagementConfigurationExceptionTest.class);
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>ReviewFeedbackManagementConfigurationException(String)</code>.
     * </p>
     * <p>
     * Instance should be created successfully.
     * </p>
     */
    public void testCtor1() {
        ReviewFeedbackManagementConfigurationException exception = new ReviewFeedbackManagementConfigurationException(
                message);
        assertNotNull("Instance should be created", exception);
        assertEquals("The message is not correctly set.", message, exception.getMessage());
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>ReviewFeedbackManagementConfigurationException(String,Throwable)</code>.
     * </p>
     * <p>
     * Instance should be created successfully.
     * </p>
     */
    public void testCtor2() {
        ReviewFeedbackManagementConfigurationException exception = new ReviewFeedbackManagementConfigurationException(
                message, cause);
        assertNotNull("Instance should be created", exception);
        assertEquals("The message is not correctly set.", message, exception.getMessage());
        assertEquals("The cause is not correctly set.", cause, exception.getCause());
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>ReviewFeedbackManagementConfigurationException(String, ExceptionData)</code>.
     * </p>
     * <p>
     * Instance should be created successfully.
     * </p>
     */
    public void testCtor3() {
        ReviewFeedbackManagementConfigurationException exception = new ReviewFeedbackManagementConfigurationException(
                message, data);
        assertNotNull("Instance should be created", exception);
        assertEquals("The message is not correctly set.", message, exception.getMessage());
        assertEquals("The error code is not correctly set.", "error code", exception.getErrorCode());
    }

    /**
     * <p>
     * Accuracy test for the constructor
     * <code>ReviewFeedbackManagementConfigurationException(String,Throwable, ExceptionData)</code>.
     * </p>
     * <p>
     * Instance should be created successfully.
     * </p>
     */
    public void testCtor4() {
        ReviewFeedbackManagementConfigurationException exception = new ReviewFeedbackManagementConfigurationException(
                message, cause, data);
        assertNotNull("Instance should be created", exception);
        assertEquals("The message is not correctly set.", message, exception.getMessage());
        assertEquals("The cause is not correctly set.", cause, exception.getCause());
        assertEquals("The error code is not correctly set.", "error code", exception.getErrorCode());
    }
}
