package ch.idsia.agents.controllers;

import ch.idsia.agents.Agent;
import ch.idsia.agents.controllers.tree.*;
import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.engine.sprites.Sprite;
import ch.idsia.benchmark.mario.environments.Environment;

import java.util.*;

public class BehaviorTreeAgent extends BasicMarioAIAgent implements Agent {
    public BehaviorTree behaviorTree;
    public BehaviorTreeAgent() {
        super("BehaviorTreeAgent");
        reset();

        behaviorTree = new BehaviorTree(this);

        Task shoot = new ShootFireBall();
        Task isEnemyInFront = new IsEnemyInFront();
        Task moveRight = new MoveRight();
        Task jump = new Jump();
        Task isObstacleInFront = new IsObstacleInFront();
        Task isEnemyInFireballRange = new IsEnemyInFireballRange();
        Task isSafeInFront = new IsSafeInFront();

        List<Task> childrenSeq1 = new ArrayList<>();
        childrenSeq1.add(isEnemyInFireballRange);
        childrenSeq1.add(shoot);

        List<Task> childrenSeq2 = new ArrayList<>();
        childrenSeq2.add(isObstacleInFront);
        childrenSeq2.add(jump);

        List<Task> childrenSeq3 = new ArrayList<>();
        childrenSeq3.add(isEnemyInFront);
        childrenSeq3.add(jump);

        List<Task> childrenSeq4 = new ArrayList<>();
        childrenSeq4.add(isSafeInFront);
        childrenSeq4.add(moveRight);

        Sequence s1 = new Sequence(childrenSeq1);
        Sequence s2 = new Sequence(childrenSeq2);
        Sequence s3 = new Sequence(childrenSeq3);
        Sequence s4 = new Sequence(childrenSeq4);


        behaviorTree.pushBack(s1);
        behaviorTree.pushBack(s2);
        behaviorTree.pushBack(s3);
        behaviorTree.pushBack(s4);

    }

    public void keyRight() {
        action[Mario.KEY_RIGHT] = true;
    }

    public void keyJump() {
        action[Mario.KEY_JUMP] = true;
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

        return levelScene[x][y + 3] != 0
                || levelScene[x][y + 2] != 0
                || levelScene[x][y + 1] != 0
                || levelScene[x + 1][y + 1] != 0;
    }

    public boolean isSafeFront() {
        return !isEnemyFront() && !isObstacleFront();
    }

    public boolean[] getAction(){
        reset();
        behaviorTree.run();
        return action;
    }

    public void reset()
    {
        action = new boolean[Environment.numberOfKeys];
    }

}
