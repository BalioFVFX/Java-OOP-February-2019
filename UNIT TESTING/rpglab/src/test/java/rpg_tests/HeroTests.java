package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.*;

import static org.junit.Assert.assertEquals;

public class HeroTests {

    @Test
    public void shouldGainXpWhenAttackDeadTarget(){
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Hero hero = new Hero(weaponMock, "Hero name");
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(Constants.XP);
        hero.attack(targetMock);
        assertEquals("Wrong xp", Constants.XP, hero.getExperience());
    }

    @Test
    public void shouldGetLootWhenAttackDeadTarget(){
        Target targetMock = Mockito.mock(Target.class);
        Weapon weaponMock = Mockito.mock(Weapon.class);

        Hero hero = new Hero(weaponMock, "Hero name");

        Mockito.when(targetMock.isDead()).thenReturn(true);

        Weapon resultWeapon = new Weapon() {
            public void attack(Target target) {

            }

            public int getAttackPoints() {
                return 120;
            }

            public int getDurabilityPoints() {
                return 4320;
            }
        };

        Mockito.when(targetMock.giveLoot()).thenReturn(resultWeapon);

        hero.attack(targetMock);
        assertEquals(hero.getInventory().iterator().next(), resultWeapon);

    }
}
