package com.example.session.db;

import com.example.session.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepository {
    private List<UserDto> userDtoList = new ArrayList<>();


    public Optional<UserDto> findByName(String name){
        return userDtoList.stream().filter(it->{
            return it.getUserName().equals(name);
        }).findFirst();
    }
    @PostConstruct
    public void init(){

        userDtoList.add(new UserDto("홍길동", "1234"));
        userDtoList.add(new UserDto("홍길동1", "1234"));
        userDtoList.add(new UserDto("홍길동2", "1234"));
    }
}


