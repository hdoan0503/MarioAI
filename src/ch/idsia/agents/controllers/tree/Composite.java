package ch.idsia.agents.controllers.tree;

import java.util.List;

public abstract class Composite extends Task{
    protected List<Task> m_children;
    Composite(List<Task> a_children) {
        m_children = a_children;
    }
}
