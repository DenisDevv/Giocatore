import java.util.Scanner;

public class TestGiocatore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci il numero dei giocatori nella squadra: ");
        int n = input.nextInt();
        Giocatore[] squadra = new Giocatore[n];
        // Ciclo per inizializzare tutti gli oggetti Giocatore
        for (int i = 0; i < n; i++) {
            System.out.print("Inserisci il nome del giocatore: ");
            String nome = input.next();
            System.out.print("Il giocatore è capitano? (true/false): ");
            Boolean capitano = input.nextBoolean();
            System.out.print("Inserisci il numero di goal segnati: ");
            int goals = input.nextInt();
            squadra[i] = new Giocatore(nome, capitano, goals);
        }
        // Istruzioni varie per usufruire dei diversi metodi set
        int random = (int) (Math.random() * n-1);
        squadra[random].setNome("Mario");
        random = (int) (Math.random() * n-1);
        squadra[random].setCapitano(true);
        random = (int) (Math.random() * n-1);
        squadra[random].setGoals(squadra[random].getGoals() + (int) (Math.random() * 10));

        // Ciclo per stampare i dati di tutti gli oggetti Giocatore
        for (int i = 0; i < n; i++) {
            System.out.println("Nome: " + squadra[i].getNome());
            System.out.println("Capitano: " + squadra[i].getCapitano());
            System.out.println("Goal segnati: " + squadra[i].getGoals());
        }
    }
}
