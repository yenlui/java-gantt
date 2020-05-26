package fr.yenlui.gantt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BasicGanttElementTest {

    @Test
    public void shouldDetectDependency() {
        BasicGanttTestElement element = BasicGanttTestElement.builder().input("A").build(),
                other = BasicGanttTestElement.builder().output("A").build(),
                noDepends = BasicGanttTestElement.builder().output("B").build();

        assertThat(element.dependsOn(other)).isTrue();
        assertThat(element.dependsOn(noDepends)).isFalse();
    }
}