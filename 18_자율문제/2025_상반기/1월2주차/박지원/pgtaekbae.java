//프로그래머스 택배 배달과 수거 자바
//구현.. 절대 생각 못할듯,,

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0;
        int pickup = 0;
        for (int i = n - 1; i >= 0; i--) {
            deliver += deliveries[i];
            pickup += pickups[i];
            while (deliver > 0 || pickup > 0) {
                deliver -= cap;
                pickup -= cap;
                answer += (i + 1) * 2;
            }
        }
        return answer;
    }
}
