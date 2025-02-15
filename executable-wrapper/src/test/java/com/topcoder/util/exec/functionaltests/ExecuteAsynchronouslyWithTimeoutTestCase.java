package com.topcoder.util.exec.functionaltests;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.topcoder.util.exec.*;
import java.io.File;

/**
 * <p>This test case tests asynchronous execution of a command, with a
 * timeout.</p>
 *
 * @author srowen
 * @version 1.0
 */
public class ExecuteAsynchronouslyWithTimeoutTestCase extends TestCase {

    public void testAsynchronousExecutionNoTimeout() throws Exception {
        final int sleepMS = 2000;
        final int timeoutMS = 3000;
        final AsynchronousExecutorHandle handle =
            Exec.executeAsynchronously(new String[] {"test_files"+File.separatorChar+"sleep", "2"}, timeoutMS);
        assertNotNull("Handle should not be null", handle);
        assertFalse("Execution should not have completed yet",
                    handle.isDone());
        try {
            handle.getExecutionResult();
            fail("Should have thrown an IllegalStateException");
        } catch (IllegalStateException ise) {
            // good
        }
        try {
            handle.getExecutionException();
            fail("Should have thrown an IllegalStateException");
        } catch (IllegalStateException ise) {
            // good
        }
        assertTrue("Running time should be small so far",
                   handle.getRunningTimeMS() < 250);

        Thread.sleep((int)(1.1*sleepMS));

        assertTrue("Execution should have completed", handle.isDone());
        assertNotNull("Result should be available", handle.getExecutionResult());
        assertNull("Should not be any exception", handle.getExecutionException());
        final long runningTimeMS = handle.getRunningTimeMS();
        assertTrue("Running time should be close to the exact running time",
                   runningTimeMS >= (int)(0.9*sleepMS) &&
                   runningTimeMS <= (int)(1.1*sleepMS));
        Thread.sleep(1000);
        assertEquals("Running time should not change after completion",
                     runningTimeMS,
                     handle.getRunningTimeMS());
    }

    public void testAsynchronousExecutionTimeout() throws Exception {
        final int sleepMS = 2000;
        final int timeoutMS = 1000;
        final AsynchronousExecutorHandle handle =
            Exec.executeAsynchronously(new String[] {"test_files"+File.separatorChar+"sleep", "2"}, timeoutMS);
        assertNotNull("Handle should not be null", handle);
        assertFalse("Execution should not have completed yet",
                    handle.isDone());
        try {
            handle.getExecutionResult();
            fail("Should have thrown an IllegalStateException");
        } catch (IllegalStateException ise) {
            // good
        }
        try {
            handle.getExecutionException();
            fail("Should have thrown an IllegalStateException");
        } catch (IllegalStateException ise) {
            // good
        }
        assertTrue("Running time should be small so far",
                   handle.getRunningTimeMS() < 250);

        Thread.sleep((int)(1.1*timeoutMS));

        assertTrue("Execution should have completed", handle.isDone());
        assertNull("Should not be any result", handle.getExecutionResult());
        final ExecutionException exception = handle.getExecutionException();
        assertNotNull("Should be an exception", exception);
        assertTrue("Exception should be an ExecutionTimedOutException",
                   exception instanceof ExecutionTimedOutException);        long runningTimeMS = handle.getRunningTimeMS();
        assertTrue("Running time should be close to timeout",
                   runningTimeMS >= (int)(0.9*timeoutMS) &&
                   runningTimeMS <= (int)(1.1*timeoutMS));
        Thread.sleep(1000);
        assertEquals("Running time should not change after completion",
                     runningTimeMS,
                     handle.getRunningTimeMS());
    }

    public void testHaltedAsynchronousExecutionWithTimeout() throws Exception {
        final AsynchronousExecutorHandle handle =
            Exec.executeAsynchronously(new String[] {"test_files"+File.separatorChar+"sleep", "2"}, 1000);
        assertNotNull("Handle should not be null", handle);
        assertFalse("Execution should not have completed yet",
                    handle.isDone());
        try {
            handle.getExecutionResult();
            fail("Should have thrown an IllegalStateException");
        } catch (IllegalStateException ise) {
            // good
        }
        try {
            handle.getExecutionException();
            fail("Should have thrown an IllegalStateException");
        } catch (IllegalStateException ise) {
            // good
        }
        assertTrue("Running time should be small so far",
                   handle.getRunningTimeMS() < 250);

        handle.halt();

        assertTrue("Execution should have completed", handle.isDone());
        assertNull("Should not be any result", handle.getExecutionResult());
        final ExecutionException exception = handle.getExecutionException();
        assertNotNull("Should be an exception", exception);
        assertTrue("Exception should be an ExecutionHaltedException",
                   exception instanceof ExecutionHaltedException);
        final long runningTimeMS = handle.getRunningTimeMS();
        assertTrue("Running time should be small",
                   handle.getRunningTimeMS() < 250);
        Thread.sleep(1000);
        assertTrue("Running time should still be small",
                   handle.getRunningTimeMS() < 250);
    }

    public static Test suite() {
        return new TestSuite(ExecuteAsynchronouslyWithTimeoutTestCase.class);
    }
}
