package fr.yenlui.gantt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GanttServiceTest {

    private GanttService service;

    @Before
    public void prepareService() {
        this.service = new GanttService();
    }

    @Test
    public void shouldNotFailsOnEmpty() {
        GanttChart<?> chart = service.buildChartFromElements();
        assertThat(chart.chartElements).hasSize(0);

    }

    @Test
    public void shouldBuildMinimalChart() {
        GanttChart<BasicGanttTestElement> chart = service.buildChartFromElements(
                BasicGanttTestElement.builder().input("A").build(),
                BasicGanttTestElement.builder().output("A").build());

        assertThat(chart.getChartElements()).hasSize(2);
        assertThat(chart.getChartElements().get(0).getOffset()).isEqualTo(0);
        assertThat(chart.getChartElements().get(1).getOffset()).isEqualTo(1);
    }

    @Test
    public void shouldBuild21ChartWithMaxOffset() {
        GanttChart<BasicGanttTestElement> chart = service.buildChartFromElements(
                BasicGanttTestElement.builder().input("A").input("B").build(),
                BasicGanttTestElement.builder().output("A").duration(2L).build(),
                BasicGanttTestElement.builder().output("B").build());

        assertThat(chart.getChartElements()).hasSize(3);
        assertThat(chart.getChartElements().get(0).getOffset()).isEqualTo(0);
        assertThat(chart.getChartElements().get(1).getOffset()).isEqualTo(0);
        assertThat(chart.getChartElements().get(2).getOffset()).isEqualTo(2);
    }
}