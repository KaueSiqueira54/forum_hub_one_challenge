package forum.hub_one.controller;

import forum.hub_one.domain.topico.*;
import org.springframework.data.domain.Pageable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {

        var topico = new Topico(dados);
        topicoRepository.save(topico);

        return ResponseEntity.ok(new DadosCadastroTopico(topico.getTitulo(), topico.getMensagem(), topico.getAutor(), topico.getCurso()));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var topico = topicoRepository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10, sort = {"id"})Pageable paginacao) {
        var page = topicoRepository.findAllByAtivoTrue(paginacao)
                .map(DadosListarTopicos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.excluir();

        return ResponseEntity.noContent().build();
    }

}
