
package com.louis.core.search.exception;

/**
 * @author John·Louis
 * @date 2019年5月30日22:53:36
 */
public final class InvalidSearchValueException extends SearchException {

    private static final long serialVersionUID = 8487778613394418870L;

    public InvalidSearchValueException(String searchProperty, String entityProperty, Object value) {
        this(searchProperty, entityProperty, value, null);
    }

    public InvalidSearchValueException(String searchProperty, String entityProperty, Object value, Throwable cause) {
        super("Invalid Search Value, searchProperty [" + searchProperty + "], " +
                "entityProperty [" + entityProperty + "], value [" + value + "]", cause);
    }

}
