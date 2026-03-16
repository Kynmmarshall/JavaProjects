public class threadExerciseCA1 {
    public static void main(String[] args) {
        TeacherAnnouncement teacher = new TeacherAnnouncement();
        StudentAnnoucement student = new StudentAnnoucement();
        AdminAnnoucement admin = new AdminAnnoucement();
        
        admin.start();
        teacher.start();
        student.start();
        
        admin.setPriority(Thread.MAX_PRIORITY);
        teacher.setPriority(Thread.NORM_PRIORITY);
        student.setPriority(Thread.MIN_PRIORITY);
        
    }
}

class TeacherAnnouncement extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Class will start soon");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("an error occures");
            }
        }
    }
}

class StudentAnnoucement extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Submitting assignment");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("an error occures");
            }
        }
    }
}

class AdminAnnoucement extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("School meeting at 2 PM");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("an error occures");
            }
        }
    }
}