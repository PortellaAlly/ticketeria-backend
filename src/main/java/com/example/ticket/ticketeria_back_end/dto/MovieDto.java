package com.example.ticket.ticketeria_back_end.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieDto {

    private String title;
    private String sinopse;
    private String img_url;
    private boolean restrito;
    private String class_etaria;

}
