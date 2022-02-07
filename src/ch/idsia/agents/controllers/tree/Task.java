package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

abstract class Task {
    public static int TASK_SUCCESS = 1;
    public static int TASK_FAILURE = 0;
    public abstract int run(BehaviorTreeAgent behaviorTreeAgent);
}
