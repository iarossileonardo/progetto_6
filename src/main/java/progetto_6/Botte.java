package progetto_6;

public class Botte {

    int postiLiberi = 3;
    int litri = 100;

    public Botte(){
        //VUOTO
    }

    public synchronized int entra(Bevitore b) throws Exception{
        while (postiLiberi < 1) {
            wait();
        }
        postiLiberi--;
        int litriBevuti = (int)Math.random() * 2 + 1;
        litri -= litriBevuti;
        System.out.println(b.getNome() + " ha bevuto " + litriBevuti + " litri");
        return (int)Math.random() * 1000 + 2000;
    }

    public synchronized void esci(){
        postiLiberi++;
        if (litri > 0) {
            notifyAll();
        }
        //else
            //GESTIRE CHIUSURA THREAD
    }
}
