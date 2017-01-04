import com.codecool.lottery.controller.LotteryAPIController;
import com.codecool.lottery.service.APIService;

import java.util.HashMap;

import static spark.Spark.*;
/**
 * Created by patrik on 2017.01.03..
 */
public class Main {

    private static final int PORT = 9000;

    public static void main(String[] args) {

        HashMap<String, String> hash = new HashMap();
        hash.put("anyad", "apad");
        hash.put("fradi", "ujpest");
        hash.put("juhu", "huhuu");

        LotteryAPIController lofasz = new LotteryAPIController(APIService.getInstance());
        System.out.println(lofasz.getWinner(hash));

    }

}
