package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

public abstract class Task {
    public static final int TASK_RUNNING = 2;
    public static final int TASK_SUCCESS = 1;
    public static final int TASK_FAILURE = 0;
    public abstract int run(BehaviorTreeAgent behaviorTreeAgent);
}
