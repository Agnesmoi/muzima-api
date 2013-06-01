/**
 * Copyright 2012 Muzima Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.muzima.api.dao.impl;

import com.muzima.api.dao.CohortDao;
import com.muzima.api.dao.PrivilegeDao;
import com.muzima.api.model.Privilege;
import com.muzima.search.api.filter.Filter;
import com.muzima.search.api.filter.FilterFactory;
import com.muzima.search.api.util.StringUtil;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrivilegeDaoImpl extends OpenmrsDaoImpl<Privilege> implements PrivilegeDao {

    private static final String TAG = CohortDao.class.getSimpleName();

    protected PrivilegeDaoImpl() {
        super(Privilege.class);
    }

    /**
     * Get privilege by the name of the privilege. Passing empty string will returns all registered privileges.
     *
     * @param name the partial name of the privilege or empty string.
     * @return the list of all matching privilege on the privilege name.
     * @throws ParseException when parsing lucene query in the internal saving process happen.
     * @throws IOException    when reading resource descriptor happen.
     */
    @Override
    public List<Privilege> getByName(final String name) throws ParseException, IOException {
        List<Filter> filters = new ArrayList<Filter>();
        if (!StringUtil.isEmpty(name)) {
            Filter filter = FilterFactory.createFilter("name", name + "*");
            filters.add(filter);
        }
        return service.getObjects(filters, daoClass);
    }
}
