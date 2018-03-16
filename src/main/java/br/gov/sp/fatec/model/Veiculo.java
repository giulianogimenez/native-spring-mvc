package br.gov.sp.fatec.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
@Data
public class Veiculo {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String marca;

	@Column
	private String modelo;

	@Column(unique = true)
	private String placa;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

}
