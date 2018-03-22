package br.gov.sp.fatec;

import br.gov.sp.fatec.model.Pessoa;
import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.services.PessoaService;
import br.gov.sp.fatec.services.VeiculoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PessoaService pessoaService = context.getBean(PessoaService.class);
        VeiculoService veiculoService = context.getBean(VeiculoService.class);

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Enzo");
        pessoaService.cadastrarPessoa(pessoa);

        Veiculo carro1 = new Veiculo();
        carro1.setMarca("Audi");
        carro1.setModelo("A4");
        carro1.setPlaca("EWT-6764");
        carro1.setPessoa(pessoa);
        veiculoService.cadastrarVeiculo(carro1);

        Veiculo carro2 = new Veiculo();
        carro2.setMarca("Tesla");
        carro2.setModelo("Modelo S");
        carro2.setPlaca("GAY-6969");
        carro2.setPessoa(pessoa);
        veiculoService.cadastrarVeiculo(carro2);

        System.out.println("Busca por nome = " + pessoaService.buscarPessoaPorNome("Enzo").getApresentacao());
        System.out.println("\n\n");
        System.out.println("Busca por placa de veiculo = " + pessoaService.buscarPorVeiculoPlaca("GAY-6969").getApresentacao());
        System.out.println("\n\n");
        System.out.println("Busca por marca e modelo = " + pessoaService.buscarPorVeiculoMarcaEModelo("Audi", "A4").getApresentacao());

        System.out.println("Busca por nome de pessoa =");
        for (Veiculo v : veiculoService.buscaPorPessoaNome("Enzo")) {
            System.out.println(v.getModelo() + " " + v.getMarca() + " " + v.getPlaca());
        System.out.println("\n\n");
        }

        Veiculo v = veiculoService.buscaPorPlaca("EWT-6764");
        System.out.println("Busca por placa = " + v.getModelo() + " " + v.getMarca() + " " + v.getPlaca());
	}
}
