package com.solenfrio.apicore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.solenfrio.apicore.dto.UserDTO;
import com.solenfrio.apicore.exception.NotFoundExeption;
import com.solenfrio.apicore.model.User;
import com.solenfrio.apicore.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(UserDTO dto) {
        User user = new User(); // Iniciando uma entidade JPA

        // COpia as propriedades do DTO para a entidade
        BeanUtils.copyProperties(dto, user);

        // persistir a entidade JPA
        return userRepository.save(user);

    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
        .orElseThrow(() -> new NotFoundExeption("Usuario não encontrado"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Page<User> getByName(String name, Pageable pageable) {
        return userRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public User update(Long id, UserDTO dto) {
        var entity = findById(id); // Retorna um optional de user

        // if (user.isPresent()) {
        //     var entity = user.get(); // Pega a entidade do optional objeto salvo

            // copia as propriedades do DTO para a entidade, ignorando o id e a senha
        BeanUtils.copyProperties(dto, entity, "id, password");

        return userRepository.save(entity); // Salva a entidade atualizada no banco de dados
        // }

        // throw new NotFoundExeption("Usuario não encontrado"); // Lança uma exceção se o usuário não for encontrado
    }

}
