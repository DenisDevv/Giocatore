import java.util.Arrays;
import java.util.Scanner;

public class TestGiocatore {
    static Boolean slotCapitanoLibero = true;
    static Scanner input = new Scanner(System.in);
    static Giocatore[]squadra;
    public static void main(String[] args) {
        System.out.print("Inserisci il numero dei giocatori nella squadra: ");
        int n = input.nextInt();
        squadra = new Giocatore[n];
        // Ciclo per inizializzare tutti gli oggetti Giocatore
        for (int i = 0; i < n; i++) {
            System.out.print("Inserisci il nome del giocatore: ");
            String nome = input.next();
            System.out.print("Il giocatore è capitano? (true/false): ");
            Boolean capitano = input.nextBoolean();
            capitano = slotCapitano(capitano);
            System.out.print("Inserisci il numero di goal segnati: ");
            int goals = input.nextInt();
            squadra[i] = new Giocatore(nome, capitano, goals);
        }
        // Istruzioni varie per usufruire dei diversi metodi set
        int random = (int) (Math.random() * n-1);
        squadra[random].setNome("Mario");
        random = (int) (Math.random() * n-1);
        squadra[random].setCapitano(slotCapitano(true));
        random = (int) (Math.random() * n-1);
        squadra[random].setGoals(squadra[random].getGoals() + (int) (Math.random() * 10));
    }
    public static Boolean slotCapitano(Boolean capitano) {
        if (slotCapitanoLibero) {
            if (capitano) {
                slotCapitanoLibero = false;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public static void mostraSquadra(Giocatore[] squadra) {
        for (Giocatore giocatore : squadra) {
            System.out.println("Nome: " + giocatore.getNome());
            System.out.println("Capitano: " + giocatore.getCapitano());
            System.out.println("Goal segnati: " + giocatore.getGoals());
        }
    }
    public static void modificaGiocatore(Giocatore[]squadra, int n) {
        System.out.print("Inserisci il nuovo nome del giocatore: ");
        String nome = input.next();
        System.out.print("Il giocatore è capitano? (true/false): ");
        Boolean capitano = input.nextBoolean();
        capitano = slotCapitano(capitano);
        System.out.print("Inserisci il numero di goal segnati: ");
        int goals = input.nextInt();
        squadra[n].setNome(nome);
        squadra[n].setCapitano(capitano);
        squadra[n].setGoals(goals);
    }
    public static void rimuoviGiocatore(Giocatore[] squadra, int n) {
        squadra[n] = squadra[squadra.length-1];
        Arrays.copyOf(squadra, squadra.length-1);
    }
    public static void visualizzaCinqueGoals(Giocatore[] squadra) {
        for (Giocatore giocatore : squadra) {
            if (giocatore.getGoals() >= 5) {
                System.out.println("Nome: " + giocatore.getNome());
                System.out.println("Capitano: " + giocatore.getCapitano());
                System.out.println("Goal segnati: " + giocatore.getGoals());
            }
        }
    }
    public static void visualizzaCapitano(Giocatore[] squadra) {
        if (slotCapitanoLibero) {
            System.out.println("Non c'è un capitano");
        } else {
            for (Giocatore giocatore : squadra) {
                if (giocatore.getCapitano().equals("Capitano")) {
                    System.out.println("Nome: " + giocatore.getNome());
                    System.out.println("Capitano: " + giocatore.getCapitano());
                    System.out.println("Goal segnati: " + giocatore.getGoals());
                }
            }
        }
    }
    public static void  assegnaCapitanoCasualmente(Giocatore [] squadra) {
        if (!slotCapitanoLibero) {
            int random = (int) (Math.random() * squadra.length-1);
            squadra[random].setCapitano(slotCapitano(true));
        }
    }

}
