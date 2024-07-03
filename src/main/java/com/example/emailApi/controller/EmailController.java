package com.example.emailApi.controller;
import com.example.emailApi.models.Email;
import com.example.emailApi.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/emails")
    public List<Email> getAllEmails(){
        return (List<Email>) emailService.getAllEmails();
    }

    @GetMapping("/email/{id}")
    public ResponseEntity<?> getEmailById(@PathVariable Long id){
        Optional<Email> emailRespuesta = emailService.getEmailById(id);
        if (emailRespuesta.isPresent()) {
            return ResponseEntity.ok(emailRespuesta.get());
        } else{
            return
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email no encontrado");
        }

    }

    @PostMapping("/cargarEmails")
    public String precesarEmail(@RequestBody List<Email> emails) {
        emails.forEach(emailService::addEmail);
        return "Se han cargado correctamente los emails";
    }

    @PutMapping("/email/{id}")
    public String actualizarEmail(@PathVariable long id, @RequestBody Email nuevoEmail){
        emailService.actualizarEmail(id, nuevoEmail);
        return "Email con id \" + id + \" ACTUALIZADO";

    }

    @DeleteMapping("/email/{id}")
    public ResponseEntity<String> eliminarEmail(@PathVariable long id){
        if(emailService.eliminarEmail(id)){
            return ResponseEntity.ok("Email con el id " + id + " ELIMINADO");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún email con el id " + id);
        }

    }

}
