package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
