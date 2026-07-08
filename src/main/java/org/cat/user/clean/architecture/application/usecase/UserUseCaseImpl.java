package org.cat.user.clean.architecture.application.usecase;

import org.cat.user.clean.architecture.application.ports.input.IUserUsecase;
import org.cat.user.clean.architecture.application.ports.output.UserPort;
import org.cat.user.clean.architecture.domain.model.User;
import org.springframework.stereotype.Component;
//Se pone component por que no hay implementacion usecase
@Component
public class UserUseCaseImpl implements IUserUsecase {
    //Aqui digo que voy a usar la interfaz, el user port esta dentro de la capa de aplicacion
    private final UserPort userPort;

    public UserUseCaseImpl(UserPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public User create(User user) {
        return userPort.create(user);
    }
}
