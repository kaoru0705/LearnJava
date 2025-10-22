package q1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        Solution s = new Solution();
        int[] answer = s.solution(id_list, report, k);
        System.out.println(Arrays.toString(answer));
    }
}   

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}


// class Solution {
//     public int[] solution(String[] id_list, String[] report, int k) {
//         int[] answer = {};
//         Map <String, int[]> reportMap = new HashMap<> ();
//         Map<String, Integer> idMap = new HashMap<> ();
//         int idLength = id_list.length;

//         for(int i = 0; i < idLength; i++) {
//             idMap.put(id_list[i], i);
//             reportMap.put(id_list[i], new int[idLength]);
//         }

//         for(String reportElement : report) {
//             String[] reportArr = reportElement.split(" ");
//             int reportedIndex = idMap.get(reportArr[1]);

//             int[] arr = reportMap.get(reportArr[0]);
//             if(arr[reportedIndex] == 0) arr[reportedIndex] = 1;
//         }

//         int[] reportSum = new int[idLength];
//         for(int i = 0; i < idLength; i++) {
//             for(int mapIndex = 0; mapIndex < reportMap.size(); mapIndex++) {
//                 reportSum[i] += reportMap.get(id_list[mapIndex])[i];
//             }
//         }

//         answer = new int[idLength];
//         for(int i = 0; i < idLength; i++) {
//             if(reportSum[i] < k) {
//                 continue;
//             }
//             for(int mapIndex = 0; mapIndex < reportMap.size(); mapIndex++) {
//                 if(reportMap.get(id_list[mapIndex])[i] == 1) {
//                     answer[mapIndex]++;
//                 }
//             }
//         }
//         return answer;
//     }
// }