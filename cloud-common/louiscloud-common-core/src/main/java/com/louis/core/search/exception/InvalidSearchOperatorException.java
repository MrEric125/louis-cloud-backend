
package com.louis.core.search.exception;


import com.louis.core.search.SearchOperator;

/**
 * @author John·Louis
 * @date 2019年5月30日22:53:36
 */
public final class InvalidSearchOperatorException extends SearchException {

    private static final long serialVersionUID = 3828695490174795710L;

    public InvalidSearchOperatorException(String searchProperty, String operatorStr) {
        this(searchProperty, operatorStr, null);
    }

    public InvalidSearchOperatorException(String searchProperty, String operatorStr, Throwable cause) {
        super("Invalid Search Operator searchProperty [" + searchProperty + "], " +
                "operator [" + operatorStr + "], must be one of " + SearchOperator.toStringAllOperator(), cause);
    }
}
