import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        //Object[] a = {1,2,3,5,6,7,8,9,10};
        Object[] a = {'a','b','d','e','f','g','k','l','m'};
        List l = new List(a);
        System.out.println("начальный список:");
        System.out.println(Arrays.toString(a));
        System.out.println("созданный список:");
        System.out.println(l);

        System.out.println("добавление в конец:");
        //l.add(11);
        l.add('n');
        System.out.println(l);
        System.out.println("добавление по индексу:");
        //l.add(4,3);
        l.add('c',2);
        System.out.println(l);

        System.out.println("удаление:");
        Object t1 = l.remove(10);
        System.out.println(l);
        System.out.println(t1);
        Object t2 = l.remove(1);
        System.out.println(l);
        System.out.println(t2);

        System.out.println("получение:");
        Object t31 = l.get(2);
        Object t32 = l.get(3);
        Object t33 = l.get(4);
        Object t34 = l.get(8);
        System.out.println(t31);
        System.out.println(t32);
        System.out.println(t33);
        System.out.println(t34);

        System.out.println("размер:");
        System.out.println(l);
        Object t4 = l.size();
        System.out.println("size: " + t4);

        System.out.println("проверка на пустоту:");
        Object t5 = l.isEmpty();
        System.out.println(t5);

        System.out.println("проверка наличия элемента:");
        /*Object t61= l.contains(10);
        Object t62= l.contains(11);
        Object t63= l.contains(2);*/
        Object t61= l.contains('a');
        Object t62= l.contains('n');
        Object t63= l.contains('l');
        /*System.out.println("10: " + t61);
        System.out.println("11: " + t62);
        System.out.println("2: " + t63);*/
        System.out.println("a: " + t61);
        System.out.println("n: " + t62);
        System.out.println("l: " + t63);

        System.out.println("индекс по элементу:");
        /*Object t71=l.indexOf(10);
        System.out.println("10: " + t71);
        Object t72=l.indexOf(1);
        System.out.println("1: " + t72);
        Object t73=l.indexOf(13);
        System.out.println("13: " + t73);*/
        Object t71=l.indexOf('l');
        System.out.println("l: " + t71);
        Object t72=l.indexOf('m');
        System.out.println("m: " + t72);
        Object t73=l.indexOf('n');
        System.out.println("n: " + t73);

        //MyList<String> o = new MyList(a);

       /* MyPair p1 = new MyPair(0,0);
        MyPair p2 = new MyPair(1,1);
        MyPair p3 = new MyPair(2,3);
       // MyPair[] p = new MyPair[3];*/
        //p = MyPair({p1,p2,p3});
        /*for(int i=0; i<5; i++){
            p[i].inicilization(i,i);
        }*/
        Object[] k = {1,2,3,4,5};
        Object[] v = {11,12,13,14,15};
        Map m = new Map(k,v);
        m.put(1,9);
        System.out.println(m.size());
        System.out.println(m.remove(2));
        System.out.println(m.get(2,20));
        System.out.println(m.getEntries());
        System.out.println(m.getKeys());
        System.out.println(m.getValues());
        System.out.println(m.get(0));
        System.out.println(m.get(1));
        System.out.println(m.keyContains(10));
        System.out.println(m.keyContains(2));
        System.out.println("All Good!");

    }




}
