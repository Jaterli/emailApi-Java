package com.example.emailApi.services;

import com.example.emailApi.models.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    private List<Email> emailList = new ArrayList<>();

    public void addEmail(Email email) {
        emailList.add(email);
    }

    public List<Email> getAllEmails(){
        return emailList;
    }

    public Optional<Email> getEmailById(long id){
        return emailList.stream().filter(email -> email.getId() ==id).findFirst();
    }

    public void actualizarEmail(long id, Email nuevoEmail){
        getEmailById(id).ifPresent(email -> {
            email.setRemitente(nuevoEmail.getRemitente());
            email.setDestinatario(nuevoEmail.getDestinatario());
            email.setAsunto(nuevoEmail.getAsunto());
            email.setCuerpo(nuevoEmail.getCuerpo());
            email.setFecha(nuevoEmail.getFecha());
        });
    }

    public boolean eliminarEmail(long id) {
        Optional<Email> emailAEliminar = getEmailById(id);

        if (emailAEliminar.isPresent()) {
            emailList.remove(emailAEliminar.get());
            return true;
        } else {
            return false;
        }
    }

}