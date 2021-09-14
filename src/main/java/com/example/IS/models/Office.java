package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "offices")
@Getter
@Setter
@ToString
public class Office {
    @Id
    @SequenceGenerator(name = "office_seq", sequenceName =
            "office_sequence", allocationSize = 1)
    @GeneratedValue(generator = "office_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "office_id")
    private int officeId;

    @Column(name = "address")
    @Size(max = 100, message = "Size should not be more than 100 symbols")
    private String address;
}
