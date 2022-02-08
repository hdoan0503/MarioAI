package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

import java.util.ArrayList;

public class BehaviorTree {
    public BehaviorTreeAgent behaviorTreeAgent;
    public ArrayList<Task> tasks;

    public BehaviorTree(BehaviorTreeAgent behaviorTreeAgent, ArrayList<Task> tasks) {
        this.behaviorTreeAgent = behaviorTreeAgent;
        this.tasks = tasks;
    }

    public void pushBack(Task child){
        tasks.add(child);
    }

    public void run() {
        for(Task t: tasks) {
            if(t.run(behaviorTreeAgent) == 1) {
                break;
            }
        }
    }
}
