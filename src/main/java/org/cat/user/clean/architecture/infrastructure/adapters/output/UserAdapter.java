package org.cat.user.clean.architecture.infrastructure.adapters.output;

import org.cat.user.clean.architecture.application.ports.output.UserPort;
import org.cat.user.clean.architecture.domain.model.User;
import org.cat.user.clean.architecture.infrastructure.adapters.output.mapper.UserEntityMapper;
import org.springframework.stereotype.Component;
//Por que no se pone @service , ni @repository , por que en springboot no hay anatoaciones para arquitectura limpia , el framework es independeiente de la arquitectura
@Component

public class UserAdapter implements UserPort {

    private final UserEntityRepository repository;
    //Esto es inyeccion por constructor
    public UserAdapter(UserEntityRepository repository) {
        this.repository = repository;
    }

    //Aqui hacemos la inyeccion de dependencias
    //Hay inyeccion < Es cuadno se hace el proceso de instanciar a travez de un framework
    //Inversion es instanciar a traves del lenguaje
    //En este caso vamos a hacer inyeccion
    //1 forma usando autowired el cual /*no es recomendable
    //La otra es usando el @RequiredactsConstructor
    //La otra opcion es generando un constructor
    @Override
    public User create(User user) {
        UserEntity userEntity = repository.save(
                UserEntityMapper.INSTANCE.toUserEntity(user)
        );
        return UserEntityMapper.INSTANCE.toUser(userEntity);
    }
}
