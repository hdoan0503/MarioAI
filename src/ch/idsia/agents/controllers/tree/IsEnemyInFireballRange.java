package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class IsEnemyInFireballRange extends Task {

    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        if(behaviorTreeAgent.isAbleShoot()) {
            System.out.println("InShootRange");
            return TASK_SUCCESS;
        }
        else {
            return TASK_FAILURE;
        }
    }
}
