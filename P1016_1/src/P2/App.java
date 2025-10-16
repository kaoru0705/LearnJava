package P2;

public class App {
    public static void main(String[] args) {
        new 식사().식사하다();
    }
}

 class 식사 {

    public void 식사하다() {
        재료를준비하다();
        요리를한다();
        음식을먹는다();
    }
    
    private void 재료를준비하다() {
        마트갈준비를하다();
        마트에가다();
        재료를구입하다();
        마트에서돌아온다();
    }

    private void 마트갈준비를하다() {}
    private void 마트에가다() {}
    private void 재료를구입하다() {};
    private void 마트에서돌아온다() {};

    private void 요리를한다() {}
    private void 음식을먹는다() {}
 }