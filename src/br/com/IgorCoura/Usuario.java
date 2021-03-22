package br.com.IgorCoura;

public class Usuario {
    private string nome;
    private string senha;
    private string cpf;
    private string email;

    public Usuario(string nome, string senha, string cpf, string email) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
    }

    public string getNome(){
        return nome;
    }
    public  string getSenha(){
        return senha;
    }
    public string getCpf(){
        return cpf;
    }
    public string getEmail(){
        return email;
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
