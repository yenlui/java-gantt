package fr.yenlui.gantt;

import java.util.ArrayList;
import java.util.List;

public interface BasicGanttElement<T extends BasicGanttElement<T>> extends GanttElement<T> {

    public List<String> getInputs();

    public List<String> getOutputs();

    public default boolean dependsOn(T other) {
        List<String> inputs = new ArrayList<>(this.getInputs());
        inputs.removeAll(other.getOutputs());

        return inputs.size() != this.getInputs().size();
    }

}