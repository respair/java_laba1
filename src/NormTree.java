public class NormTree {

    private int count = 0;

    public class NNode {

        private int key; //ключ узла
        private Object data; //некоторые данные в узле
        private NNode firstChild = null; //потомок
        private NNode friendChild = null;
        private NNode parent = null; //parent

        public NNode getFirst(){
            return firstChild;
        }
        public NNode getFriend(){
            return friendChild;
        }

        @Override
        public String toString() {
            return "KEY: " + key + " DATA: " + data;
        }

        public NNode(Object data) {
            key = 0;
            this.data = data;
        }

        public void addChild(NNode item) {
            NNode n = this;
            NNode newNode = item;
            if (this.firstChild == null) {
                this.firstChild = newNode;
                this.firstChild.parent = this;
                count += 1;
               // reIndex(0, root);
            } else {
                n = n.firstChild;
                while (n.friendChild != null) {
                    n = n.friendChild;
                }
                n.friendChild = newNode;
                n.friendChild.parent = this;
                count += 1;
              //  reIndex(0, root);
            }
            reIndex(0, root);
        }

        public boolean removeChild(NNode value) {
            NNode n = this;
            if (n == null) return false;
            if (value == null) return false;
            NNode m = this;
            n = n.firstChild;
            //if (n == null) return false;
            if (m.data.equals(value.data) && m.key == value.key && m.parent != null) { return removeChild(m.parent); }
           // else if (m.data == value.data && m.key == value.key){
               // System.out.println("вы собираетесь удалить узел дерева,"+tree.size());
            //}
            else if (m.data.equals(value.data) && m.key == value.key && m.parent == null) {
               // System.out.println("!!!!!!!!!!!!");
                //System.out.println(m);
                m = m.firstChild;
                //System.out.println(m);
                if(m==null){
                    count--;
                    return true;
                }
                m.parent = null;
                NNode k = m.friendChild;
                while (k != null) {
                    k.parent = m;
                    k = k.friendChild;
                }
                if (m.firstChild == null) {
                    m.firstChild = m.friendChild;
                } else {
                    NNode mm = m.firstChild;
                    while (mm.friendChild != null)
                        mm.friendChild = mm.friendChild.friendChild;
                    mm.friendChild = m.friendChild;
                }

                m.friendChild = null;
                count -= 1;
                this.firstChild = m.firstChild;
                this.friendChild = m.friendChild;
                this.data = m.data;
                this.parent=m.parent;
                reIndex(0, root);
                return true;
            }
            if (n == null) {return false;}
            while ((!n.data.equals(value.data)) && n.key != value.key) {
                m = n;
                n = n.friendChild;
                if (n == null) {return false;}
            }
            m.friendChild = n.friendChild;
            if (n.firstChild != null) {
               // NNode c = m.friendChild;
                while (m.friendChild != null) {
                    m.friendChild = m.friendChild.friendChild;
                }
              //  NNode c = m.friendChild;
                m.friendChild = n.firstChild;
                m.friendChild.parent = this;
                NNode c = n.firstChild.friendChild;
                while (c != null) {
                    c.parent=this;
                    c=c.friendChild;
                }
            }
            count -= 1;
            reIndex(0, root);
            return true;
        }

        public NNode getChild(int index) {
            if (index < 0) {return null;}
            if (this.firstChild == null) {return null;}
            if (index == 0) {return this.firstChild;}
            int i = 1;
            NNode n = this.firstChild.friendChild;
            while (n != null) {
                if (index == i) {return n;}
                i++;
                n = n.friendChild;
            }
            return null;
        }

        public boolean removeChild(int index) {
            NNode node = this.getChild(index);
            return this.removeChild(node);

        }
        public NNode getParent(){
            return this.parent;
        }
        public List path(){
            List l = new List();
            NNode n = this.getParent();
            if(n==null){
                l.add(this);
                return l;
            }
            l.add(n);
            if(n.firstChild.key==this.key){
                l.add(this);
                return l;
            }
            n=n.firstChild;
            l.add(n);

            n=n.friendChild;
            if(n.key!=this.key) {l.add(n);}
            while(n.key!=this.key){
                n=n.friendChild;
                l.add(n);
            }
            l.add(this);
            return l;
        }
        public NormTree subtree(){
            NNode n = this;
            n.parent=null;
            n.friendChild = null;
            NormTree tree = new NormTree(n);
            return tree;

        }
        public NNode findParent(NNode another){
            List l = new List();
            l.add(this.key);
            List an = new List();
            an.add(another.key);
            NNode node = this;
            NNode a = another;
            while(node.parent!=null){
                l.add(node.parent.key);
                node=node.parent;
            }
           // System.out.println("l: "+l);
            while(a.parent!=null){
                an.add(a.parent.key);
                a=a.parent;
            }
          //  System.out.println("an: "+an);
            for(int i =0; i<l.size();i++)
                for(int j=0;j<an.size();j++){
                    if(an.get(j).equals(l.get(i))){
                        if((int)an.get(j) ==this.key) {return this.getParent();}
                        else if((int)an.get(j) == another.key) {return another.getParent();}
                        else { return NormTree.this.getChildTree((int)an.get(j));}
                    }
                }
            return null;
        }
    }
        private NNode root;

        public NormTree(NNode node) {
            root = node;
            if(node.firstChild!=null) {
                count = count - node.firstChild.key + 1;
            }
            else {count = 1;}
        }

        public NormTree(Object value) {
            root = new NNode(value);
            count=1;
        }

        private void reIndex(int index, NNode node) {
            if (root == null) {return;}
            NNode new_ = node;
            NNode n = node;
            node.key = index;
            while (new_.friendChild != null) {
                index++;
                new_=new_.friendChild;
                new_.key = index;
               // reIndex(index, new_.friendChild);
            }

            while(n!=null) {
                if (n.firstChild != null) {
                    index++;
                    reIndex(index, n.firstChild);
                    n = n.friendChild;
                }
                else n=n.friendChild;
            }
          /*  while(n.friendChild!=null && n.firstChild!=null){
                index++;
                reIndex(index,n.friendChild.firstChild);
            }*/
            //index++;
        }

        public boolean removeChildTree(NNode value) {
            NNode n = value.parent;
            if (n == null) {
                root = root.firstChild;
                root.parent = null;
                NNode k = root.friendChild;
                while (k != null) {
                    k.parent = root;
                    k = k.friendChild;
                }
                if (root.firstChild == null) {
                    root.firstChild = root.friendChild;
                } else {
                    NNode m = root.firstChild;
                    while (m.friendChild != null)
                        m.friendChild = m.friendChild.friendChild;
                    m.friendChild = root.friendChild;
                }

                root.friendChild = null;
                count -= 1;
                reIndex(0, root);
                return true;
            }
            return n.removeChild(value);
        }

    public List toList(){
            List l = new List();
          for(int i=0;i<count;i++)
              l.add(getChildTree(i));
          return l;
    }
    private NNode getChildTree_(int index, int index2, NNode node){
        if (node.key == index)
            return node;
        NNode n = node;
        if (n.friendChild != null) {
            index2++;
            node = getChildTree_(index, index2, n.friendChild);
            if (node.key == index) {
                return node;
            }
        }
        if (n.firstChild != null) {
            index2++;
            node = getChildTree_(index,  index2, n.firstChild);
            if (node.key == index) {
                return node;
            }
        }

        return node;
    }

    public NNode getChildTree(int index) {
        if (root==null){ return null;}
        if (index < 0 || index >=count){ return null;}
        if(index==0) {return root;}
        NNode n = getChildTree_(index, 0, root);
        if(n.key==index) {return n;}
        else {return null;}
    }
    private NNode find_(Object value, NNode node){
        if (node.data.equals(value)) {
            return node;
        }
        NNode n = node;
        if (n.friendChild != null) {
            node = find_(value, n.friendChild);
            if (node.data.equals(value)) {
                return node;
            }
        }
        if (n.firstChild != null) {
            node = find_(value, n.firstChild);
            if (node.data.equals(value)) {
                return node;
            }
        }

        return node;
    }
    public NNode find(Object value){
            if(root==null) {return null;}
            if(root.data==value) {return root;}
            NNode n = find_(value,root);
        if(n.data.equals(value)) { return n;}
        else{ return null;}
    }
    public int size(){
            return count;
    }
    public boolean isEmpty(){
            if(count==0) {return true;}
            else {return false;}
    }
}

