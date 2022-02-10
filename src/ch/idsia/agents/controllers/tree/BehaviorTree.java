package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

import java.util.ArrayList;

public class BehaviorTree {
    public BehaviorTreeAgent behaviorTreeAgent;
    public ArrayList<Task> tasks;

    public BehaviorTree(BehaviorTreeAgent behaviorTreeAgent) {
        tasks = new ArrayList<>();
        this.behaviorTreeAgent = behaviorTreeAgent;
    }

    public void pushBack(Task child){
        tasks.add(child);
    }

    public void run() {
        for(Task t: tasks) {
            if(t.run(behaviorTreeAgent) == Task.TASK_SUCCESS) {
                break;
            }
        }
    }
}
