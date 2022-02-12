package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class IsAbleToJump extends Task{
    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        if(behaviorTreeAgent.isAbleJump()) {
            System.out.println("Dangerous");
            return TASK_SUCCESS;
        }
        else {
            return TASK_FAILURE;
        }
    }
}
