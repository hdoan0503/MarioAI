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
        Task isEnemyInFireballRange = new IsEnemyInFireballRange();
        Task isAbleToJump = new IsAbleToJump();
        Task jump = new Jump();
        Task moveRight = new MoveRight();
        Task isSafeInFront = new IsSafeInFront();

        List<Task> childrenSeq1 = new ArrayList<>();
        childrenSeq1.add(isEnemyInFireballRange);
        childrenSeq1.add(shoot);

        List<Task> childrenSeq2 = new ArrayList<>();
        childrenSeq2.add(isSafeInFront);
        childrenSeq2.add(moveRight);

        List<Task> childrenSeq3 = new ArrayList<>();
        childrenSeq3.add(isAbleToJump);
        childrenSeq3.add(jump);

        Composite c1 = new Sequence(childrenSeq1);
        Composite c2 = new Sequence(childrenSeq2);
        Composite c3 = new Sequence(childrenSeq3);

        behaviorTree.pushBack(c1);
        behaviorTree.pushBack(c2);
        behaviorTree.pushBack(c3);

    }

    public void keyRight() {
        action[Mario.KEY_RIGHT] = true;
    }

    public void keyJump() {
        action[Mario.KEY_JUMP] = true;
    }

    public void keyShoot() {
        action[Mario.KEY_SPEED] = true;
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


        return  isCreature(enemies[x][y + 2])
                || isCreature(enemies[x][y + 1])
                || isCreature(enemies[x + 1][y + 1]);
    }

    public boolean isObstacleFront() {
        int x = marioEgoRow;
        int y = marioEgoCol;

        return  levelScene[x][y + 2] != 0
                || levelScene[x][y + 1] != 0
                || levelScene[x + 1][y + 1] != 0;
    }

    public boolean isSafeFront() {
        return !isEnemyFront() && !isObstacleFront();
    }

    public boolean wallRight(){
        return levelScene[marioEgoRow][marioEgoCol + 1] == -60 //BORDER_CANNOT_PASS_THROUGH
                || levelScene[marioEgoRow][marioEgoCol + 1] == -85 //FLOWER_POT_OR_CANNON
                || levelScene[marioEgoRow][marioEgoCol + 1] == -24 //BREAKABLE BRICK WITH QUESTION MARK
                || levelScene[marioEgoRow][marioEgoCol + 1] == -20; //BREAKABLE BRICK
    }

    public boolean brickAbove(){
        return levelScene[marioEgoRow][marioEgoCol] == -24
                || levelScene[marioEgoRow - 1][marioEgoCol] == -24
                || levelScene[marioEgoRow - 2][marioEgoCol] == -24;
    }


    public boolean isAbleJump() {
        return (wallRight()
                || brickAbove()
                || isEnemyFront())
                && (isMarioAbleToJump
                || !isMarioOnGround);
    }

    public boolean isAbleShoot() {
        int x = marioEgoRow;
        int y = marioEgoCol;

        return (isCreature(enemies[x][y])
                || isCreature(enemies[x - 1][y])
                || isCreature(enemies[x - 2][y])
                || isCreature(enemies[x - 1][y + 1])
                || isCreature(enemies[x - 2][y + 2])
                || isEnemyFront())
                && isMarioAbleToShoot;
    }


    public boolean[] getAction(){
        reset();
        behaviorTree.run();
        return action;
    }

    public void reset()
    {
        action = new boolean[Environment.numberOfKeys];
        action[Mario.KEY_RIGHT] = true;
    }

}
