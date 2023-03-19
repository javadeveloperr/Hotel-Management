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
@Table(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "guest_id")
    private Integer guestId;
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "get_from")
    private LocalDate getFrom;
    @Column(name = "during_day")
    private Integer duringDay;
    @Column(name = "booking_price")
    private Double bookingPrice;

}
