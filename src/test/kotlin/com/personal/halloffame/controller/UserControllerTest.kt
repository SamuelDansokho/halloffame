package com.personal.halloffame.controller

import com.personal.halloffame.model.User
import com.personal.halloffame.service.UserService
import org.assertj.core.api.Assertions
import org.junit.Assert.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {



    @MockBean
    private lateinit var userService: UserService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @ParameterizedTest
    @MethodSource("getUserTestSource")
    fun getUserTest(user : User?,expected: String? ,status: ResultMatcher){
        Mockito.doReturn(user).`when`(userService).getUser(Mockito.anyInt())
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/user/get/1"))
                .andExpect(status)
                .andDo(MockMvcResultHandlers.print())
                .andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("getUserListTestSource")
    fun getUserListTest(users: List<User>?,expected: String,status: ResultMatcher){
        Mockito.doReturn(users).`when`(userService).getAllUser()
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andExpect(status)
                .andDo(MockMvcResultHandlers.print())
                .andReturn()

        Assertions.assertThat(result.response.contentAsString).isEqualTo(expected)
    }

//    @ParameterizedTest
//    @MethodSource("createUserTestSource")
//    fun createUserTest(case: String, expected: UserService.CreationEnum,status: ResultMatcher){
//        val enum= if(case=="OK") UserService.CreationEnum.OK else UserService.CreationEnum.ALREADY_IN_BDD
//        Mockito.doReturn(enum).`when`(userService).createUser(Mockito.any())
//        val result = mockMvc.perform(MockMvcRequestBuilders.get("/user/create"))
//                .andExpect(status)
//                .andReturn()
//
//        Assertions.assertThat(result).isEqualTo(expected)
//    }

    companion object {
        fun generateUser(id: Int): User{
            return User(
                    id = id,
                    isAdmin = true,
                    email = "some-email",
                    password = "some-password",
                    username = "some-username",
                    displayname = "some-displayname")
        }

        @JvmStatic
        fun getUserTestSource() = listOf(
                Arguments.of(generateUser(1),"{\"id\":1,\"username\":\"some-username\",\"password\":\"some-password\",\"email\":\"some-email\",\"displayname\":\"some-displayname\",\"isAdmin\":true}",MockMvcResultMatchers.status().isOk),
                Arguments.of(null,"",MockMvcResultMatchers.status().isOk)
        )

        @JvmStatic
        fun getUserListTestSource() = listOf(
                Arguments.of(
                        listOf(generateUser(1),generateUser(2)),
                        "[{\"id\":1,\"username\":\"some-username\",\"password\":\"some-password\",\"email\":\"some-email\",\"displayname\":\"some-displayname\",\"isAdmin\":true},{\"id\":2,\"username\":\"some-username\",\"password\":\"some-password\",\"email\":\"some-email\",\"displayname\":\"some-displayname\",\"isAdmin\":true}]",
                        MockMvcResultMatchers.status().isOk),
                Arguments.of(
                        null,
                        "",
                        MockMvcResultMatchers.status().isOk)
        )

        @JvmStatic
        fun createUserTestSource() = listOf(
                Arguments.of(
                        "OK",
                        UserService.CreationEnum.OK,
                        MockMvcResultMatchers.status().isOk),
                Arguments.of(
                        "ALREADY",
                        UserService.CreationEnum.ALREADY_IN_BDD,
                        MockMvcResultMatchers.status().isOk)
        )

    }
}

