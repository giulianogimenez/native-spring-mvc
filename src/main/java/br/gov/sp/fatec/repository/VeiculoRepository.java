package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    ArrayList<Veiculo> findByPessoaNome(String nome);

    @Query("select v from Veiculo v inner join Pessoa p on p.id = v.pessoa.id where p.id = ?1")
    Veiculo findByPessoaId(Long id);

    Veiculo findByPlaca(String placa);
}
