package progetto_6;

public class Bevitore extends Thread{

    String nome;
    Botte b;
    boolean running = true;

    public Bevitore(String nome, Botte b){
        this.nome = nome;
        this.b = b;
    }

    

    @Override
    public void run() {
        double attesa = 2000 + Math.random() * 1000;
        try{
            System.out.println(nome + " attende " + attesa);
            this.sleep((long)attesa);
            while (running) {
                int tempoBevuta = b.entra(this);
                System.out.println(nome + " beve per " + (tempoBevuta / 1000));
                this.sleep(tempoBevuta);
                b.esci(this);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void shutdown(){
        running = false;
    }

    public String getNome() {
        return nome;
    }

    
}
