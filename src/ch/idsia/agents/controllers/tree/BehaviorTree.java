package ch.idsia.agents.controllers.tree;

import ch.idsia.agents.controllers.BehaviorTreeAgent;

import java.util.ArrayList;

public class BehaviorTree {
    public BehaviorTreeAgent behaviorTreeAgent;
    public ArrayList<Task> tasks;

    public BehaviorTree(BehaviorTreeAgent behaviorTreeAgent) {
        this.behaviorTreeAgent = behaviorTreeAgent;
    }

    public void pushBack(Task child){
        tasks.add(child);
    }
}
