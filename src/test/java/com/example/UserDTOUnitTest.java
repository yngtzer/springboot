package com.example;

import com.example.dto.UserDTO;
import com.example.model.User;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class UserDTOUnitTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertUserEntityToUserDTO_thenCorrect() {
        User user = new User("Johan", 3750.45);
        UserDTO userDto = modelMapper.map(user, UserDTO.class);
        assertEquals(user.getName(), userDto.getName());
        assertEquals(user.getSalary(), userDto.getSalary(), 0.001);
    }
}
