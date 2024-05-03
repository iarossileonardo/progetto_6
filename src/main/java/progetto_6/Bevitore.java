package progetto_6;

public class Bevitore extends Thread{

    String nome;
    Botte b;

    public Bevitore(String nome, Botte b){
        this.nome = nome;
        this.b = b;
    }

    public String getNome() {
        return nome;
    }

    
}
