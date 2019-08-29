package br.com.fandrade.cursomc.services;

import br.com.fandrade.cursomc.domain.Pedido;
import br.com.fandrade.cursomc.repositories.PedidoRepository;
import br.com.fandrade.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado! id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
