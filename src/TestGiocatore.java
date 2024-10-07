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
                    System.out.print("Inserisci il nome del giocatore: ");
                    String nome = input.next();
                    System.out.print("Il giocatore è capitano? (true/false): ");
                    Boolean capitano = input.nextBoolean();
                    capitano = slotCapitano(capitano);
                    System.out.print("Inserisci il numero di goal segnati: ");
                    int goals = input.nextInt();
                    inserisciGiocatore(nome, capitano, goals);
                    break;
                case 1:
                    System.out.println(mostraSquadra());
                    break;
                case 2:
                    System.out.print("Inserisci il numero del giocatore da modificare: ");
                    int num = input.nextInt();
                    System.out.print("Inserisci il nuovo nome del giocatore: ");
                    String nome2 = input.next();
                    System.out.print("Il giocatore è capitano? (true/false): ");
                    Boolean capitano2 = input.nextBoolean();
                    capitano2 = slotCapitano(capitano2);
                    System.out.print("Inserisci il numero di goal segnati: ");
                    int goals2 = input.nextInt();
                    modificaGiocatore(num, nome2, capitano2, goals2);
                    break;
                case 3:
                    System.out.print("Inserisci il numero del giocatore da rimuovere: ");
                    int num2 = input.nextInt();
                    rimuoviGiocatore(num2);
                    break;
                case 4:
                    System.out.println(visualizzaCinqueGoals());
                    break;
                case 5:
                    System.out.println(visualizzaCapitano());
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

    public static void inserisciGiocatore(String nome, Boolean capitano, int goals) {

        squadra = Arrays.copyOf(squadra, squadra.length+1);
        squadra[squadra.length-1] = new Giocatore(nome, capitano, goals);
    }

    public static String mostraSquadra() {
        String output = "";
        for (Giocatore giocatore : squadra) {
            output += "Nome: " + giocatore.getNome() + "\n" + "Capitano: " + giocatore.getCapitano() + "\n" + "Goal segnati: " + giocatore.getGoals() + "\n";
        }
        return output;
    }
    public static void modificaGiocatore(int n, String nome, Boolean capitano, int goals) {
        squadra[n].setNome(nome);
        squadra[n].setCapitano(capitano);
        squadra[n].setGoals(goals);
    }
    public static void rimuoviGiocatore(int n) {
        if (squadra[n].getCapitano().equals("Capitano")) {
            slotCapitanoLibero = true;
        }
        squadra[n] = squadra[squadra.length-1];
        squadra = Arrays.copyOf(squadra, squadra.length-1);

    }
    public static String visualizzaCinqueGoals() {
        String output = "";
        for (Giocatore giocatore : squadra) {
            if (giocatore.getGoals() >= 5) {
                output += "Nome: " + giocatore.getNome() + "\n" + "Capitano: " + giocatore.getCapitano() + "\n" + "Goal segnati: " + giocatore.getGoals() + "\n";
            }
        }
        return output;
    }
    public static String visualizzaCapitano() {
        if (slotCapitanoLibero) {
            return "Non c'è un capitano";
        } else {
            for (Giocatore giocatore : squadra) {
                if (giocatore.getCapitano().equals("Capitano")) {
                    return giocatore.getNome() + " è il capitano";
                }
            }
        }
        return "";
    }
    public static void  assegnaCapitanoCasualmente() {
        if (slotCapitanoLibero) {
            int random = (int) (Math.random() * squadra.length-1);
            squadra[random].setCapitano(slotCapitano(true));
            slotCapitanoLibero = false;
        }
    }

}
