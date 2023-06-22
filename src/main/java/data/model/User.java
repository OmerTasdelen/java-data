package data.model;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String destination;

}
