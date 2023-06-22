package com.desaextremo.retouno.business;

import com.desaextremo.retouno.model.User;
import com.desaextremo.retouno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll(){
        return repository.findAll();
    }

    public boolean existEmail(String email){
        Optional<User> optional = repository.findByEmail(email);

        return optional.isPresent();
    }

    public User autenticateUser(String email, String password){
        Optional<User> optional = repository.findByEmailAndPassword(email,password);

        //encontro información coincidente en bd
        if (optional.isPresent()){
            return optional.get();
        }else{
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setName("NO DEFINIDO");

            return user;
        }
    }

    public User createUser(User user){
        //validar si el correo electronico recibido existe
        Optional<User> optional = repository.findByEmail(user.getEmail());

        //existe un usuario con ese correo electronico
        if(optional.isPresent()){
            return user;
        //si no existe, entonces lo ingresa a la base de datos
        }else{
            return repository.save(user);
        }
    }
}
