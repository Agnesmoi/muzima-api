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
package com.mclinic.api.service.impl;

import com.google.inject.Inject;
import com.mclinic.api.dao.ObservationDao;
import com.mclinic.api.model.Observation;
import com.mclinic.api.service.ObservationService;
import com.mclinic.search.api.util.StringUtil;
import com.mclinic.util.Constants;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.List;

public class ObservationServiceImpl implements ObservationService {

    @Inject
    private ObservationDao observationDao;

    protected ObservationServiceImpl() {
    }

    /**
     * Download a single observation record from the observation rest resource into the local lucene repository.
     *
     * @param uuid the uuid of the observation.
     * @throws org.apache.lucene.queryParser.ParseException
     *                             when query parser from lucene unable to parse the query string.
     * @throws java.io.IOException when search api unable to process the resource.
     * @should download observation with matching uuid.
     */
    @Override
    public void downloadObservationByUuid(final String uuid) throws IOException, ParseException {
        observationDao.download(uuid, Constants.UUID_OBSERVATION_RESOURCE);
    }

    /**
     * Download all observations with name similar to the partial name passed in the parameter.
     *
     * @param name the partial name of the observation to be downloaded. When empty, will return all observations available.
     * @throws org.apache.lucene.queryParser.ParseException
     *                             when query parser from lucene unable to parse the query string.
     * @throws java.io.IOException when search api unable to process the resource.
     * @should download all observation with partially matched name.
     * @should download all observation when name is empty.
     */
    @Override
    public void downloadObservationsByName(final String name) throws IOException, ParseException {
        observationDao.download(name, Constants.SEARCH_OBSERVATION_RESOURCE);
    }

    /**
     * Get a single observation record from the repository using the uuid of the observation.
     *
     * @param uuid the observation uuid.
     * @return the observation with matching uuid or null when no observation match the uuid.
     * @throws org.apache.lucene.queryParser.ParseException
     *                             when query parser from lucene unable to parse the query string.
     * @throws java.io.IOException when search api unable to process the resource.
     * @should return observation with matching uuid.
     * @should return null when no observation match the uuid.
     */
    @Override
    public Observation getObservationByUuid(final String uuid) throws IOException, ParseException {
        return observationDao.getByUuid(uuid);
    }

    /**
     * Get all observations for the particular patient.
     *
     * @param patientUuid the uuid of the patient.
     * @return list of all observations for the patient or empty list when no observation found for the patient.
     * @throws org.apache.lucene.queryParser.ParseException
     *                             when query parser from lucene unable to parse the query string.
     * @throws java.io.IOException when search api unable to process the resource.
     * @should return list of all observations for the patient.
     * @should return empty list when no observation found for the patient.
     */
    @Override
    public List<Observation> getAllObservations(final String patientUuid) throws IOException, ParseException {
        return observationDao.search(patientUuid, StringUtil.EMPTY);
    }

    /**
     * Search for all observations for the particular patient with matching search term.
     *
     * @param patientUuid the patient.
     * @param term        the search term.
     * @return list of all observations with matching search term on the searchable fields or empty list.
     * @throws org.apache.lucene.queryParser.ParseException
     *                             when query parser from lucene unable to parse the query string.
     * @throws java.io.IOException when search api unable to process the resource.
     * @should return list of all observations with matching search term on the searchable fields.
     * @should return empty list when no observation match the search term.
     */
    @Override
    public List<Observation> searchObservations(final String patientUuid, final String term) throws IOException, ParseException {
        return observationDao.search(patientUuid, term);
    }

    /**
     * Delete a single observation from the local repository.
     *
     * @param observation the observation.
     * @throws org.apache.lucene.queryParser.ParseException
     *                             when query parser from lucene unable to parse the query string.
     * @throws java.io.IOException when search api unable to process the resource.
     * @should delete the observation from the local repository.
     */
    @Override
    public void deleteObservation(final Observation observation) throws IOException, ParseException {
        throw new IOException("Delete operation is not supported for observation object!");
    }
}
