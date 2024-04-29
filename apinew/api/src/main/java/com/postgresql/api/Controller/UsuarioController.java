package com.postgresql.api.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.postgresql.api.Model.Usuario;
import com.postgresql.api.Repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// METODO POST: é utilizado para enviar dados para um servidor web
@RestController
public class UsuarioController {

    // injeta essa instancia para conseguir se comunicar com o banco de dados 
    @Autowired
    UsuarioRepository repository;

    //  mapeia a solicitação HTTP POST recebida para o URL /addUsuario
    @PostMapping("/addUsuario")
    // o RequestBody converte o JSON ou outro formato de dados no corpo da requisição em uma instância da classe Java que você especificar.
    public void addUsuario(@RequestBody Usuario usuario) {

        repository.save(usuario);
     
        
    }
    
}
