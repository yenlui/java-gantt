package fr.yenlui.gantt;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.Builder.Default;

@Builder
@Data
class BasicGanttTestElement implements BasicGanttElement<BasicGanttTestElement> {

    @Singular
    private List<String> inputs;

    @Singular
    private List<String> outputs;

    @Default
    private Long duration = 1L;

    @Override
    public List<String> getInputs() {
        return inputs;
    }

    @Override
    public List<String> getOutputs() {
        return outputs;
    }

}