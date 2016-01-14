package blog.fpu.example.repository;

import org.springframework.data.repository.CrudRepository;

import blog.fpu.example.entity.Filme;

public interface FilmeRepository extends CrudRepository<Filme, Long> {

}
