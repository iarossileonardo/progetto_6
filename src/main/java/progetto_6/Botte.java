package progetto_6;

public class Botte {

    int postiLiberi = 3;
    int litri = 100;

    public Botte(){
        //VUOTO
    }

    public synchronized int entra(Bevitore b) throws Exception{
        while (postiLiberi < 1) {
            if(litri > 0)
                wait();
            else{
                b.shutdown();
                return 0;
            }
        }
        postiLiberi--;
        int litriBevuti = (int)Math.random() * 20 + 1;
        litri -= litriBevuti;
        System.out.println(b.getNome() + " ha bevuto " + litriBevuti + " litri");
        return (int)Math.random() * 1000 + 2000;
    }

    public synchronized void esci(Bevitore b){
        postiLiberi++;
        notifyAll();
    }
}
