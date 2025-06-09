interface GPT {
    public String use(String a);
}

class OpenAI implements GPT{
    public String use(String a) {
        login();
        return a + "님 안녕하세요";
    }
    private void login() {
        System.out.println("log : 로그인");
    }
}

public class Cal {

    GPT api;

    public Cal(GPT api) {
        this.api = api;
    }

    String getContext(String user) {
        return api.use(user);
    }
}
