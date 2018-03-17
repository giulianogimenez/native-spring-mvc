package br.gov.sp.fatec.services;

import br.gov.sp.fatec.model.Pessoa;

public interface PessoaService {

    Pessoa buscarPessoaPorNome(String nome);
    Pessoa buscarPorVeiculoPlaca(String placa);
    Pessoa buscarPorVeiculoMarcaEModelo(String marca, String modelo);
    void cadastrarPessoa(Pessoa pessoa);
    boolean existePessoa(Pessoa pessoa);
}
