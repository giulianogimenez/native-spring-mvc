package br.gov.sp.fatec.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component("pessoa")
@Entity
@Table(name="pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
	private String nome;

	@OneToMany(mappedBy = "pessoa", targetEntity = Veiculo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

	public String getApresentacao() {
		return "Olá, meu nome é " + this.nome + ". Prazer.";
	}

    public void addVeiculo(Veiculo carro) {
	    if(this.veiculos == null) {
	        this.veiculos = new ArrayList<Veiculo>();
        }
        this.veiculos.add(carro);
    }
}
