package forum.hub_one.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensagem,
        @NotNull
        String autor,
        @NotNull
        String curso
) {
}
