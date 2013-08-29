package com.muzima.api.dao;

import com.google.inject.ImplementedBy;
import com.muzima.api.dao.impl.CredentialDaoImpl;
import com.muzima.api.model.Credential;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;

/**
 * TODO: Write brief description about the class here.
 */
@ImplementedBy(CredentialDaoImpl.class)
public interface CredentialDao extends SearchableDao<Credential> {

    /**
     * Get a credential record by the username of the user.
     *
     * @param username the username of the user.
     * @return credential with matching username.
     * @throws ParseException when query parser from lucene unable to parse the query string.
     * @throws IOException    when search api unable to process the resource.
     */
    Credential getByUsername(final String username) throws ParseException, IOException;

    Credential getCredentialByUuid(String uuid) throws IOException;
}
