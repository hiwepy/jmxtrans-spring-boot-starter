package org.jmxtrans.embedded;

import java.util.Map;
import java.util.concurrent.Callable;

import org.jmxtrans.embedded.util.network.MacAddressUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ExtendedResultNameStrategy extends ResultNameStrategy {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected Map<String, Callable<String>> _expressionEvaluators = null;
    
	public ExtendedResultNameStrategy() {
		super();
		try {
            
			String macAddress = MacAddressUtils.getMacAddress();;
            registerExpressionEvaluator("mac_address", macAddress);
            registerExpressionEvaluator("escaped_mac_address", macAddress.replaceAll("\\:", "_"));
            
        } catch (Exception e) {
            logger.error("Exception resolving localhost, expressions like #hostname#, #canonical_hostname# or #hostaddress# will not be available", e);
        }
	}
	 
}
