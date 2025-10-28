package p1;

public class App {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(new StudentDto("철수"));
        list.add(new StudentDto("영희"));
        list.add(new StudentDto("길동"));
        list.add(new StudentDto("한조"));

        list.add(new StudentDto("메르시"), 2);

        System.out.println(list);
    }
}

class StudentDto {
    StudentDto(String name) {
        this.name = name;
    }
    String name;
    int age;
    int score;

}

class MyLinkedList {

    // Node 내부 클래스
    private static class Node {
        StudentDto data;
        Node next;

        Node(StudentDto data) {
            this.data = data;
        }
    }

    private Node firstNode;
    private int size;

    // 마지막에 추가
    public void add(StudentDto dto) {
        Node newNode = new Node(dto);
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            Node tempNode = firstNode;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        size++;
    }

    // 특정 위치에 추가
    public void add(StudentDto dto, int index) {
        Node newNode = new Node(dto);

        if (index == 0) {
            newNode.next = firstNode;
            firstNode = newNode;
        } else {
            Node temp = firstNode;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    // 삭제
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }

        if (index == 0) {
            firstNode = firstNode.next;
        } else {
            Node temp = firstNode;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    // 접근 (... 진짜 최악...)
    public StudentDto get(int index) {
        if(index == 0) {
            return firstNode.data;
        }

        // 링크드 리스트의 최대 약점 코드
        Node tempNode = firstNode;
        for(int i = 0; i < index; i++){
            tempNode = tempNode.next;
        }

        return tempNode.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = firstNode;
        while (temp != null) {
            sb.append(temp.data.name);
            if (temp.next != null) sb.append(", ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}