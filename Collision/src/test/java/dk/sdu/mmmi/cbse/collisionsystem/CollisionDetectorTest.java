package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
public class CollisionDetectorTest {

    @Test
    @DisplayName("Test Two Entities Collide")
    public void TestTwoEntitiesCollide() {
        Entity entity1 = new Entity();
        Entity entity2 = new Entity();
        entity1.setX(0);
        entity1.setY(0);
        entity1.setRadius(1);
        entity2.setX(1);
        entity2.setY(1);
        entity2.setRadius(1);
        CollisionDetector collisionDetector = new CollisionDetector();
        assertTrue(collisionDetector.collides(entity1, entity2));
    }

    @Test
    @DisplayName("Test Two Entities Don't Collide")
    public void TestTwoEntitiesDontCollide() {
        Entity entity1 = new Entity();
        Entity entity2 = new Entity();
        entity1.setX(0);
        entity1.setY(0);
        entity1.setRadius(1);
        entity2.setX(2);
        entity2.setY(2);
        entity2.setRadius(1);
        CollisionDetector collisionDetector = new CollisionDetector();
        assertFalse(collisionDetector.collides(entity1, entity2));
    }

}