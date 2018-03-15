package br.gov.sp.fatec;

import br.gov.sp.fatec.model.Pessoa;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.repository.PessoaRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PessoaRepository pessoaRepository = (PessoaRepository) context.getBean("pessoaRepository");

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("José");
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getApresentacao());
		
        Veiculo carro1 = new Veiculo();
        System.out.println(carro1.toString());
        carro1.setModelo("Gol");
        System.out.println(carro1.toString());
        pessoa.addVeiculo(carro1);

        Veiculo carro2 = new Veiculo();
        System.out.println(carro2.toString());
        carro2.setMarca("Tesla");
        System.out.println(carro2.toString());
        pessoa.addVeiculo(carro2);

        pessoaRepository.save(pessoa);
        System.out.println("Pessoa " + pessoa.getId() + " salva com sucesso!");
	}
}
