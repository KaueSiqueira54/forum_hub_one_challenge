package forum.hub_one.domain.topico;

import java.time.LocalDateTime;

public record DadosListarTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao) {
    public DadosListarTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }

}
