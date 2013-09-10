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
import com.muzima.api.dao.impl.ObservationDaoImpl;
import com.muzima.api.model.Observation;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.List;

@ImplementedBy(ObservationDaoImpl.class)
public interface ObservationDao extends OpenmrsDao<Observation> {

    /**
     * Search observations for patient with matching uuid of the question.
     *
     * @param patientUuid the uuid of the patient.
     * @param conceptUuid the uuid of the question of the observations.
     * @return all observations for the patient with question matching the search term.
     * @throws ParseException when query parser from lucene unable to parse the query string.
     * @throws IOException    when search api unable to process the resource.
     */
    List<Observation> get(final String patientUuid, final String conceptUuid) throws IOException;

    List<Observation> get(final String patientUuid, final String conceptUuid,
                          final Integer page, final Integer pageSize) throws IOException;
}
