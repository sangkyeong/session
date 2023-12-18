package com.example.session.service;

import com.example.session.db.UserRepository;
import com.example.session.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ){
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optinalUser = userRepository.findByName(id);

        if(optinalUser.isPresent()){
            var userDto = optinalUser.get();

            if(userDto.getPassWord().equals(pw)){
                //세션에 정보저장
                httpSession.setAttribute("USER", userDto);

            }else{
                throw new RuntimeException("PASSWORD NOT MATCH");
            }
        }else{
            throw new RuntimeException("USER NOT FOUND");
        }
    }
}
