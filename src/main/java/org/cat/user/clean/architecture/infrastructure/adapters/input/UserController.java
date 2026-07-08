package org.cat.user.clean.architecture.infrastructure.adapters.input;

import org.cat.user.clean.architecture.application.ports.input.IUserUsecase;
import org.cat.user.clean.architecture.domain.model.User;
import org.cat.user.clean.architecture.infrastructure.adapters.input.dto.UserRequest;
import org.cat.user.clean.architecture.infrastructure.adapters.input.dto.UserResponse;
import org.cat.user.clean.architecture.infrastructure.adapters.input.mapper.UserRequestMapper;
import org.cat.user.clean.architecture.infrastructure.adapters.input.mapper.UserResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//El controlador se crea en el paquete de infraestructura en la seccion de adaptadores en el paqute de entrada/input por que un endpoit es algo que tu expones al cliente pero es interno de tu proyecto , y por que la base de datos tiene que estar en output es algo que esta alejado de mi proyecto , si elimino el proyecto la bd no pasa nada
@RestController
@RequestMapping("/v1/users")
//El request mapping
//El contest path es el contexto general de la api , en una url se tiene :
// https://localhost:8080/api/b1/v1/uses
//                       /contest path/dominio especifico para cada dominio
public class UserController {
    //Aqui no llamo al servicio , se llama al usecase
    private final IUserUsecase userUsecase;

    public UserController(IUserUsecase userUsecase) {
        this.userUsecase = userUsecase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create (@RequestBody UserRequest request){
        User user = userUsecase.create(
                UserRequestMapper.INSTANCE.toUser(request)
        );
        return new ResponseEntity<>(
                UserResponseMapper.INSTANCE.toUserResponse(user),
                HttpStatus.CREATED
        );
    }
}
