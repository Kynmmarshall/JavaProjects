public class Threads{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1 + " Good morning!");
        }
        Monday obj1 = new Monday();
        Tuesday obj2 = new Tuesday();
        //timer obj3 = new timer();
        //obj3.run();
        System.out.println();
        obj1.start();
        System.out.println();
        obj2.start();
        obj1.setPriority(0);
        obj2.setPriority(1);
    }
}

class Monday extends Thread{
    @Override
     public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1 + " Monday!");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("error M");
            }
        }
    }
}

class Tuesday extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1 + " Tuesday!");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error M");
            }
        }
    }
}

class timer extends Thread{
    int j=99;

    @Override
    public void run(){
        while (j>0) {
            System.out.printf("\rTime remaining: "+j);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            j--;
        }
    }
}
