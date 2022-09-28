package com.tapsCabs.exceptions;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote exception throws in case cab not found
 */

public class CabNotFoundException extends RuntimeException {

    private String logRef;
    public CabNotFoundException( String cab_is_already_deleted,String logRef) {
        super(cab_is_already_deleted);
      this.logRef = logRef;
    }

    public String getLogRef() {
        return logRef;
    }
}
