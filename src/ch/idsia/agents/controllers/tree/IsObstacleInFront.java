package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class IsObstacleInFront extends Task {

    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        if (behaviorTreeAgent.isObstacleFront()) {
            return TASK_SUCCESS;
        }
        else{
            return TASK_FAILURE;
        }
    }
}
