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
package com.muzima.api.model;

/**
 * FormTemplate is a single reference to the physical raw data that can be rendered for form filling process. The result
 * of a form filling process is the FormData object. FormTemplate hold a reference to the Form object.
 */
public class FormTemplate extends OpenmrsSearchable {

    private String uuid;

    private String payload;

    private String formUuid;

    /**
     * Get the form uuid.
     *
     * @return the form uuid.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Set the form uuid.
     *
     * @param uuid the form uuid.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Get the form payload.
     *
     * @return the form payload.
     */
    public String getPayload() {
        return payload;
    }

    /**
     * Set the form payload.
     *
     * @param payload the form payload.
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

    /**
     * Get the form uuid for this form template.
     *
     * @return the form uuid for this form template.
     */
    public String getFormUuid() {
        return formUuid;
    }

    /**
     * Set the form uuid for this form template.
     *
     * @param formUuid the form uuid for this form template.ß
     */
    public void setFormUuid(String formUuid) {
        this.formUuid = formUuid;
    }
}
