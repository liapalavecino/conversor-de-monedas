import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = gson.toJson("Hola, soy un commit");
        System.out.println(json);
    }
}
