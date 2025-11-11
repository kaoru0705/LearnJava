# 학생 관리 프로그램 - 아키텍처 문서

## 📋 프로그램 개요

학생 정보(이름, 나이, 점수)를 관리하는 CLI 기반 프로그램입니다.
**컴포지트 패턴**과 **SRP(Single Responsibility Principle) 원칙**을 적용하여 구현되었습니다.

---

## 🏗️ 아키텍처 구조

### 1️⃣ **메뉴 시스템 (컴포지트 패턴)**

#### 핵심 클래스:
- **Menu** (인터페이스): 모든 메뉴의 공통 인터페이스
- **MenuItem**: 실행 가능한 단일 메뉴 항목 (Leaf 노드)
- **MenuGroup**: 여러 메뉴를 포함할 수 있는 그룹 (Composite 노드)

#### 특징:
- 단일 메뉴 항목과 메뉴 그룹을 동일하게 취급
- 트리 구조로 확장 가능한 메뉴 시스템
- 재귀적으로 메뉴를 검색하고 실행

```
메인 메뉴 (MenuGroup)
├── 학생 등록 (MenuItem: "1")
├── 학생 삭제 (MenuItem: "2")
├── 학생 정보 수정 (MenuItem: "3")
├── 학생 목록 조회 (MenuItem: "4")
└── 프로그램 종료 (MenuItem: "5")
```

---

### 2️⃣ **Command 패턴 (액션 분리)**

#### 핵심 클래스:
- **MenuCommand** (인터페이스): 메뉴 선택 시 실행할 명령의 인터페이스
- **AddStudentCommand**: 학생 추가 명령
- **DeleteStudentCommand**: 학생 삭제 명령
- **UpdateStudentCommand**: 학생 정보 수정 명령
- **DisplayStudentCommand**: 학생 목록 조회 명령
- **ExitCommand**: 프로그램 종료 명령

#### 특징:
- 메뉴 선택과 액션을 분리
- 새로운 기능 추가 시 새로운 Command 클래스만 추가
- 메뉴 구조 변경 없이 액션만 변경 가능

---

### 3️⃣ **서비스 레이어 (SRP 원칙)**

#### 핵심 클래스:
- **StudentAddService**: 학생 추가 기능 전담
  - 사용자 입력 처리
  - 입력 유효성 검사
  - StudentManager 호출

- **StudentDeleteService**: 학생 삭제 기능 전담
- **StudentUpdateService**: 학생 정보 수정 기능 전담
- **StudentDisplayService**: 학생 목록 표시 기능 전담

#### 특징:
- 각 클래스가 단 하나의 책임만 담당
- 코드 재사용성 및 테스트 용이성 증대
- 기능 변경 시 해당 Service 클래스만 수정

---

### 4️⃣ **매니저 계층 (데이터 관리)**

#### 핵심 클래스:
- **StudentManager**: 학생 정보 관리
  - 학생 추가/삭제/수정/조회
  - 이름으로 학생 검색

- **StudentFileManager**: 파일 저장/로드
  - 학생 정보를 파일에 저장
  - 파일에서 학생 정보 로드

- **MenuManager**: 메뉴 시스템 관리
  - 메뉴 구조 생성
  - 사용자 입력 처리
  - 메뉴 실행

---

### 5️⃣ **데이터 모델**

#### Student
```
- name: String (학생 이름)
- age: int (학생 나이)
- score: double (학생 점수)
```

---

## 🔄 프로그램 실행 흐름

```
1. App.main() 실행
   ↓
2. StudentManager, StudentFileManager, MenuManager 생성
   ↓
3. 파일에서 이전 데이터 로드 (StudentFileManager.loadStudents())
   ↓
4. 메뉴 루프 시작 (MenuManager.showMenuAndExecute())
   ├─ 메뉴 표시 (MenuGroup.display())
   ├─ 사용자 입력받기
   ├─ 메뉴 검색 (MenuGroup.findMenuById())
   ├─ 메뉴 실행 (Menu.execute())
   │  └─ Command 실행
   │     └─ Service 실행
   │        └─ StudentManager/StudentFileManager 호출
   └─ 반복...
   ↓
5. 프로그램 종료 시 데이터 저장 (StudentFileManager.saveStudents())
```

---

## 📁 파일 구조

```
src/
├── App.java                    # 메인 클래스 (프로그램 진입점)
├── Student.java                # 학생 데이터 모델
├── StudentManager.java         # 학생 정보 관리
├── StudentFileManager.java     # 파일 저장/로드 관리
│
├── Menu.java                   # 메뉴 인터페이스
├── MenuItem.java               # 단일 메뉴 항목
├── MenuGroup.java              # 메뉴 그룹 (컴포지트)
├── MenuManager.java            # 메뉴 시스템 관리
├── MenuCommand.java            # 메뉴 명령 인터페이스
│
├── AddStudentCommand.java      # 학생 추가 명령
├── DeleteStudentCommand.java   # 학생 삭제 명령
├── UpdateStudentCommand.java   # 학생 수정 명령
├── DisplayStudentCommand.java  # 학생 조회 명령
├── ExitCommand.java            # 종료 명령
│
├── StudentAddService.java      # 학생 추가 서비스
├── StudentDeleteService.java   # 학생 삭제 서비스
├── StudentUpdateService.java   # 학생 수정 서비스
└── StudentDisplayService.java  # 학생 조회 서비스
```

---

## ✨ 설계 원칙 적용

### 🎯 컴포지트 패턴 (Composite Pattern)
- **Menu 인터페이스**: 단일 항목과 그룹의 공통 인터페이스
- **MenuItem**: Leaf 노드 (실행 가능한 항목)
- **MenuGroup**: Composite 노드 (자식 메뉴 포함)
- **장점**: 트리 구조로 쉽게 메뉴 확장 가능

### 🎯 Command 패턴 (Command Pattern)
- 메뉴 선택(Menu)과 액션(Command)을 분리
- 각 Command는 독립적으로 변경 가능
- 새로운 메뉴 기능 추가 시 기존 코드 수정 최소화
- **장점**: 메뉴와 기능의 느슨한 결합

### 🎯 SRP (Single Responsibility Principle)
- **각 클래스는 하나의 책임만 담당**:
  - MenuItem: 메뉴 항목 표시
  - MenuCommand: 명령 실행
  - Service: 비즈니스 로직
  - Manager: 데이터 관리
- **장점**: 코드 유지보수 용이, 테스트 간편

---

## 🚀 향후 확장 예시

새로운 기능(예: 성적 통계 기능) 추가 시:

```java
// 1. Service 클래스 추가
public class StudentStatisticsService { ... }

// 2. Command 클래스 추가
public class DisplayStatisticsCommand implements MenuCommand { ... }

// 3. MenuManager의 buildMenu()에 MenuItem 추가
mainMenu.addChild(new MenuItem("6", "성적 통계", new DisplayStatisticsCommand(...)));

// 기존 코드 수정 없음! ✅
```

---

## 💾 파일 저장 형식

`students.txt` 파일:
```
이름|나이|점수
김철수|20|95
이영희|19|87
박민준|21|92
```

---

## 🎓 학습 포인트

이 프로그램은 다음의 중요한 설계 원칙을 보여줍니다:

1. **객체지향 설계 패턴**: 컴포지트, 커맨드, 서비스 패턴
2. **SOLID 원칙**: 특히 SRP 원칙의 철저한 적용
3. **느슨한 결합**: 인터페이스를 통한 의존성 역전
4. **높은 응집도**: 관련 기능들의 명확한 분리
5. **확장성**: 새로운 기능 추가 시 기존 코드 수정 최소화

