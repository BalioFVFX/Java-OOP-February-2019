package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;
import static rpg_tests.Constants.*;

public class DummyTests {
    Dummy dummy;
    Dummy deadDummy;

    @Before
    public void createObjects(){
        this.dummy = new Dummy(DUMMY_HP, Constants.XP, null);
        this.deadDummy = new Dummy(0, Constants.XP, null);
    }

    @Test
    public void loseHealthWhenAttacked(){
        int actual = dummy.getHealth();

        dummy.takeAttack(Constants.ATTACK_POINTS);

        assertEquals(DUMMY_HP - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowWhenDeadAttacked(){
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void shouldGiveXPWhenDead(){
        assertEquals(XP, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowWhenGiveXpAlive(){
        dummy.giveExperience();
    }

}
