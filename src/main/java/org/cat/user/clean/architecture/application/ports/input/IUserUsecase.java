package org.cat.user.clean.architecture.application.ports.input;

import org.cat.user.clean.architecture.domain.model.User;

//El usecase sirve como orquestador , la logica de negocio va en el paquete service , cualquier cosa que sean paso a aseguir en usecases
public interface IUserUsecase {
 User create (User user);
}

