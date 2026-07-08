package org.cat.user.clean.architecture.infrastructure.adapters.input.mapper;

import org.cat.user.clean.architecture.domain.model.User;
import org.cat.user.clean.architecture.infrastructure.adapters.input.dto.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRequestMapper {
    UserRequestMapper INSTANCE = Mappers.getMapper(UserRequestMapper.class);
    User toUser(UserRequest userRequest);
}
