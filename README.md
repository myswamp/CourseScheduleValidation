# CourseScheduleValidation

In Universities, A program contains multiple courses, those courses could potentially have dependencies among each other. This concept is refered to as course prerequisite. e.g in order to take course A, a student has to take Course B first.

This dependency relationships among courses can be modeled as a graph structure intuitively. We can apply topological sort to examine if the graph is a DAG (directed acycle graph). A valid course selection flow should be a DAG. 
