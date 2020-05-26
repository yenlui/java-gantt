package fr.yenlui.gantt;

public interface GanttElement<T extends GanttElement<T>> {

    public default Long getDuration() {
        return 1L;
    }

    public boolean dependsOn(T other);
}