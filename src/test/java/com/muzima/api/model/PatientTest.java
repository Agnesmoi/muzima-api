package com.muzima.api.model;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class PatientTest {

    private Patient patient;

    @Before
    public void setUp() throws Exception {
        patient = new Patient();
        PatientIdentifier patientId1 = getPatientIdentifier("PatientIdTypeName1", "Identifier1");
        PatientIdentifier patientId2 = getPatientIdentifier("PatientIdTypeName2", "Identifier2");
        patient.setIdentifiers(asList(patientId1, patientId2));
    }

    private PatientIdentifier getPatientIdentifier(String patientIdTypeName, String identifier) {
        PatientIdentifier patientId1 = new PatientIdentifier();
        patientId1.setPreferred(true);
        patientId1.setIdentifier(identifier);
        PatientIdentifierType patientIdentifierType = new PatientIdentifierType();
        patientIdentifierType.setName(patientIdTypeName);
        patientId1.setIdentifierType(patientIdentifierType);
        return patientId1;
    }

    @Test
    public void shouldGetSummaryForPatientsWithDefaultGender() throws Exception {
        patient.setNames(asList(personName()));
        assertThat(patient.getSummary(), is("♂ familyName, g m, Identifier1"));
    }

    @Test
    public void shouldGetSummaryForMalePatients() throws Exception {
        patient.setNames(asList(personName()));
        patient.setGender("m");
        assertThat(patient.getSummary(), is("♂ familyName, g m, Identifier1"));
    }

    @Test
    public void shouldGetSummaryForFemalePatients() throws Exception {
        patient.setNames(asList(personName()));
        patient.setGender("f");
        assertThat(patient.getSummary(), is("♀ familyName, g m, Identifier1"));
    }

    @Test
    public void shouldCheckWhetherPatientObjIsSerializable() throws Exception {
        assertThat(new Patient() instanceof Serializable, is(true));
    }

    @Test
    public void shouldReturnPatientIdentifierGivenTheName() throws Exception {
        assertThat(patient.getIdentifier("PatientIdTypeName1").getIdentifier(), is("Identifier1"));
    }

    @Test
    public void shouldReturnNullIfInvalidPatientIdNameIsGiven() throws Exception {
        assertThat(patient.getIdentifier("InvalidIdType"), is(nullValue()));
    }

    private PersonName personName() {
        PersonName personName = new PersonName();
        personName.setFamilyName("familyName");
        personName.setGivenName("givenName");
        personName.setMiddleName("middleName");
        personName.setPreferred(true);
        return personName;
    }
}