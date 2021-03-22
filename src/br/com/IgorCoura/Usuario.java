package br.com.IgorCoura;

public class Usuario {
    private String nome;
    private String senha;
    private String cpf;
    private String email;

    public Usuario(String nome, String senha, String cpf, String email) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }
    public String getSenha(){
        return senha;
    }
    public String getCpf(){
        return cpf;
    }
    public String getEmail(){
        return email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", e-mail='" + email + '\'' +
                '}';
    }

}
