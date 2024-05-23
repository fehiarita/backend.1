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
    public ResponseEntity<Postagem> criarPostagem( @RequestParam MultipartFile imagem, @RequestBody Postagem postagem) throws IOException {

        byte[] imagemCompactada = null;
        if (imagem != null) {
            imagemCompactada = 
        }
        // private boolean uploadImagemLocal(String imagemUrl) throws IOException{
        //     // validar a imagem
        //     try{
        //         new URL(imagemUrl).openStream();
        //     }catch (IOException | MalformedURLException e){
        //         System.err.println("Erro ao validar URL da imagem: " + e.getMessage());
        //         return false;
        //     }

        //     // baixar a imagem 
        //     try(InputStream inputStream = new URL(imagemUrl).openStream()){
        //         byte[] imagemBytes = IOUtils.toByteArray(inputStream);

        //         String nomeArquivo = UUID.randomUUID().toString() + "jpg";

        //         Path diretorioDestino = Paths.get("C:\Users\pc\Documents\imagemAPI/");
        //         Files.createDirectories(diretorioDestino);

        //         Files.write(diretorioDestino.resolve(nomeArquivo), imagemBytes);

        //         imagemUrl = "/" + diretorioDestino.relativize(Paths,get(diretorioDestino.toString(),nomeArquivo)).toString();
        //         System.out.println("Imagem '" + nomeArquivo + "' salva com sucesso!");
        //         } catch (Exception e) {
        //         // TODO: handle exception
        //     }
        // }

        // boolean imagemSalvaComSucesso = uploadImagemLocal(postagem.getImagemUrl());
        // if (imagemSalvaComSucesso) {
        //     postagem.setImagemUrl(imagemUrl);
        //     postagemRepository.save(postagem);
        //     return ResponseEntity.ok().build();
        // } else {
        //     return ResponseEntity.badRequest().build();
        // }
        

        if (postagem.getConteudo() == null || postagem.getConteudo().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        postagem.setDataHoraPostagem(LocalDateTime.now());

        Postagem postagemSalva = repository.save(postagem);
        return ResponseEntity.ok(postagemSalva);
    }
    

    
}
