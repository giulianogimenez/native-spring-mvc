package br.gov.sp.fatec.services;

import br.gov.sp.fatec.model.Veiculo;
import br.gov.sp.fatec.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository repository;

    public ArrayList<Veiculo> buscaPorPessoaNome(String nome) {
        return repository.findByPessoaNome(nome);
    }

    public Veiculo buscaPorPlaca(String placa) {
        return repository.findByPlaca(placa);
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        if (!this.existeVeiculo(veiculo)) {
            repository.saveAndFlush(veiculo);
        }
    }

    public boolean existeVeiculo(Veiculo veiculo) {
        if (repository.findByPlaca(veiculo.getPlaca()) != null) {
            return true;
        } else {
            return false;
        }
    }
}
