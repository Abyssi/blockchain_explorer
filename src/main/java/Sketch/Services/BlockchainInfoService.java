package Sketch.Services;

import Sketch.Model.Wallet;
import Sketch.Utils.FileCache;
import Sketch.Utils.HttpUtils;
import Sketch.Utils.ListUtils;
import processing.data.JSONArray;
import processing.data.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BlockchainInfoService {
    private static BlockchainInfoService instance;

    private FileCache cache;

    public BlockchainInfoService() {
        this.cache = new FileCache("cache/");
    }

    public static BlockchainInfoService getInstance() {
        return instance == null ? instance = new BlockchainInfoService() : instance;
    }

    public Wallet getWallet(String address) {
        Wallet wallet = new Wallet(address);
        try {
            String response = cache.getOrPut(address, () -> HttpUtils.Get("https://blockchain.info/it/rawaddr/" + address + "?filter=1"));
            JSONObject jsonObject = JSONObject.parse(response);
            wallet.setTotalReceived(jsonObject.getDouble("total_received") / 100000000);
            JSONArray txs = jsonObject.getJSONArray("txs");
            List<String> txnAddrs = new ArrayList<>();
            for (int i = 0; i < txs.size(); i++) {
                JSONObject tx = txs.getJSONObject(i);
                JSONArray out = tx.getJSONArray("out");
                for (int j = 0; j < out.size(); j++) {
                    JSONObject txn = out.getJSONObject(j);
                    if (!txn.getBoolean("spent"))
                        continue;
                    String addr = txn.getString("addr");
                    txnAddrs.add(addr);
                }
            }
            txnAddrs = ListUtils.RemovingDuplicates(txnAddrs);
            wallet.setOutAddresses(txnAddrs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return wallet;
    }
}
