package br.com.giovanneestudocontmatic.estudocontmatic.services;

import br.com.giovanneestudocontmatic.estudocontmatic.domain.Categoria;
import br.com.giovanneestudocontmatic.estudocontmatic.repositories.CategoriaRepository;
import br.com.giovanneestudocontmatic.estudocontmatic.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> find(){
        return categoriaRepository.findAll();
    }

    public Categoria findOne(Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Id: " + id +" not found!"));
    }

    public Categoria create(Categoria categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

}
