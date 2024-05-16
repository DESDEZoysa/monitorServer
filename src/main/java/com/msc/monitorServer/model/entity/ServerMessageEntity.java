package com.msc.monitorServer.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "server_message")
public class ServerMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "server_message_id_seq")
    @SequenceGenerator(name = "server_message_id_seq", sequenceName = "server_message_id_seq", allocationSize = 1)
    private Integer id;
    @Column(nullable = false)
    private String prompt;
    @Column(nullable = false)
    private String initialChoicesText;
    private String updatedChoicesText;
}
