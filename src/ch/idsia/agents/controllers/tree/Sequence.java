package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

import java.util.*;


public class Sequence extends Composite {
    protected List<Task> current;

    public Sequence(List<Task> children) {
        super(children);
        current = children;
    }

    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        for(Task t: current) {
            if(t.run(behaviorTreeAgent) != TASK_SUCCESS) {
                return TASK_FAILURE;
            }
        }
        return TASK_SUCCESS;
    }

}
