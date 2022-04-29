package interfaces;

public interface Attacker {
    public int attack();
    public void applyDamageFromAttack(int hp);
    public String attackMessage();
}
