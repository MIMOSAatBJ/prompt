package gctest;

import java.lang.ref.WeakReference;

/**
 * Created by killer on 2018-04-12.
 */
public class EscapeGc {
    public  static EscapeGc save_hook=null;
//    public  void isAlive(){
//        System.out.println("yes im still alive");
//    }
//
//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//        System.out.println("finalize execute");
//        save_hook=this;
//    }

    public static void main(String[] args) throws Exception {
//        save_hook = new EscapeGc();
//        save_hook=null;
//        System.gc();
//        Thread.sleep(500);
//        if (save_hook!=null){
//            save_hook.isAlive();
//        }else {
//            System.out.println("i m dead");
//        }
//        save_hook=null;
//        System.gc();
//        Thread.sleep(500);
//        if (save_hook!=null){
//            save_hook.isAlive();
//        }else {
//            System.out.println("i m dead");
//        }
        WeakReference<String> weakReference = new WeakReference<String>("string");
        System.out.println(weakReference.enqueue());
    }
}
