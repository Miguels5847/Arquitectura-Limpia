package org.cat.user.clean.architecture.domain.service;

import org.cat.user.clean.architecture.domain.model.User;

import java.util.List;

public class UserService {
    //Las logicas de negocio no tienen una implementacion , por que los servicios no salen a el exterior
    //El servicio siempre va a ser unico, solo necesito una clase , no una implenentacion
    //Investigar programacion estructurada
    public static List<User> filterByLastName(List<User> users, String lastName){
        return users.stream()
                .filter(user -> user.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }
}
