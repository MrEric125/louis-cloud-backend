
package com.louis.common.api.search.exception;

import org.springframework.core.NestedRuntimeException;


/**
 * @author John·Louis
 * @date 2019年5月30日22:53:36
 */
public class SearchException extends NestedRuntimeException {

    private static final long serialVersionUID = -4652746499385902019L;

    public SearchException(String msg) {
        super(msg);
    }

    public SearchException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
