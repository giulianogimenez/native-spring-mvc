package br.gov.sp.fatec.services;

import br.gov.sp.fatec.model.Pessoa;
import br.gov.sp.fatec.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa buscarPessoaPorNome(String nome) {
        return repository.findByNomeIgnoreCase(nome);
    }

    public Pessoa buscarPorVeiculoPlaca(String placa) {
        return repository.findByVeiculosPlaca(placa);
    }

    public Pessoa buscarPorVeiculoMarcaEModelo(String marca, String modelo) {
        return repository.findByVeiculosMarcaAndModelo(marca, modelo);
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        if (!this.existePessoa(pessoa)) {
            repository.saveAndFlush(pessoa);
        }
    }

    public boolean existePessoa(Pessoa pessoa) {
        if (repository.findByNomeIgnoreCase(pessoa.getNome()) != null) {
            return true;
        } else {
            return false;
        }
    }


}
