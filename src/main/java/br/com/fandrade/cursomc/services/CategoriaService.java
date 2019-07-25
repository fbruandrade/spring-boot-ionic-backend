package br.com.fandrade.cursomc.services;

import br.com.fandrade.cursomc.domain.Categoria;
import br.com.fandrade.cursomc.repositories.CategoriaRepository;
import br.com.fandrade.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
//        return obj.orElse(null);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
