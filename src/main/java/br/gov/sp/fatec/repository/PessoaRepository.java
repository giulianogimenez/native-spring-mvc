package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByVeiculosPlaca(String placa);

    @Query("select p from Pessoa p inner join Veiculo v on p.id = v.pessoa.id where v.marca like %?1% and v.modelo like %?2%")
    Pessoa findByVeiculosMarcaAndModelo(String marca, String modelo);
}
