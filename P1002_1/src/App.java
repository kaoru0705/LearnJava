import java.util.*;

public class App {

	public static void main(String[] args) {
		// 프로그래밍 구현 순서: 요구사항 분석(정의), 데이터 설계, 코드 구조, 구현, 테스팅 
		Scanner scn = new Scanner(System.in);
		
		String[] nameList = new String[5];
		int[] ageList = new int[5];
		int[] scoreList = new int[5];
		int count = 0;
		
		System.out.println("*********************");
		System.out.println("*   학생 관리 프로그램    *");
		System.out.println("*   버전: 1.0         *");
		System.out.println("*   작성자: 얼빵이       *");
		System.out.println("*********************");

		while(true) {
			System.out.println("----- 메뉴 -----");
			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 학생 통계");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("커맨드 입력 > ");
			String command = scn.nextLine();
			
			if(command.equals("0")) {
				break;
			}
			
			if(command.equals("1")) {
				System.out.println("[학생 정보 입력 로직 시작]");
				
				System.out.print("학생 이름 입력 > ");
				String name = scn.nextLine();
				
				// Q. 아래 동일
				System.out.print("학생 나이 입력 > ");
				String tempAge = scn.nextLine();
				int age = Integer.parseInt(tempAge);
				
				// Q. 100초과 0미만 값이 입력되었을 때, 에러문구 출력 및 재입력
				// Q. 숫자 이외의 값이 입력되었을때, 에러문구 출력 및 재입력
				System.out.print("학생 점수 입력 > ");
				String tempScore = scn.nextLine();
				int score = Integer.parseInt(tempScore);
				
				// ArrayList - 내부 구조
				if(nameList.length == count) {
					String[] newNameList = new String[count * 2];
					int[] newAgeList = new int[count * 2];
					int[] newScoreList = new int[count *2];					
					
					for(int i = 0; i < count; i++) {
						newNameList[i] = nameList[i];
						newAgeList[i] = ageList[i];
						newScoreList[i] = scoreList[i];
					}
					
					nameList = newNameList;
					ageList = newAgeList;
					scoreList = newScoreList;
				}
				
				nameList[count] = name;
				ageList[count] = age;
				scoreList[count] = score;
				count++;
				
				System.out.println("학생 정보가 정상적으로 입력되었습니다.");
				
			}else if(command.equals("2")) {
				System.out.println("[학생 목록 출력 로직 시작]");
				// Q. '점수를 기준으로 내림차순으로 출력할까요?(Y/n) > ' 
                System.out.print("점수를 기준으로 내림차순으로 출력할까요?(y/n) > ");
                String yesOrNo = scn.nextLine();
                int[] scoreIndexArr = new int[count];
                for(int i = 0; i < count; i++) {
                        scoreIndexArr[i] = i;
                }
                if(yesOrNo.equals("Y") || yesOrNo.equals("y")) {
                    int[] scoreCopyList = new int[count];
                    for(int i = 0; i < count; i++) {
                        scoreCopyList[i] = scoreList[i];
                    }
                    for(int x = 0; x < count - 1; x++) {
                        for(int y = 0; y < count - 1 - x; y++) {
                            if(scoreCopyList[y] < scoreCopyList[y + 1]) {
                                int temp = scoreCopyList[y];
                                scoreCopyList[y] = scoreCopyList[y+1];
                                scoreCopyList[y+1] = temp;

                                int tempIndex = scoreIndexArr[y];
                                scoreIndexArr[y] = scoreIndexArr[y+1];
                                scoreIndexArr[y+1] = tempIndex;
                            }
                        }
                    }
                }
				
				for(int i = 0; i < count ; i++) {
					String text = "이름: ";
					text += nameList[scoreIndexArr[i]];
					text += ", 나이: ";
					text += ageList[scoreIndexArr[i]];
					text += ", 점수: ";
					text += scoreList[scoreIndexArr[i]];
					System.out.println(text);
				}
				
				System.out.println("총 학생 수: " + count);
				
			}else if(command.equals("3")) {
				System.out.println("[학생 정보 검색 로직 시작]");
				
				System.out.print("검색 키워드 > ");
				String searchWord = scn.nextLine();
				
				int searchCount = 0;
				for(int i = 0 ; i < count ; i++) {
					// Q. contains()를 알고리즘으로 변경
					if(nameList[i].contains(searchWord)) {
						String text = "이름: ";
						text += nameList[i];
						text += ", 나이: ";
						text += ageList[i];
						text += ", 점수: ";
						text += scoreList[i];
						System.out.println(text);	
						searchCount++;
					}
				}
				
				System.out.println(searchCount + "명이 검색 되었습니다.");
				
			}else if(command.equals("4")) {
				System.out.println("[학생 정보 삭제 로직 시작]");
				
				System.out.print("삭제할 학생의 이름 > ");
				String deleteName = scn.nextLine();
				int deleteCount = 0;
				
				for(int i = 0 ; i < count ; i++) {
					if(nameList[i].equals(deleteName)) {
						//Q. '누구누구가 탐색되었습니다. (정보출력후) 삭제하시겠습니까? (Y/n)'
						for(int x = i; x < count - 1; x++) {
							nameList[x] = nameList[x+1];
							ageList[x] = ageList[x+1];
							scoreList[x] = scoreList[x+1];
						}
						count--;
						i--;
						deleteCount++;
					}
				}
				
				System.out.println(deleteCount + "명이 삭제 되었습니다.");
				
				
			}else if(command.equals("5")) {
				System.out.println("[학생 정보 통계 로직 시작]");
				
				int sum = 0;
				for(int i = 0; i < count; i++) {
					sum += scoreList[i];
				}
				
				//Q. 소수점 2자리까지만 나오게
				double average = sum/(double)count;
				
				System.out.println("총 학생 수: " + count + ", 평균: " + average);				
			}
			
			System.out.println("계속하시려면 enter를 입력해주세요.");
			scn.nextLine();
			
		}

		System.out.println("프로그램이 종료되었습니다.");
		
	}

}
