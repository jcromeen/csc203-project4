interface PathingStrategy
{
    /*
    * Returns a prefix of a path from the start point to a point within reach
    * of the end point.  This path is only valid ("clear") when returned, but
    * may be invalidated by movement of other entities.
    *
    * The prefix includes neither the start point nor the end point.
    */
    List computePath(Point start, Point end,
        Predicate canPassThrough,
        BiPredicate<Point, Point> withinReach,
        Function<Point, Stream> potentialNeighbors);

    static final Function<Point, Stream> CARDINAL_NEIGHBORS =
        point ->
        Stream.builder()
            .add(new Point(point.x, point.y - 1))
            .add(new Point(point.x, point.y + 1))
            .add(new Point(point.x - 1, point.y))
            .add(new Point(point.x + 1, point.y))
            .build();
}