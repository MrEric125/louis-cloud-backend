
package com.louis.core.search.exception;

/**
 * @author John·Louis
 * @date 2019年5月30日22:53:36
 */
public final class InvalidSearchPropertyException extends SearchException {

    private static final long serialVersionUID = 3712096194946409008L;

    public InvalidSearchPropertyException(String searchProperty, String entityProperty) {
        this(searchProperty, entityProperty, null);
    }

    public InvalidSearchPropertyException(String searchProperty, String entityProperty, Throwable cause) {
        super("Invalid Search Property [" + searchProperty + "] Entity Property [" + entityProperty + "]", cause);
    }


}
