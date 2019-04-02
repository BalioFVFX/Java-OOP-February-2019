package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;

public class AxeTests {

    private Axe axe;
    private Dummy dummy;

    @Before
    public void createAxe(){
        this.axe = new Axe(10, 10);
        this.dummy = new Dummy(10, 10, null);
    }

    @Test
    public void shouldLoseDurabilityWhenAttack(){
        int actual = this.axe.getDurabilityPoints();
        this.axe.attack(this.dummy);
        assertEquals("Axe should lose durability", actual - 1, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowWhenAttackWithBrokenWeapon(){
        Axe brokenAxe = new Axe(10, 0);
        brokenAxe.attack(dummy);
    }
}
