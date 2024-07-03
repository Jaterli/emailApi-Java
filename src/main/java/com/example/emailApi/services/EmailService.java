package com.example.emailApi.services;

import com.example.emailApi.models.Email;
import com.example.emailApi.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    public Iterable<Email> getAllEmails(){
        return repository.findAll();
    }

    public Optional<Email> getEmailById(Long id){
        return repository.findById(id);
    }


    public void addEmail(Email email) {
        repository.save(email);
    }

    public void actualizarEmail(long id, Email nuevoEmail){
        getEmailById(id).ifPresent(email -> {
            email.setRemitente(nuevoEmail.getRemitente());
            email.setDestinatario(nuevoEmail.getDestinatario());
            email.setAsunto(nuevoEmail.getAsunto());
            email.setCuerpo(nuevoEmail.getCuerpo());
            email.setFecha(nuevoEmail.getFecha());
            addEmail(email);
        });
    }

    public boolean eliminarEmail(long id) {
        Optional<Email> emailAEliminar = getEmailById(id);

        if (emailAEliminar.isPresent()) {
            repository.delete(emailAEliminar.get());
            return true;
        } else {
            return false;
        }
    }
}