package com.postgresql.api.Controller;

import java.io.IOException;
// import java.net.MalformedURLException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
import java.time.LocalDateTime;
// import java.util.Base64;
// import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.postgresql.api.Model.Postagem;
import com.postgresql.api.Repository.PostagemRepository;

import lombok.Data;

// import com.postgresql.api.Repository.PostagemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@RestController
public class PostagemController {

    @Autowired
    PostagemRepository repository;


    @PostMapping("/criarpostagem")
    public ResponseEntity<Postagem> criarPostagem(@RequestParam("conteudo") String conteudo ,@RequestParam("imagem") MultipartFile imagem, @RequestBody Postagem postagem) throws IOException {

        // validar conteudo da postagem
        if (postagem.getConteudo() == null || postagem.getConteudo().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        postagem.setDataHoraPostagem(LocalDateTime.now());

        // captura e define a imagem 
        if (imagem != null && !imagem.isEmpty()) {
            postagem.setImagem(imagem.getBytes());
        }

        // salva a postagem no banco de dados 
        Postagem postagemSalva = repository.save(postagem);

        return ResponseEntity.ok(postagemSalva);
    }
    

    
}
