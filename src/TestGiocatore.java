import java.util.Arrays;
import java.util.Scanner;

public class TestGiocatore {
    static Boolean slotCapitanoLibero = true;
    static Scanner input = new Scanner(System.in);
    static Giocatore[] squadra;
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
        // Menu
        while (true) {
            System.out.println("0. Inserisci giocatore");
            System.out.println("1. Mostra squadra");
            System.out.println("2. Modifica giocatore");
            System.out.println("3. Rimuovi giocatore");
            System.out.println("4. Visualizza giocatori con almeno 5 goal");
            System.out.println("5. Visualizza capitano");
            System.out.println("6. Assegna capitano casualmente");
            System.out.println("7. Esci");
            System.out.print("Scelta: ");
            int scelta = input.nextInt();
            switch (scelta) {
                case 0:
                    inserisciGiocatore();
                    break;
                case 1:
                    mostraSquadra();
                    break;
                case 2:
                    System.out.print("Inserisci il numero del giocatore da modificare: ");
                    int num = input.nextInt();
                    modificaGiocatore(num);
                    break;
                case 3:
                    System.out.print("Inserisci il numero del giocatore da rimuovere: ");
                    int num2 = input.nextInt();
                    rimuoviGiocatore(num2);
                    break;
                case 4:
                    visualizzaCinqueGoals();
                    break;
                case 5:
                    visualizzaCapitano();
                    break;
                case 6:
                    assegnaCapitanoCasualmente();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
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

    public static void inserisciGiocatore() {
        System.out.print("Inserisci il nome del giocatore: ");
        String nome = input.next();
        System.out.print("Il giocatore è capitano? (true/false): ");
        Boolean capitano = input.nextBoolean();
        capitano = slotCapitano(capitano);
        System.out.print("Inserisci il numero di goal segnati: ");
        int goals = input.nextInt();
        squadra = Arrays.copyOf(squadra, squadra.length+1);
        squadra[squadra.length-1] = new Giocatore(nome, capitano, goals);
    }

    public static void mostraSquadra() {
        for (Giocatore giocatore : squadra) {
            System.out.println("Nome: " + giocatore.getNome());
            System.out.println("Capitano: " + giocatore.getCapitano());
            System.out.println("Goal segnati: " + giocatore.getGoals());
        }
    }
    public static void modificaGiocatore( int n) {
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
    public static void rimuoviGiocatore( int n) {
        if (squadra[n].getCapitano().equals("Capitano")) {
            slotCapitanoLibero = true;
        }
        squadra[n] = squadra[squadra.length-1];
        squadra = Arrays.copyOf(squadra, squadra.length-1);

    }
    public static void visualizzaCinqueGoals() {
        for (Giocatore giocatore : squadra) {
            if (giocatore.getGoals() >= 5) {
                System.out.println("Nome: " + giocatore.getNome());
                System.out.println("Capitano: " + giocatore.getCapitano());
                System.out.println("Goal segnati: " + giocatore.getGoals());
            }
        }
    }
    public static void visualizzaCapitano() {
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
    public static void  assegnaCapitanoCasualmente() {
        if (slotCapitanoLibero) {
            int random = (int) (Math.random() * squadra.length-1);
            squadra[random].setCapitano(slotCapitano(true));
            slotCapitanoLibero = false;
        }
    }

}
