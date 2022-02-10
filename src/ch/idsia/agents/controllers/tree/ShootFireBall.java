package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public class ShootFireBall extends Task {
    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        behaviorTreeAgent.keyShoot();
        System.out.println("Shoot");
        return TASK_SUCCESS;
    }
}
