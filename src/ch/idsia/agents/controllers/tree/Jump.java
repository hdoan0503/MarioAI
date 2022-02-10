package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class Jump extends Task {
    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        behaviorTreeAgent.keyJump();
        behaviorTreeAgent.keyRight();
        System.out.println("Jump");
        return TASK_SUCCESS;
    }
}
