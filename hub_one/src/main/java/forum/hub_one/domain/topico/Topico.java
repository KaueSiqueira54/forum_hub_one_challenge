package forum.hub_one.domain.topico;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String titulo;

    @Column(nullable = false, unique = true, length = 255)
    private String mensagem;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false, length = 100)
    private String autor;

    @Column(nullable = false, length = 100)
    private String curso;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTopico status;

    private boolean ativo;

    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.status = StatusTopico.NÃO_RESPONDIDO;
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        if(dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if(dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if(dados.autor() != null) {
            this.autor = dados.autor();
        }
        if(dados.curso() != null) {
            this.curso = dados.curso();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getAutor() {
        return autor;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public String getCurso() {
        return curso;
    }
}
