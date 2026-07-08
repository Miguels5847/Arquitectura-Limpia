package org.cat.user.clean.architecture.infrastructure.adapters.output.mapper;

import org.cat.user.clean.architecture.domain.model.User;
import org.cat.user.clean.architecture.infrastructure.adapters.output.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {
    //Funciona de > Una fuente (la clase principal) y el destino (la clase que quiero instanciar)
    //Aqui no usamos nada por que los atributods del origen y del destino tienen los mismos nombres
    //Esto cuando tengo atributos distintos @Mapping(source = "fisrtName", target = "name")
    //Esto es patron singleton
    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);
}
