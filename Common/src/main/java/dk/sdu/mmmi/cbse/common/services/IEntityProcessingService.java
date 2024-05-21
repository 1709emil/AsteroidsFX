package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     *
     *
     * Precondition: GameData and World objects are initialized and contain valid game state information.
     * Postcondition: Entities within the World are updated based on the game logic encapsulated in the process method.
     * @param gameData
     * @param world
     * @throws
     */
    void process(GameData gameData, World world);
}
