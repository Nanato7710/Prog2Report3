package jp.ac.uryukyu.ie.e245735;

/**
 * LivingThingクラス。
 * String name; //名前
 * int hitPoint; //HP
 * int attack; //攻撃力
 * boolean dead; //生死状態。true=死亡。
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * 生死状態を取得するgetterメソッド。
     * @return this.dead 生死状態
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * 名前を取得するgetterメソッド。
     * @return this.name 名前
     */
    public String getName() {
        return name;
    }

    /**
     * HPを取得するgetterメソッド。
     * @return this.hitPoint HP
     */
    public int getHitPoint() {
        return hitPoint;
    }

    /**
     * HPを設定するsetterメソッド。
     * @param hitPoint HP
     */
    protected void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    /**
     * 生死状態を設定するsetterメソッド。
     * @param dead 生死状態
     */
    protected void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * 攻撃力を取得するgetterメソッド。
     * @return this.attack 攻撃力
     */
    public int getAttack() {
        return attack;
    }

    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(LivingThing opponent) {
        if (dead) {
            return;
        }
        int damage = (int) (Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
        opponent.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けるダメージ
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint <= 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
