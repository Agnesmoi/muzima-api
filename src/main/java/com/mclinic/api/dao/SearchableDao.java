package com.mclinic.api.dao;

import com.mclinic.search.api.model.object.BaseSearchable;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.List;

/**
 * TODO: Write brief description about the class here.
 */
public interface SearchableDao<T extends BaseSearchable> {

    /**
     * Get all searchable object for the particular type.
     *
     * @return list of all searchable object or empty list.
     * @throws ParseException when query parser from lucene unable to parse the query string.
     * @throws IOException    when search api unable to process the resource.
     */
    List<T> getAll() throws ParseException, IOException;
}
