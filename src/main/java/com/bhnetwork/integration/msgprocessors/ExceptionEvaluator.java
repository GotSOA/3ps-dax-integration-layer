package com.bhnetwork.integration.msgprocessors;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.mule.api.ExceptionPayload;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.LoggerMessageProcessor;
import org.mule.api.transport.PropertyScope;

/**
 * Search through Exception chain to determine if exception was caused by a connectivity error,
 * indicating whether the original message can be retried.
 * 
 * @author srata
 *
 */
public class ExceptionEvaluator extends LoggerMessageProcessor {
	
/*
 * INVENTORY of exceptions:
 * 
		1. TimeoutException (WaitAndCheck)			-> TimeoutException (on DAX and 3PS side)
		2. Generic Mule Exceptions					-> DispatchException, MessagingException, MuleException, AnnotationException, ComponentException
													-> org.mule.api.expression.ExpressionRuntimeException
		3. DataMapper exceptions?					-> TBD
 */

    @Override
    public MuleEvent process(MuleEvent muleEvent) throws MuleException {
        boolean isRetryableException = false;
        ExceptionPayload ep = muleEvent.getMessage().getExceptionPayload();
        if (ep == null) {
            logger.error("Exception payload is null");
        } else {
            Throwable cause = ep.getException();
            while (cause != null && !isRetryableException) {
            	
            	// TODO: replace the exceptions below to match with inventory of exceptions above
            	// TODO: determine what exceptions can be considered 'retry-able'
                if (	cause instanceof ConnectException || 
                		cause instanceof UnknownHostException || 
                		cause instanceof SocketTimeoutException 
                	) {
                    isRetryableException = true;
                    logger.error("Message failed due to RETRY-able exception. ClassName: " + cause.getClass().getName() +  ", Message: " + cause.getMessage());
                }
                cause = cause.getCause();
            }
        }
        muleEvent.getMessage().setInvocationProperty("isRetryableException", isRetryableException);
        if(!isRetryableException){
        	Map errorMessage = new HashMap();
        	errorMessage.put("message", ep.getException().getCause().getMessage());
        	errorMessage.put("daxStep", muleEvent.getMessage().getProperty("DaxStep", PropertyScope.SESSION).toString());
        	muleEvent.setSessionVariable("error", errorMessage);
        }
        // TODO: replace message payload by exceptionPayload?
        return muleEvent;
    }

}