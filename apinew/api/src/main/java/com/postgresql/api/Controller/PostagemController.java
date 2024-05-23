package com.postgresql.api.Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.maven.surefire.api.stream.AbstractStreamDecoder.MalformedFrameException;
import org.apache.maven.surefire.shared.io.IOExceptionList;
import org.hibernate.boot.jaxb.internal.InputStreamAccessXmlSource;
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
    public ResponseEntity<Postagem> criarPostagem( @RequestParam(required = false) MultipartFile imagem, @RequestBody Postagem postagem) throws IOException {

        // validar conteudo da postagem
        if (postagem.getConteudo() == null || postagem.getConteudo().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        if (imagem != null && !imagem.isEmpty()) {
            String imagem = 
        }

        Postagem postagemSalva = repository.save(postagem);
        return ResponseEntity.ok(postagemSalva);
    }
    

    
}
