package ch.idsia.agents.controllers;

import ch.idsia.agents.Agent;
import ch.idsia.agents.controllers.tree.MoveRight;
import ch.idsia.agents.controllers.tree.Sequence;
import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.engine.sprites.Sprite;
import ch.idsia.benchmark.tasks.Task;

import java.util.ArrayList;

public class BehaviorTreeAgent extends BasicMarioAIAgent implements Agent {
    public BehaviorTreeAgent(String s) {
        super(s);
        reset();

        ArrayList<Task> task1 = new ArrayList<>();


    }

    public void keyRight() {
        action[Mario.KEY_RIGHT] = true;
    }

    public void keyJump() {
        action[Mario.KEY_JUMP] = isMarioAbleToJump || !isMarioOnGround;
    }

    public void keyShoot() {
        action[Mario.KEY_SPEED] = isMarioAbleToShoot;
    }

    public boolean isMarioAbleToShoot() {
        return isMarioAbleToShoot;
    }

    public boolean isCreature(int kind) {
        switch (kind) {
            case Sprite.KIND_GOOMBA:
            case Sprite.KIND_RED_KOOPA:
            case Sprite.KIND_RED_KOOPA_WINGED:
            case Sprite.KIND_GREEN_KOOPA:
            case Sprite.KIND_GREEN_KOOPA_WINGED:
                return true;
        }
        return false;
    }

    public boolean isEnemyFront() {
        int x = marioEgoRow;
        int y = marioEgoCol;

        return isCreature(enemies[x][y + 3])
                || isCreature(enemies[x][y + 2])
                || isCreature(enemies[x][y + 1])
                || isCreature(enemies[x + 1][y + 1]);
    }

    public boolean isObstacleFront() {
        int x = marioEgoRow;
        int y = marioEgoCol;

        return isCreature(enemies[x][y + 3])
                || isCreature(enemies[x][y + 2])
                || isCreature(enemies[x][y + 1])
                || isCreature(enemies[x + 1][y + 1]);
    }
}
