package com.postgresql.api.Model;


// import java.io.IOException;
// import java.nio.file.Paths;
import java.time.LocalDateTime;
// import java.util.UUID;
import java.util.List;

// import org.apache.maven.surefire.shared.io.IOExceptionList;
// import org.springframework.data.rest.core.Path;
// import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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

    @Lob
    private byte[] imagem;
    
    @Column(nullable = false)
    private LocalDateTime dataHoraPostagem;
    
    @OneToMany
    @Column(nullable = false)
    private List<Usuario> id_usuario;

    // @ManyToOne
    // @Column(nullable = false)
    // private Curtida id_curtida;
}
