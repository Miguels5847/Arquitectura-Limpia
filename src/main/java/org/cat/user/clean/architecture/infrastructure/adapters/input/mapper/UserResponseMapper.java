package org.cat.user.clean.architecture.infrastructure.adapters.input.mapper;

import org.cat.user.clean.architecture.domain.model.User;
import org.cat.user.clean.architecture.infrastructure.adapters.input.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseMapper {
    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);
    UserResponse toUserResponse (User user);
}
