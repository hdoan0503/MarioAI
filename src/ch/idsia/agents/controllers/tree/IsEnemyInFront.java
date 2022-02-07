package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class IsEnemyInFront extends Task implements Conditions{

    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        if (behaviorTreeAgent.isEnemyFront()) {
            return TASK_SUCCESS;
        }
        else{
            return TASK_FAILURE;
        }
    }
}
