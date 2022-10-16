package br.com.alura.rh.model;

public class Terceirizado {

    private DadosPesssoais dadosPessoais;
    private String empresa;

    public Terceirizado(DadosPesssoais dadosPesssoais) {
        this.dadosPessoais = dadosPesssoais;
    }

    public DadosPesssoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPesssoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
