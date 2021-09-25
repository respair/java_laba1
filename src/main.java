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
        System.out.println("List good");
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
        System.out.println("map good!");

        Tree tree = new Tree();
        Object[] obj = {5,8,10,9,3,4,1,7,11};
        for(int i = 0; i<9; i++) {
            Tree.Node n = tree.new Node(obj[i],i);
            tree.addChild(n);
            System.out.println(tree.getChild(i));
        }
        Tree.Node n = tree.new Node(8,1);
        n.printPath();
        Tree.Node n1 = tree.new Node(7,7);
        n1.printPath();
        Tree.Node n2 = tree.new Node(10,2);
        Tree.Node n4 = tree.new Node(11,8);
        Tree.Node n5 = tree.new Node(9,3);
        Tree.Node n8 = tree.new Node(3,4);
        Tree.Node n6 = tree.getChild(1);
        System.out.println("left child 8: "+ n6.leftChild());
        System.out.println("right child 8: "+ n6.rightChild());
        System.out.println("-> " +n1.findParent(n4));
        System.out.println("-> " +n1.findParent(n1));
        System.out.println("-> " +n1.findParent(n8));
        List l2 = tree.toList();
        System.out.println("get: "+tree.getChild(4));
        System.out.println("find: "+tree.find(3));
        System.out.println("size: "+tree.size());
        System.out.println(l2.get(0));
        System.out.println(l2.get(1));
        System.out.println(l2.get(2));
        Tree tr = n6.subtree();
        System.out.println("size subtree: "+tr.size());
        System.out.println("subtree: "+tr.toList());

        System.out.println("Parent 8: " + n.getParent());
        System.out.println("Parent 7: " + tree.getParent(n1));
        System.out.println("get: " + tree.getChild(5));
        System.out.println("remove: "+tree.removeChild(5));
        System.out.println("find remove element: "+tree.find(4));
        System.out.println("Parent: " + tree.getParent(n1));
        System.out.println("remove: "+tree.removeChild(n));
        System.out.println("find remove element: " +tree.find(8));
        System.out.println("size: "+tree.size());
        System.out.println(tree.toList());
        System.out.println("Parent: " + tree.getParent(n1));
        System.out.println("Parent: " + tree.getParent(n2));
        System.out.println("find: "+tree.find(11));
        System.out.println("get: " + tree.getChild(8));
        System.out.println("find: "+tree.find(7));
        System.out.println("get: " + tree.getChild(7));
        System.out.println("Parent: " + tree.getParent(n2));
        System.out.println("Parent: " + tree.getParent(n5));

        Object r = 12;
        Tree.Node nr = tree.new Node(r,11);
        tree.addChild(nr);
        System.out.println(tree.getChild(11));

        Tree.Node n7 = tree.getChild(3);
        System.out.println("left child 8: "+ n6.leftChild());
        System.out.println("right child 8: "+ n6.rightChild());
        Tree tr2 = n7.subtree();
        System.out.println("size subtree: "+tr2.size());
        System.out.println("subtree: "+tr2.toList());


       /* Tree4Index tree2 = new Tree4Index();
        Object[] obj2 = {'a','e','x','k','b','c','g','m','y'};
        int[] obj = {5,8,10,9,3,4,1,7,11};
        for(int i = 0; i<9; i++) {
            Tree4Index.Node n10 = tree2.new Node(obj2[i],obj[i]);
            tree2.addChild(n10);
            System.out.println(tree2.getChild(obj[i]));
        }

        System.out.println("find: "+tree2.find('c'));
        System.out.println("size: "+tree2.size());
        Tree4Index.Node n = tree2.new Node('e',8);
        n.printPath();
        Tree4Index.Node n1 = tree2.new Node('m',7);
        n1.printPath();
        System.out.println("Parent e: " + n.getParent());
        System.out.println("Parent m: " + tree2.getParent(n1));
        System.out.println(tree2.toList());
        Tree4Index.Node n6 = tree2.getChild(8);
        Tree4Index tr = n6.subtree();
        System.out.println("size subtree: "+tr.size());
        System.out.println("subtree: "+tr.toList());

        System.out.println("remove: "+tree2.removeChild(4));
        System.out.println("find remove element: "+tree2.find('c'));
        //System.out.println("Parent: " + tree.getParent(n1));
        System.out.println("remove: "+tree2.removeChild(n));
        System.out.println("find remove element: " +tree2.find('e'));
        System.out.println(tree2.toList());
*/
        System.out.println("tree good!");
    }

}
