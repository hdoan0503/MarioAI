package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class IsSafeInFront extends Task {
    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        if(behaviorTreeAgent.isSafeFront()) {
            System.out.println("SafeFront");
            return TASK_SUCCESS;
        }
        return TASK_FAILURE;
    }
}
