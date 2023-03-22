package org.example.mapper;
import lombok.*;
import org.example.stuatus.EmployeeStatus;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeMapper {
    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;
    private LocalDate birthDate;
    private EmployeeStatus status;
    private String type;
}
