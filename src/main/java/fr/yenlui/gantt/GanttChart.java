package fr.yenlui.gantt;

import java.util.Collections;
import java.util.List;

public class GanttChart<T extends GanttElement<T>> {

    List<GanttChartElement<T>> chartElements;

    public List<GanttChartElement<T>> getChartElements() {
        Collections.sort(chartElements);
        return chartElements;
    }
}
