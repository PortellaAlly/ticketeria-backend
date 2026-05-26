package com.example.ticket.ticketeria_back_end.database.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieEntity {

    private Integer id;
    private String title;
    private String sinopse;
    private String img_url;
    private boolean restrito;
    private String class_etaria;

}
