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
package com.muzima.api.dao;

import com.google.inject.ImplementedBy;
import com.muzima.api.dao.impl.UserDaoImpl;
import com.muzima.api.model.User;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.List;

@ImplementedBy(UserDaoImpl.class)
public interface UserDao extends OpenmrsDao<User> {

    /**
     * Get a user record by the user name of the user.
     *
     * @param username the username
     * @return user with matching username.
     * @throws ParseException when query parser from lucene unable to parse the query string.
     * @throws IOException    when search api unable to process the resource.
     */
    User getByUsername(final String username) throws ParseException, IOException;

    /**
     * Get user by the name of the user. Passing empty string will returns all registered users.
     *
     * @param name the partial name of the user or empty string.
     * @return the list of all matching user on the user name.
     * @throws ParseException when query parser from lucene unable to parse the query string.
     * @throws IOException    when search api unable to process the resource.
     */
    List<User> getByName(final String name) throws ParseException, IOException;
}
