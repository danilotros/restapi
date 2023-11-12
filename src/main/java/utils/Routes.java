package utils;

public enum Routes {
    BASE_URL("https://reqres.in"),
    CREATE_USER("/api/users"),
    GET_SINGLE_USER("/api/users/2")
    ;
    private String url;

    Routes(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
