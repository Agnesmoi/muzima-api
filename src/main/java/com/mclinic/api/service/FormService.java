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
package com.mclinic.api.service;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.mclinic.api.model.Form;
import com.mclinic.api.service.impl.FormServiceImpl;

/**
 * Service handling all operation to the @{Form} actor/model
 */
@ImplementedBy(FormServiceImpl.class)
public interface FormService {

    Form saveForm(final Form form);

    Form updateForm(final Form form);

    Form getFormById(final Integer id);

    List<Form> getAllForms();

    void deleteForm(final Form form);

    void deleteAllForms();
}
