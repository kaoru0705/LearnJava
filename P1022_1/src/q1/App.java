package q1;
import java.util.*;

public class App {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        Solution s = new Solution();
        System.out.println(s.solution(id_list, report, k));
    }
}   


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        Map <String, int[]> reportMap = new HashMap<> ();
        Map<String, Integer> idMap = new HashMap<> ();
        int idLength = id_list.length;

        for(int i = 0; i < idLength; i++) {
            idMap.put(id_list[i], i);
            reportMap.put(id_list[i], new int[idLength]);
        }

        for(String reportElement : report) {
            String[] reportArr = reportElement.split(" ");
            int reportedIndex = idMap.get(reportArr[1]);

            int[] arr = reportMap.get(reportArr[0]);
            if(arr[reportedIndex] == 0) arr[reportedIndex] = 1;
        }

        int[] reportSum = new int[idLength];
        for(int i = 0; i < idLength; i++) {
            reportSum[i] += reportMap.get(id_list[i])[i];
        }
        
        
        return answer;
    }
}