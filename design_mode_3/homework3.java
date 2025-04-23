package design_mode_3;
interface PlayerState {
    void play();
    void win();
    void lose();
}

class PrimaryState implements PlayerState {
    private Player player;

    public PrimaryState(Player player) {
        this.player = player;
    }

    @Override
    public void play() {
        System.out.println("入门级玩家进行游戏基本玩法");
    }

    @Override
    public void win() {
        player.addScore(1);
        System.out.println("入门级玩家胜利，增加1积分");
    }

    @Override
    public void lose() {
        player.subtractScore(1);
        System.out.println("入门级玩家失败，扣除1积分");
    }
}

class SecondaryState implements PlayerState {
    private Player player;

    public SecondaryState(Player player) {
        this.player = player;
    }

    @Override
    public void play() {
        System.out.println("熟练级玩家进行游戏基本玩法");
    }

    @Override
    public void win() {
        player.addScore(2);
        System.out.println("熟练级玩家胜利，积分加倍，增加2积分");
    }

    @Override
    public void lose() {
        player.subtractScore(2);
        System.out.println("熟练级玩家失败，积分加倍扣除，扣除2积分");
    }

    // 熟练级额外功能：积分加倍
    public void doubleScore() {
        System.out.println("熟练级玩家使用积分加倍功能");
    }
}

class ProfessionalState implements PlayerState {
    private Player player;

    public ProfessionalState(Player player) {
        this.player = player;
    }

    @Override
    public void play() {
        System.out.println("高手级玩家进行游戏基本玩法");
    }

    @Override
    public void win() {
        player.addScore(2);
        System.out.println("高手级玩家胜利，积分加倍，增加2积分");
    }

    @Override
    public void lose() {
        player.subtractScore(2);
        System.out.println("高手级玩家失败，积分加倍扣除，扣除2积分");
    }
    public void doubleScore() {
        System.out.println("高手级玩家使用积分加倍功能");
    }
    public void changeCards() {
        System.out.println("高手级玩家使用换牌功能");
    }
}
class FinalState implements PlayerState {
    private Player player;

    public FinalState(Player player) {
        this.player = player;
    }

    @Override
    public void play() {
        System.out.println("骨灰级玩家进行游戏基本玩法");
    }

    @Override
    public void win() {
        player.addScore(2);
        System.out.println("骨灰级玩家胜利，积分加倍，增加2积分");
    }

    @Override
    public void lose() {
        player.subtractScore(2);
        System.out.println("骨灰级玩家失败，积分加倍扣除，扣除2积分");
    }
    public void doubleScore() {
        System.out.println("骨灰级玩家使用积分加倍功能");
    }
    public void changeCards() {
        System.out.println("骨灰级玩家使用换牌功能");
    }
    public void peekCards() {
        System.out.println("骨灰级玩家使用偷看他人牌功能");
    }
}
class Player {
    private PlayerState state;
    private int score;

    public Player() {
        // 初始化为入门级状态
        this.state = new PrimaryState(this);
        this.score = 0;
    }

    // 根据积分切换状态
    public void updateState() {
        if (score < 10) {
            state = new PrimaryState(this);
        } else if (score < 20) {
            state = new SecondaryState(this);
        } else if (score < 30) {
            state = new ProfessionalState(this);
        } else {
            state = new FinalState(this);
        }
    }

    public void play() {
        state.play();
    }

    public void win() {
        state.win();
        updateState();
    }

    public void lose() {
        state.lose();
        updateState();
    }

    public void addScore(int increment) {
        score += increment;
        System.out.println("当前积分：" + score);
    }

    public void subtractScore(int decrement) {
        score -= decrement;
        if (score < 0) {
            score = 0;
        }
        System.out.println("当前积分：" + score);
    }
}

public class homework3 {
    public static void main(String[] args) {
        Player player = new Player();
        player.play();
        player.win();
        player.play();
        player.lose();
        // 模拟多次游戏操作，让玩家升级到不同状态
        for (int i = 0; i < 20; i++) {
            player.win();
        }
        player.play();
        SecondaryState secondaryState = new SecondaryState(player);
        secondaryState.doubleScore();
        ProfessionalState professionalState = new ProfessionalState(player);
        professionalState.changeCards();
        FinalState finalState = new FinalState(player);
        finalState.peekCards();
    }
}
