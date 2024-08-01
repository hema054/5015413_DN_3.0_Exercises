package CTS_Weekly_Exercies.Week1_DSA.Task_management_system;

public class TaskManagementSystem {
    private Node head;

    public TaskManagementSystem() {
        head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTaskId() == taskId) {
                return current.getTask();
            }
            current = current.getNext();
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.getTask().getTaskId());
            System.out.println("Task Name: " + current.getTask().getTaskName());
            System.out.println("Status: " + current.getTask().getStatus());
            System.out.println();
            current = current.getNext();
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }
        if (head.getTask().getTaskId() == taskId) {
            head = head.getNext();
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getTask().getTaskId() == taskId) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    private class Node {
        private Task task;
        private Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }

        public Task getTask() {
            return task;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
