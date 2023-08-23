import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int count = 1;
        char previousChar = chars[0];
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a-> -a.count));
        if(chars.length == 1){
            priorityQueue.add(new Pair(chars[0], 1));
        }
        for (int i = 1; i < chars.length; i++) {
            char curChar = chars[i];
            if(curChar != previousChar){
                priorityQueue.add(new Pair(previousChar, count));
                count = 1;
                previousChar = curChar;
                if(i == chars.length - 1){
                    priorityQueue.add(new Pair(previousChar, 1));
                }
            }else if (i == chars.length - 1){
                count++;
                priorityQueue.add(new Pair(previousChar, count));

            }else count++;

        }

        StringBuilder sb = new StringBuilder();
        char previouslyAdded = ' ';
        while (!priorityQueue.isEmpty()){
            Pair temp = priorityQueue.poll();
            if(temp.ch != previouslyAdded){
                sb.append(temp.ch);
                temp.count--;
                previouslyAdded = temp.ch;
                if(temp.count != 0){
                    priorityQueue.add(temp);
                }
            } else if (temp.ch == previouslyAdded) {
                if(priorityQueue.isEmpty()){
                    return  "";
                } else {
                    Pair temp2 = priorityQueue.poll();
                    sb.append(temp2.ch);
                    temp2.count--;
                    previouslyAdded = temp2.ch;
                    if(temp2.count != 0){
                        priorityQueue.add(temp2);
                    }
                    priorityQueue.add(temp);
                }
            }
        }
        return sb.toString();
    }
}
class Pair{
    char ch;
    int count;

    public Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "ch=" + ch +
                ", count=" + count +
                '}';
    }
}
