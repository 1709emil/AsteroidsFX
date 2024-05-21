package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Precondition: GameData and World objects are initialized.
 * Postcondition: start: Initializes and adds entities and components to the World.
 *                stop: Cleans up and removes entities and components from the World.

 */
public interface IGamePluginService {

    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
