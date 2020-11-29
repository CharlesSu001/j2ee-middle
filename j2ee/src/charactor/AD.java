package charactor;

public interface AD {
    //物理伤害
    void physicAttack();//空方法，没有方法体

    default void attack() {
        System.out.println("AD默认方法");
    }
}
