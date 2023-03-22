package org.example.mapper;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GuestMapper {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private Integer passportId;
}
