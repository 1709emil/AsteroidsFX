package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IActor;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class EnemyControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
            
        for (Entity enemy : world.getEntities(Enemy.class)) {
            Entity player = null;

            for (Entity entity : world.getEntities()) {
                if (entity instanceof IActor && entity != enemy) {
                    player = entity;
                    MoveEnemy(enemy, player);
                }
            }
            if( 3 < ( ( System.nanoTime() - gameData.getDeltaTime() ) / 1000000 )) {
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createBullet(enemy, gameData));}
                );
            }

        if (enemy.getX() < 0) {
            enemy.setX(1);
        }

        if (enemy.getX() > gameData.getDisplayWidth()) {
            enemy.setX(gameData.getDisplayWidth()-1);
        }

        if (enemy.getY() < 0) {
            enemy.setY(1);
        }

        if (enemy.getY() > gameData.getDisplayHeight()) {
            enemy.setY(gameData.getDisplayHeight()-1);
        }

        }
    }

   public void MoveEnemy(Entity enemy, Entity player) {
        if (enemy == null || player == null) {
            return;
        }
        double x = player.getX() - enemy.getX();
        double y = player.getY() - enemy.getY();
        float distance = (float) Math.sqrt(x * x + y * y);
        x = x / distance;
        y = y / distance;
        enemy.setX(enemy.getX() + x);
        enemy.setY(enemy.getY() + y);
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
