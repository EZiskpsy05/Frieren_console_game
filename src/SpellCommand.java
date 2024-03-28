import java.util.HashMap;
import java.util.Map;

public class SpellCommand implements Command {

    private static final Map<String, Spell> SPELLS = new HashMap<>();
    static {
        SPELLS.put("zoltraak", new Zoltraak());
        SPELLS.put("doragate", new Doragate());
        SPELLS.put("catastravia", new Catastravia());
        SPELLS.put("mistilziela", new Mistilziela());
        SPELLS.put("shield", new ExpectoPatronum());
        SPELLS.put("sorganeil", new ExpectoPatronum());
        SPELLS.put("erfassen", new ExpectoPatronum());
        SPELLS.put("sus", new ExpectoPatronum());
        SPELLS.put("photo", new ExpectoPatronum());
    }

    private Location curr;

    public SpellCommand(Location curr) {
        this.curr = curr;
    }

    @Override
    public Location execute(String args) {
        String spellName = args.trim().toLowerCase().split(" ")[0];
        Spell spell = SPELLS.get(spellName);
        if (spell != null) {
            spell.cast();
        }

        if (curr.p.size() > 0) {
            String enemyName = curr.p.size() > 1 ? curr.p.get(1).name : curr.p.get(0).name;
            System.out.println("You defeated " + enemyName);
            curr.isEnemyDefeated = true;
        }

        return curr;
    }

    @Override
    public Boolean isSynonym(String cmd) {
        return SPELLS.containsKey(cmd.toLowerCase());
    }
}
