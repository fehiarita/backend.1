package com.postgresql.api.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.api.Model.Postagem;
import com.postgresql.api.Repository.PostagemRepository;
import com.postgresql.api.Repository.PostagemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PostagemController {

    @Autowired
    PostagemRepository repository;

    @PostMapping("/criarpostagem")
    public ResponseEntity<Postagem> criarPostagem(@RequestBody Postagem postagem) throws IOException {

        if (postagem.getImagemBase64() != null) {
            String imagemBase64a = Base64.getEncoder().encodeToString(postagem.getImagemBase64().getBytes());
            postagem.setImagemBase64(imagemBase64a);
        }else{
            return ResponseEntity.badRequest().build();
        }

        if (postagem.getConteudo() == null || postagem.getConteudo().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        postagem.setDataHoraPostagem(LocalDateTime.now());

        Postagem postagemSalva = repository.save(postagem);
        return ResponseEntity.ok(postagemSalva);
    }
    

    
}
