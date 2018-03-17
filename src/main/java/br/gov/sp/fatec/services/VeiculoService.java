package br.gov.sp.fatec.services;

import br.gov.sp.fatec.model.Veiculo;

import java.util.ArrayList;

public interface VeiculoService {

    ArrayList<Veiculo> buscaPorPessoaNome(String nome);
    Veiculo buscaPorPlaca(String placa);
    void cadastrarVeiculo(Veiculo veiculo);
    boolean existeVeiculo(Veiculo veiculo);
}
