package charactor;

public interface AP {
    void magicAttack();
    default void attack(){
        System.out.println("AP默认方法");
    }
}
