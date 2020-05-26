package fr.yenlui.gantt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GanttService {

    public <T extends GanttElement<T>> GanttChart<T> buildChartFromElements(T... elements) {
        return buildChartFromElements(Arrays.asList(elements));
    }

    public <T extends GanttElement<T>> GanttChart<T> buildChartFromElements(List<T> elements) {
        GanttChart<T> chart = new GanttChart<>();
        chart.chartElements = elements.stream().map(GanttChartElement<T>::new).collect(Collectors.toList());

        while (chart.chartElements.stream().filter(chartElement -> chartElement.offset == null).count() > 0) {
            for (GanttChartElement<T> chartElement : chart.chartElements) {
                if (chartElement.offset == null) {
                    // find dependencies of current element
                    List<GanttChartElement<T>> dependencies = chart.chartElements.stream()
                            .filter(otherChartElement -> chartElement.element.dependsOn((T) otherChartElement.element))
                            .collect(Collectors.toList());

                    // skip it if dependencies are not solved already
                    if (dependencies.stream().filter(dep -> dep.offset == null).count() > 0) {
                        continue;
                    }

                    // else compute current offset as max offset + duration
                    chartElement.offset = dependencies.stream().map(dep -> dep.offset + dep.element.getDuration())
                            .max(Long::compare).orElse(0L); // 0L if no dependency found
                }
            }
        }

        return chart;
    }
}