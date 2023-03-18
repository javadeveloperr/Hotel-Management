package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passport")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column(name = "passport_given_date")
    private LocalDate passportGivenDate;
    @Column(name = "validity_period")
    private LocalDate validityPeriod;
    @Column(name = "given_from")
    private String givenFrom;
    @Column(name = "region")
    private String region;
}
