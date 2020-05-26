package fr.yenlui.gantt;

import lombok.Getter;

public class GanttChartElement<T extends GanttElement<T>> implements Comparable<GanttChartElement<T>> {

    @Getter
    GanttElement<T> element;

    @Getter
    Long offset;

    public GanttChartElement(T element) {
        this.element = element;
    }

    @Override
    public int compareTo(GanttChartElement<T> other) {
        return Long.compare(offset, other.offset);
    }

}
