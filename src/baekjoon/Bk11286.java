package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Bk11286 implements Comparator<Integer> {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /*//우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            //절대값 작은 데이터가 우선
            int frist_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            //절대값이 같은 경우 음수 우선
            if (frist_abs == second_abs) {
                return o1 > o2 ? 1 : -1; //  o1>o2 이 조건식이 맞으면 앞에 : 틀리면 뒤에
            }
            return frist_abs - second_abs; // 앞이 크면 양수 뒤에가 크면 음수 이기 때문에 그것으로 스왑을 하냐 안하냐를 판단
        }); */  //함수표현식 람다식표현 최신이긴한데 미리 알필요없음

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //절대값 작은 데이터가 우선
                int frist_abs = Math.abs(o1);
                int second_abs = Math.abs(o2);
                //절대값이 같은 경우 음수 우선
                if (frist_abs == second_abs) {
                    return o1 > o2 ? 1 : -1; //  o1>o2 이 조건식이 맞으면 앞에 : 틀리면 뒤에
                }
                return frist_abs - second_abs; // 앞이 크면 양수 뒤에가 크면 음수 이기 때문에 그것으로 스왑을 하냐 안하냐를 판단
            }
        });

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(input);
            }
        }
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }

    @Override
    public Comparator<Integer> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Integer> thenComparing(Comparator<? super Integer> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Integer> thenComparing(Function<? super Integer, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Integer> thenComparing(Function<? super Integer, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Integer> thenComparingInt(ToIntFunction<? super Integer> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Integer> thenComparingLong(ToLongFunction<? super Integer> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Integer> thenComparingDouble(ToDoubleFunction<? super Integer> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
