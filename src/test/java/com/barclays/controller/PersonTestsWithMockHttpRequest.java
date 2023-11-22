package com.barclays.controller;

import com.barclays.model.Address;
import com.barclays.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
class PersonTestsWithMockHttpRequest {


    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper;
    ResultActions resultActions;

    @Test
    void testCreatePerson() throws Exception {
        Person person = new Person();
        person.setName("Bryan");
        person.setEmailAddress("not@my.com");

        Address address = new Address();
        address.setLineOne("5707 S");
        address.setLineTwo("Turner Dr");
        address.setState("UT");
        address.setPostalCode("84121");
        address.setCountry("USA");

        person.setAddress(address);

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/person")
                .content(mapper.writeValueAsString(person))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        person = mapper.readValue(contentAsString, Person.class);

        assertEquals(1, person.getId());
    }
}
