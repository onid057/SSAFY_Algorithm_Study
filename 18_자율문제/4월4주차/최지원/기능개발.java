/* 
 * 진도가 100%일때 서비스에 반영, 
 * 개발 속도는 모두 다르고(뒤에 있는 기능이 먼저 개발된 후 앞의 기능이 배포될 때 함께 배포됨)
 * progresses 배포 순서대로, 몇% 진행되었는가
 * speeds 하루에 몇% 개발이 가능한지
 * 각 배포마다 몇개의 기능이 배포되는가
 * 배포는 하루에 한 번 하루 끝에.
 */

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>(); //작업 완료된 개수를 저장하는 queue 생성(ArrayDeque로 생성)
        int len = progresses.length; 작업 배열의 길이
        int[] left = new int[len]; //작업 완료까지 남은 일 수
        for (int i = 0; i < len; i++) {
            left[i] = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
        } //작업 완료까지 남은 일 수 계산 = (남은 작업 진행률 / 작업 속도 ) ceil 올림
        int cnt = 0; //작업 완료된 개수를 셀 때
        int max = left[0]; //현재까지의 최대 작업 완료까지 남은 일 수(처음 작업 값으로 초기화)
        
        for (int i = 0; i <len; i++) { //각 작업을 순회하며
            if (left[i] <= max) { 
                cnt++; //현재 작업 완료까지 남은 일 수가 최대값보다 작거나 같으면 카운트 증가
            } else {
                answer.add(cnt); //현재까지 완료된 개수 추가
                cnt = 1;
                max = left[i]; //최대 작업 완료까지 남은 일 수 갱신
            }
        }
        
        answer.add(cnt); //마지막으로 계산된 카운트 큐에 추가
        return answer.stream().mapToInt(Integer::intValue).toArray();
        //큐를 배열로 변환하여 return
    }
}
// __ .stream() = 스트림으로 변환한다
// .mapToInt() = 특정 자료형으로 매핑하여 새로운 스트림을 생성하겠다(여기서는 int 현식으로 매핑)
// Integer::intValue = Integer객체를 int로 변환하는 메서드 레퍼런스

/* mapToInt(Integer::intValue)와 mapToInt(Integer::parseInt) 차이
 * 
 * Integer::intValue
 * Integer 클래스의 인스턴스 메서드인 intValue()를 참조(Integer 객체를 int 값으로 변환)
 * mapToInt(Integer::intValue)= 각 요소가 이미 Integer 객체인 경우에만 해당 객체를 정수로 변환
 *
 * Integer::parseInt
 * Integer 클래스의 정적 메서드인 parseInt(String s)를 참조(문자열을 파싱하여 해당하는 정수를 반환)
 * mapToInt(Integer::parseInt)= 각 요소를 String으로 변환, Integer.parseInt()로 문자열을 정수로 변환
 */
