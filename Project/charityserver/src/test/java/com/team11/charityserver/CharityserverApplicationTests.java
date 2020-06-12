package com.team11.charityserver;

import com.team11.charityserver.mapper.UserMapper;
import com.team11.charityserver.model.Charity;
import com.team11.charityserver.model.User;
import com.team11.charityserver.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CharityserverApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

//    @Test
//    @Transactional
//    public void saveUser() {
//        User user = new User();
//        user.setRoleId(3);
//        user.setUsername("zzh");
//        user.setGender("male");
//        user.setPassword("123");
//        user.setTelephone("7738427156");
//        user.setMail("zzhou53@sheffield.ac.uk");
//        userService.addUser(user);
//        Assert.assertTrue(user.getUserId() > 0);
//    }

    @Test
    public void listAll() {
        ParameterizedTypeReference<List<Charity>> type = new ParameterizedTypeReference<List<Charity>>() {};
        ResponseEntity<List<Charity>> result = restTemplate.exchange("/charities", HttpMethod.GET, null, type);
        Assert.assertThat(result.getBody().get(0).getCharityName(), Matchers.notNullValue());
    }


}
