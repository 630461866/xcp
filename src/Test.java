import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {



    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("zs");
        int zs1 = list.indexOf("zs");
        System.out.println(zs1);

        List list1 = new LinkedList();
        list1.add("1");
        list1.add("2");
        list1.add("zs");
        int zs = list1.indexOf("zs");
        System.out.println(zs);

        AbstractSequentialList a = new LinkedList();
//        a.linkFirst();  用不了


        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(98);
        scores.add(77);
        scores.add(66);
        scores.add(89);
        scores.add(79);
        scores.add(50);
        scores.add(100);
        System.out.println(scores);


        //错误做法  这样遍历成功一个数据后,后面的数据会往前进一步导致直接跳过该数据遍历到下一个数据
//        for(int i= 0; i < scores.size(); i++){
//            int score = scores.get(i);
//            if(score < 80){
//                //删除低于80的分数
//                scores.remove(i);
//            }
//        }
//



        //正确做法  每遍历完一个索引,回退一步,这样可以避免跳过进位的数据
//        for(int i = 0; i < scores.size(); i++){
//            int score = scores.get(i);
//            if (score < 80){
//                scores.remove(i);
//                i--;//删除成功后必须退一步,这样可以保证下次回到这个位置,这样就不会跳过数据
//            }
//        }

        //从后面往前遍历
        for(int i = scores.size() - 1; i >= 0; i--){
            int score = scores.get(i);
            if (score < 80){
                scores.remove(i);
            }
        }
        System.out.println(scores);


        //ConcurrentModificationException  ConcurrentModificationException异常与modCount这个变量有关。
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        for (String item : strings){
            if("2".equals(item)){
                strings.remove(item);
            }
        }
        System.out.println(strings.toString());

    }

}
