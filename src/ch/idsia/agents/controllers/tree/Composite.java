package ch.idsia.agents.controllers.tree;

import java.util.List;

public abstract class Composite extends Task{
    protected List<Task> children;

    public Composite(List<Task> children){
        this.children = children;
    }


}
