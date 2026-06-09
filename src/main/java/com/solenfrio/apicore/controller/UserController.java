package com.solenfrio.apicore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solenfrio.apicore.dto.UserDTO;
import com.solenfrio.apicore.model.User;
import com.solenfrio.apicore.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;




@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Endpoints para gerenciamento de usuários")
public class UserController {
    
    @Autowired
    private UserService userService;

    // @GetMapping("{id}")
     // public User get(@PathVariable Long id) {

            //     return userService.findById(id);
            // }
    
    @GetMapping("{id}")
    public User get(@PathVariable Long id) {

        return userService.findById(id);

        // var user = userService.findById(id);

        // return user.isPresent()
        //     ? ResponseEntity.ok(user.get()) : ResponseEntity.notFound().build();
}      

    // @GetMapping()
    // public List<User> getAll() {
    //     return userService.getAll();
    // }
    @Operation(summary = "Obter todos os usuários", description = "Retorna todos os usuários")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuários encontrados"),
        @ApiResponse(responseCode = "500", description = "Nenhum usuário encontrado")
    })        
    @GetMapping(value = {"","/"})
    public ResponseEntity<Object> getAll() {
       
        return ResponseEntity.status(200).body(userService.getAll());
    }

    // @GetMapping("name/{name}")
    // public Page<User> getByName(@PathVariable String name, Pageable pageable) {
    //     return userService.getByName(name, pageable);
    // }

    @GetMapping("name/{name}")
    public ResponseEntity<Object> getByName(@PathVariable String name, Pageable pageable) {
        return ResponseEntity.status(206).body(userService.getByName(name, pageable));
    }

    @PostMapping
    public User create(@RequestBody @Valid UserDTO dto) {
        System.out.println("Criando usuario:" + dto);
        
        return userService.create(dto);
    }
    
    // @PutMapping("{id}")
    // public String update(@PathVariable String id, @RequestBody String entity) {
    //     System.out.println("Atualizando usuario " + entity);
        
    //     return entity;
    // }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid UserDTO dto) {
        
        System.out.println("Atualizando usuario " + dto);
        
        return ResponseEntity.ok(userService.update(id, dto));

        
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("Deletando usuario " + id);
        userService.delete(id);
    }
}
