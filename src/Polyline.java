import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline() {
        this.points = new ArrayList<>();
    }

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public Point getFirstPoint() {
        return points.isEmpty() ? null : points.get(0);
    }

    public Point getLastPoint() {
        return points.isEmpty() ? null : points.get(points.size() - 1);
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void addPoint(double x, double y) {
        points.add(new Point(x, y));
    }

    public void move(double dx, double dy) {
        for (Point point : points) {
            point.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}