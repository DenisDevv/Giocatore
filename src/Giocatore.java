public class Giocatore {
    private String nome;
    private Boolean capitano;
    private int goals;
    public Giocatore (String nome, Boolean capitano, int goals) {
        setNome(nome);
        setCapitano(capitano);
        setGoals(goals);
    }
    public Giocatore (String nome, Boolean capitano) {
        setNome(nome);
        setCapitano(capitano);
        setGoals(0);
    }
    public Giocatore (String nome) {
        setNome(nome);
        setCapitano(false);
        setGoals(0);
    }
    public String getNome() {
        return nome;
    }
    public Boolean getCapitano() {
        return capitano;
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
