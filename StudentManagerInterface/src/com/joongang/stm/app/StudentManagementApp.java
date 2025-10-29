package com.joongang.stm.app;

import java.util.List;

import com.joongang.stm.dto.StudentDto;
import com.joongang.stm.menu.ActionCommand;
import com.joongang.stm.menu.Menu;
// 2. 학생 관리 프로그램 적용 예시
// 위의 클래스들을 사용하여 3단계 메뉴 구조를 설계합니다.
// 2.1. 프로그램의 계층 구조
// 메인 메뉴 (Menu)
// 학생 관리 (Menu)
// 학생 등록 (ActionCommand)
// 학생 정보 검색 (ActionCommand)
// 성적 관리 (Menu)
// 성적 입력 (ActionCommand)
// 성적 조회 (ActionCommand)
// 시스템 종료 (ActionCommand)
// 2.2. 구현 코드
import com.joongang.stm.repository.Repository;
import com.joongang.stm.util.IoManager;

public class StudentManagementApp {
    private static Repository repository = new Repository();

    // 이 클래스에서 학생 데이터를 관리한다고 가정
    // 예시를 위해 간단한 로직만 구현합니다.
    private static void registerStudent() {
        System.out.println("--- [학생 등록 기능] : 이름, 학번 등을 입력받아 저장");
        // 실제 학생 객체 생성 및 리스트에 추가 로직 구현
        String name = IoManager.input("이름 입력 > ");
        String id = IoManager.input("학번 입력 > ");
        int age = IoManager.intgerInput("나이 입력 > ");
        int score = IoManager.intgerInput("점수 입력 > ");

        StudentDto studentDto = new StudentDto(name, id, age, score);

        repository.save(studentDto);

        IoManager.println("============================");
    }

    private static void searchStudent() {
        System.out.println("--- [학생 정보 검색 기능] : 검색 조건에 맞는 학생 정보 출력");

        String searchWord = IoManager.input("검색할 이름 > ");

        List<StudentDto> list = repository.findbyNameContaining(searchWord);

        for(StudentDto studentDto: list) {
            String text = "";
            text += "이름: " + studentDto.getName();
            text += ", 학번: " + studentDto.getName();
            text += ", 나이: " + studentDto.getAge();
            text += ", 점수: " + studentDto.getScore();
            IoManager.println(text);
        }

        IoManager.println("============================");
    }

    private static void inputGrade() {
        System.out.println("--- [성적 입력 기능] : 특정 학생의 과목별 성적 입력");
    }

    private static void viewGrade() {
        System.out.println("--- [성적 조회 기능] : 학생별/과목별 성적 리포트 출력");
    }

    public static void main(String[] args) {
        // ----------------------------------------------------
        // 1. 최하위 레벨 (ActionCommand) 정의: 실제 기능
        // ----------------------------------------------------
        
        // 학생 관리 하위 기능
        ActionCommand register = new ActionCommand("학생 등록", StudentManagementApp::registerStudent);
        ActionCommand search = new ActionCommand("학생 정보 검색", StudentManagementApp::searchStudent);

        // 성적 관리 하위 기능
        ActionCommand inputG = new ActionCommand("성적 입력", StudentManagementApp::inputGrade);
        ActionCommand viewG = new ActionCommand("성적 조회", StudentManagementApp::viewGrade);

        // ----------------------------------------------------
        // 2. 중간 레벨 (Menu) 정의: 2단계 메뉴
        // ----------------------------------------------------
        
        Menu studentMenu = new Menu("학생 관리");
        studentMenu.add(register);
        studentMenu.add(search);

        Menu gradeMenu = new Menu("성적 관리");
        gradeMenu.add(inputG);
        gradeMenu.add(viewG);

        // ----------------------------------------------------
        // 3. 최상위 레벨 (Menu) 정의: 메인 메뉴
        // ----------------------------------------------------
        
        Menu mainMenu = new Menu("학생 관리 시스템 메인");
        mainMenu.add(studentMenu); // 2단계 메뉴를 1단계 메뉴에 추가
        mainMenu.add(gradeMenu);   // 2단계 메뉴를 1단계 메뉴에 추가
        // 종료 기능은 ActionCommand를 특별히 구현하거나, Menu 클래스 내부의 0번 로직을 사용합니다.
        
        // ----------------------------------------------------
        // 4. 프로그램 시작
        // ----------------------------------------------------
        System.out.println("== 학생 관리 프로그램 시작 ==");
        mainMenu.execute(); 
        System.out.println("== 학생 관리 프로그램 종료 ==");
    }
}

// ⚠️ 참고: MenuItem, Menu, ActionCommand 클래스는 위에 제공된 코드를 그대로 사용합니다.
// 3. 설계의 장점
// 이 설계 방식은 객체 지향 디자인 패턴을 활용하여 다음과 같은 장점을 가집니다.
// 확장성 (Composite 패턴): 메뉴의 계층 구조를 무한히 깊게 만들 수 있습니다. Menu는 MenuItem을 포함하고, Menu 자체도 MenuItem이기 때문에, 메뉴 안에 메뉴를 계속 추가할 수 있습니다.
// 유연성 (Command 패턴): 각 메뉴 항목의 **실행 로직(ActionCommand)**을 메뉴의 구조(Menu)와 분리합니다. 새로운 기능을 추가하거나 기존 기능의 로직을 변경해도 메뉴 구조를 수정할 필요가 없습니다.
// 단일 책임 원칙:
// Menu 클래스는 메뉴 구조를 관리하고 사용자 입력을 받아 하위 항목으로 위임하는 역할만 합니다.
// ActionCommand는 특정 기능(학생 등록, 성적 조회 등)을 실행하는 역할만 합니다.