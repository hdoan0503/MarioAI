package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

import java.util.ArrayList;

public class Sequence extends Task implements Composites {
    private final ArrayList<Task> tasks;

    public Sequence(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int run(BehaviorTreeAgent behaviorTreeAgent) {
        for(Task t: tasks) {
            if(t.run(behaviorTreeAgent) == TASK_SUCCESS) {
                return TASK_SUCCESS;
            }
        }
        return TASK_FAILURE;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task t) {
        tasks.add(t);
    }
}
