public class TestGiocatore {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Luigi", false, 2);
        Giocatore g2 = new Giocatore("Mario", false, 0);
        Giocatore g3 = new Giocatore("Masserini", false, 13);
        System.out.println(g1.getNome() + " " + g1.getCapitano() + " " + g1.getGoals());
        g2.setGoals(g2.getGoals() + (int) (Math.random() * 10));
        System.out.println(g2.getNome() + " " + g2.getCapitano() + " " + g2.getGoals());
        g3.setCapitano(true);
        g3.setNome("Masserini il bomber");
        System.out.println(g3.getNome() + " " + g3.getCapitano() + " " + g3.getGoals());
    }
}
