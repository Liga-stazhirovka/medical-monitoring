package liga.medical.medicalmonitoring.core.anti_SOLID;

public class AntiL {
    class Bird{
        public void fly(){
            //fly
        }
    }
    // здесь нарушения нет т.к при подстановке Bird на Duck функионал не нарушен
    class Duck extends Bird{
        @Override
        public void fly() {
            // fly
        }
    }

    //Нарушение подстановки т.е при подстановки Bird на Chicken будет непредсказуемое повидение
    class Chicken extends Bird{
        @Override
        public void fly() {
            // don't fly - другое поведение
            //Или метод выбрасывает исключение, хотя родительский класс не подразумевает этого
            throw new IllegalArgumentException();
        }
    }
}
