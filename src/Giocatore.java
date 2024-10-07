public class Giocatore {
    private String nome;
    private Boolean capitano;
    private int goals;
    public Giocatore (String nome, Boolean capitano, int goals) {
        this.nome = nome;
        this.capitano = capitano;
        this.goals = goals;
    }
    public String getNome() {
        return nome;
    }
    public String getCapitano() {
        if (capitano) {
            return "Capitano";
        } else {
            return "Non capitano";
        }
    }
    public int getGoals() {
        return goals;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCapitano(Boolean capitano) {
        this.capitano = capitano;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }
}
