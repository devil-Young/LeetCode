package 面试;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: Young
 * @Date: 2025/11/28 01:22
 */
public class TextCompletableFuture {


    /**
     * @Author: Young
     * @Date: 2025/11/19 02:01
     */

    interface ProductDataSource {

        String getType();

        Map<String, Object> getField(String pId);
    }


    class PDSA implements ProductDataSource {

        @Override
        public String getType() {
            return "PDSA";
        }

        @Override
        public Map<String, Object> getField(String pId) {
            // connect select ...
            return Map.of();  // 空 map
        }
    }



    class ProductDataHandler {

        private final List<ProductDataSource> dataSourceList = new ArrayList<>();

        public void register(ProductDataSource ds) {
            dataSourceList.add(ds);
        }

        public Map<String, Object> getField(String pId) {

            Map<String, Object> allData = new HashMap<>();

            // 并发执行所有数据源查询
            List<CompletableFuture<Void>> futures = dataSourceList.stream()
                    .map(ds ->
                            CompletableFuture
                                    .supplyAsync(() -> ds.getField(pId))
                                    .thenAccept(allData::putAll)

                    )
                    .toList();
            // 等待全部完成
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

            return allData;
        }
    }

}
