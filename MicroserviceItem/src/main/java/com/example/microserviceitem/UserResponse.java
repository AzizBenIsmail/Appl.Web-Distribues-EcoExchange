package com.example.microserviceitem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    Long Id;
    String username;
    String firstName;
    String lastName;
    String Email;
    int Age;
    String Address;
    String phoneNumber;

}
