package com.postgresql.api.Model;


import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.maven.surefire.shared.io.IOExceptionList;
import org.springframework.data.rest.core.Path;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_postagem;

    @Column(nullable = false)
    private String conteudo;

    @Column(nullable = true)
    private String imagem;

    @OneToMany
    @Column(nullable = false)
    private Usuario id_usuario;

    @Column(nullable = false)
    private LocalDateTime dataHoraPostagem;
    // @ManyToOne
    // @Column(nullable = false)
    // private Curtida id_curtida;

    public void salvarImagem(MultipartFile imagem) throws IOException{
        // definindo a pasta onde as imagens vão ser salvas 
        String uploadPasta = "imguploads/";

        String nomeArquivo = UUID.randomUUID().toString() + "_" + imagem.getOriginalFilename();

        // criando o caminho do arquivo
        java.nio.file.Path caminhoArquivo = Paths.get(uploadPasta + nomeArquivo);
        
        // ver se o diretorio existe 
        Files.createDirectories(caminhoArquivo.getParent());
    }
}
