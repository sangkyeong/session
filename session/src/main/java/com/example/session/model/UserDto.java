package com.example.session.model;

import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userName;

    private String passWord;
}
