package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "messages")
@Getter
@Setter
@ToString
public class Message {
    @Id
    @SequenceGenerator(name = "office_seq", sequenceName =
            "office_sequence", allocationSize = 1)
    @GeneratedValue(generator = "office_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "message_id")
    private int messageId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    public User sender;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "receiver_id", referencedColumnName = "user_id")
    public User receiver;

    @Column(name = "text")
    private String text;
}
