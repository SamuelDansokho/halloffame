package com.personal.halloffame.controller

import com.personal.halloffame.model.Person
import com.personal.halloffame.model.User
import com.personal.halloffame.service.PersonService
import com.personal.halloffame.service.UserService
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @MockBean
    private lateinit var personService: PersonService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @ParameterizedTest
    @MethodSource("getPersonTestSource")
    fun getPersonTest(person : Person?,expected: String? ,status: ResultMatcher){
        Mockito.doReturn(person).`when`(personService).getPerson(Mockito.anyInt())
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/person/get/1"))
                .andExpect(status)
                .andReturn()

        System.out.println(result.response.contentAsString)
//        Assertions.assertThat(result.response.contentAsString).isEqualTo(expected)
    }

    companion object {
        fun generatePerson(): Person{
            return Person(
                    id = 1,
                    age = 24,
                    currentClubId = 1,
                    currentNationalTeamId = 1,
                    firstname = "romelu",
                    lastname = "lukaku",
                    nationality = "Belgium")
        }

        @JvmStatic
        fun getPersonTestSource() = listOf(
                Arguments.of(generatePerson(),"{\"id\":1,\"username\":\"some-username\",\"password\":\"some-password\",\"email\":\"some-email\",\"displayname\":\"some-displayname\",\"isAdmin\":true}",MockMvcResultMatchers.status().isOk),
                Arguments.of(null,"",MockMvcResultMatchers.status().isOk)
        )

    }
}

