package com.joongang.stm.repository;

import com.joongang.stm.dto.StudentDto;
import com.joongang.stm.util.IoManager;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;


// 컴포넌트
// 역할: 저장소 - 데이터 입출력 담당
// 이 부분은 사실상 DB 쿼리로 변경 예정 - 직접 구현할 일 없음
public class Repository {
    private List<StudentDto> list = new ArrayList<>();

    public void save(StudentDto studentDto) {
        list.add(studentDto);
    }

    public List<StudentDto> findAll() {
        if(list.isEmpty()) {
            IoManager.println("등록된 학생이 없습니다.");
            return new ArrayList<>();
        }
        List<StudentDto> copyList = new ArrayList<>();

        for(StudentDto dto : list) {
            String name = dto.getName();
            int age = dto.getAge();
            int score = dto.getScore();

            StudentDto studentDto = new StudentDto(name, age, score);
            copyList.add(studentDto);
        }

        return copyList;
    }

    public List<StudentDto> findbyNameContaining(String searchWord) {
        List<StudentDto> newList = new ArrayList<>();
        for(StudentDto dto : list) {
            if(dto.getName().contains(searchWord)) {
                String name = dto.getName();
                int age = dto.getAge();
                int score = dto.getScore();

                StudentDto studentDto = new StudentDto(name, age, score);
                newList.add(studentDto);
            }
        }

        return newList;
    }
    public int removeByName(String removeName) {
        int removeCount = 0;

        Iterator<StudentDto> iterator = list.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getName().equals(removeName)) {
                iterator.remove();
                removeCount++;
            }
        }

        return removeCount;
    }

    public void saveToFile() {
        File file = new File("C:\\Temp\\stm.dat");

        try(FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos)
        ) {
                // 파일 포맷 = 메타데이터(헤더) + RAW DATA

                // 헤더(메타데이터) ------ 시작
                // 대부분의 파일은 시그니처를 넣어서 해당파일이 맞는지 확인
                // 시그니처
                dos.writeByte('S');
                dos.writeByte('T');
                dos.writeByte('M');

                dos.writeInt(list.size()); // 파일에 몇명의 학생이 존재하는지,
                // 헤더(메타데이터) ------- 끝
                // RAW DATA
                for(StudentDto studentDto : list) {
                    dos.writeUTF(studentDto.getName());
                    dos.writeInt(studentDto.getAge());
                    dos.writeInt(studentDto.getScore());
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        File file = new File("C:\\Temp\\stm.dat");
        if(!file.exists()) {
            return;
        }

        try(FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
        ) {
            // 시그니처 확인
            if(dis.readByte() != 'S' || dis.readByte() != 'T' || dis.readByte() != 'M') {
                IoManager.print("지원되지 않는 파일이거나, 파일이 깨졌습니다.");
                return;
            }

            // 카운트 확인
            int count = dis.readInt();

            // RAW DATA 읽기
            for(int i = 0; i < count; i++) {
                String name = dis.readUTF();
                int age = dis.readInt();
                int score = dis.readInt();

                list.add(new StudentDto(name, age, score));
            }

            IoManager.println("파일이 정상적으로 로드 되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

