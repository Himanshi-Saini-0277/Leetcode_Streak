class TaskManager {
    class Task {
        int taskId;
        int priority;

        Task(int taskId, int priority) {
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private TreeMap<Task, Integer> taskQueue;
    private Map<Integer, Integer> taskPriorityMap;

    public TaskManager(List<List<Integer>> tasks) {
        taskQueue = new TreeMap<>((a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a.priority;
            }
            return b.taskId - a.taskId;
        });

        taskPriorityMap = new HashMap<>();

        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            taskQueue.put(new Task(taskId, priority), userId);
            taskPriorityMap.put(taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskQueue.put(new Task(taskId, priority), userId);
        taskPriorityMap.put(taskId, priority);
    }

    public void edit(int taskId, int newPriority) {
        int oldPriority = taskPriorityMap.get(taskId);
        Task oldTask = new Task(taskId, oldPriority);
        int userId = taskQueue.get(oldTask);

        taskQueue.remove(oldTask);
        taskQueue.put(new Task(taskId, newPriority), userId);
        taskPriorityMap.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        if (!taskPriorityMap.containsKey(taskId)) return;
        int priority = taskPriorityMap.get(taskId);

        taskQueue.remove(new Task(taskId, priority));
        taskPriorityMap.remove(taskId);
    }

    public int execTop() {
        if (taskQueue.isEmpty()) return -1;

        Task topTask = taskQueue.firstKey();
        int userId = taskQueue.get(topTask);

        taskQueue.remove(topTask);
        taskPriorityMap.remove(topTask.taskId);

        return userId;
    }
}