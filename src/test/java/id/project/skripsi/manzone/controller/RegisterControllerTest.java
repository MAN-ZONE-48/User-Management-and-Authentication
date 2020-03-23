package id.project.skripsi.manzone.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import id.project.skripsi.manzone.domain.UserData;
import id.project.skripsi.manzone.dto.RegisterUserDTO;
import id.project.skripsi.manzone.dto.UserRoleDTO;
import id.project.skripsi.manzone.dto.response.RegisterResponse;
import id.project.skripsi.manzone.service.impl.RegisterServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class RegisterControllerTest {

    @InjectMocks
    RegisterController registerController;

    @Mock
    RegisterServiceImpl registerService;

    private MockMvc mockMvc;

    ObjectWriter objectWriter;

    String requestJson = "";

    RegisterResponse response = new RegisterResponse();

    @Before
    public void setUp() throws JsonProcessingException {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();

        RegisterUserDTO firstUser = new RegisterUserDTO();
        UserRoleDTO firstUserRole = new UserRoleDTO();
        firstUserRole.setUserRoleName("WORKER");

        firstUser.setUserName("dema09");
        firstUser.setUserPassword("samplePassword");
        firstUser.setUserEmail("test@gmail.com");
        firstUser.setUserDob(new Date());
        firstUser.setUserGender("male");
        firstUser.setUserPhone("123123");
        firstUser.setUserAddress("street");
        firstUser.setUserRole(firstUserRole);

        response.setData(firstUser);
        given(registerService.saveUserDataForOwner(response)).willReturn(response);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);

        objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        requestJson = objectWriter.writeValueAsString(response);
    }

    @Test
    public void testRegisterForOwnerAndExpectStatusIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/register").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson))
                .andExpect(status().isOk()).andReturn();
    }
}
