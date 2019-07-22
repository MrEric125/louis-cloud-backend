
package com.louis.common.api.search.filter;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author John·Louis
 * @date 2019年5月30日22:53:36
 */
public class AndCondition implements SearchFilter {

    private List<SearchFilter> andFilters = Lists.newArrayList();

    AndCondition() {
    }

    public AndCondition add(SearchFilter filter) {
        this.andFilters.add(filter);
        return this;
    }

    public List<SearchFilter> getAndFilters() {
        return andFilters;
    }

    @Override
    public String toString() {
        return "AndCondition{" + andFilters + '}';
    }
}
