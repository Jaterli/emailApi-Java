package com.example.emailApi.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
@Entity
@Data
@Table(name = "emails") //Si no está creada, se crea automáticamente
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String remitente;
    private String destinatario;
    private String asunto;
    private String cuerpo;
    private ZonedDateTime fecha;
}
