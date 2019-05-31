
package com.louis.core.repository.callback;


import com.louis.core.search.Searchable;

import javax.persistence.Query;

/**
 * @author John·Louis
 * @date 2019年5月30日22:53:36
 */
public final class NoneSearchCallback implements SearchCallback {

    @Override
    public void prepareQL(StringBuilder ql, Searchable search) {
    }

    @Override
    public void prepareOrder(StringBuilder ql, Searchable search) {
    }

    @Override
    public void setValues(Query query, Searchable search) {
    }

    @Override
    public void setPageable(Query query, Searchable search) {
    }
}
