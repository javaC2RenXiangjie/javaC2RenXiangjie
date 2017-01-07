package com.java2.web.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class AbstractExceptionHandler {

	 @Autowired
	    private ReloadableResourceBundleMessageSource resourceBundle;

	    public ReloadableResourceBundleMessageSource getResourceBundle() {
	        return resourceBundle;
	    }

	    public void setResourceBundle(ReloadableResourceBundleMessageSource resourceBundle) {
	        this.resourceBundle = resourceBundle;
	    }

	}

