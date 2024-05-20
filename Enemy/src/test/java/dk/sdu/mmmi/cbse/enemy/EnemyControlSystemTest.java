package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyControlSystemTest {


    @Test
    void testMoveEnemy() {
        Entity entity = new Entity();
        entity.setX(10);
        entity.setY(10);
        double startingX = entity.getX();
        double startingY = entity.getY();
        Entity player = new Entity();
        player.setX(20);
        player.setY(20);

        EnemyControlSystem ecs = new EnemyControlSystem();
        ecs.MoveEnemy(entity, player);
        assertTrue(entity.getX() != startingX || entity.getY() != startingY);
    }

    @Test
    void testMoveEnemyNull() {
        Entity entity = new Entity();
        entity.setX(10);
        entity.setY(10);
        double startingX = entity.getX();
        double startingY = entity.getY();

        EnemyControlSystem ecs = new EnemyControlSystem();
        ecs.MoveEnemy(entity, null);
        assertEquals(entity.getX(), startingX);
        assertEquals(entity.getY(), startingY);
    }

}