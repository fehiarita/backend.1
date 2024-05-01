package com.postgresql.api.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.postgresql.api.Model.Usuario;
import com.postgresql.api.Repository.UsuarioRepository;

import java.net.URI;

// import org.hibernate.query.sqm.StrictJpaComplianceViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import org.springframework.web.bind.annotation.PathVariable;


// METODO POST: é utilizado para enviar dados para um servidor web
@RestController
public class UsuarioController {

    // injeta essa instancia para conseguir se comunicar com o banco de dados 
    @Autowired
    UsuarioRepository repository;

    //  mapeia a solicitação HTTP POST recebida para o URL /addUsuario
    @PostMapping("/cadastrarUsuario")
    // o RequestBody converte o JSON ou outro formato de dados no corpo da requisição em uma instância da classe Java que você especificar.
    // ResponseEntity é uma classe em spring framework que representa uma resposta HTTP 
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            // cria e retorna o status 400 bad request
            return ResponseEntity.badRequest().build();
        }
        
        if (usuario.getUsername() == null || usuario.getUsername().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // verificações adicionais para garantir que o username e o email fornecidos sejam únicos
        if (repository.existsByUsername(usuario.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        if (repository.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().build();
        }

        // criptografia de senha
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        // status 201
        Usuario usuarioSalvo = repository.save(usuario);
        // url cadastrarUsuario/usuario/{id}
        return ResponseEntity.created(URI.create("/usuario/" + usuarioSalvo.getId())).body(usuarioSalvo);
    }


    
    
    
}
