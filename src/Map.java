//import java.util.ArrayList;

public class Map {

   //private ArrayList<MyPair> map;
   private List key;
   private List value;
   private int size = 0;

   /*public Map(MyPair[] arr, int size){
      this.size=size;
      map = new MyList(arr, size);
   }*/
   public Map(Object[] key_, Object[] value_){
      int size = key_.length;
      for(int i=0;i< key_.length;i++) {
         for (int j = i + 1; j < key_.length; j++)
            if (key_[i].equals(key_[j])) {
               System.out.println("map не может иметь несколько одинаковых ключей!");
               System.exit(1);
            }
         if(key_[i].equals(null)){
            System.out.println("ключ не может иметь значение null!");
            System.exit(1);
         }
      }
      if(key_.length!= value_.length){
         System.out.println("количество значений не равно количеству ключей!");
         System.exit(1);
      }
      key = new List(key_);
      value = new List(value_);
      this.size = size;
   }
   public Map(){}

   private int getIndex(Object key_){
      for(int i=0; i<this.size; i++){
         if(key.get(i) == key_) {
            return i;
         }
      }
      return -1;
   }

   public void put(Object key_, Object value){
      int i = getIndex(key_);
      this.value.set(value,i);
   }
   public Object get(Object key_){
      int i = getIndex(key_);
      return value.get(i);
   }
   public Object get(Object key_, Object bydefault){
      int i = getIndex(key_);
      if(value.get(i)!=null){   //здесь вылетает ошибка, если заменить на if(!value.get(i).equals(null))
         return value.get(i);
      }
      else {
         value.set(bydefault,i);
         return bydefault;
            }
   }
   public Object remove(Object key_){
      int i = getIndex(key_);
      Object time = value.get(i);
      value.set(null,i);
      return time;
   }
   public boolean keyContains(Object key_){
      if(getIndex(key_)!=-1) { return true; }
      else { return false; }
   }
   public List getKeys(){
      return key;
   }
   public List getValues(){
      return value;
   }
   public List getEntries(){
      List map = new List();
      for(int i =0; i<size; i++){
         MyPair pair_ = new MyPair(key.get(i),value.get(i));
         map.add(pair_);
      }
      return map;
   }
   public int size(){
      return size;
   }
   public boolean isEmpty(){
      if(size==0) {return true;}
      else { return false; }
   }


}
