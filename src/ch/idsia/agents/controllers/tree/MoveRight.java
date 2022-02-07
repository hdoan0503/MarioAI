package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class MoveRight extends Task implements Actions {
    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        behaviorTreeAgent.keyRight();
        System.out.println("Move Right");
        return TASK_SUCCESS;
    }
}
