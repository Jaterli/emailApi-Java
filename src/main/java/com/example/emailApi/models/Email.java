package com.example.emailApi.models;

import lombok.*;

import java.time.ZonedDateTime;
@Setter @Getter @AllArgsConstructor @NoArgsConstructor @ToString
public class Email {
    private long id;
    private String remitente;
    private String destinatario;
    private String asunto;
    private String cuerpo;
    private ZonedDateTime fecha;
}
